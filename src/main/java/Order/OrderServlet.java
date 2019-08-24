package Order;

import ShoppingCart.Cart;
import ShoppingCart.CartItem;
import TOOLs.BaseServlet;
import TOOLs.CommonUtils;
import User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        从session域中得到cart对象
        使用cart对象生成order对象
        调用service方法完成添加订单
        保存order到request域中
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Order order = new Order();
        order.setOid(CommonUtils.uuid());//设置订单号
        order.setOrdertime(new Date());
        order.setState(1);//刚下单时为未付款状态
        User user = (User) request.getSession().getAttribute("session_user");
        order.setOwner(user);
        order.setTotal(cart.getTotal());

        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartItem cartItem : cart.getCartitems()) {
            OrderItem oi = new OrderItem();//创建订单条目
            oi.setIid(CommonUtils.uuid());
            oi.setCount(cartItem.getCount());
            oi.setGoods(cartItem.getGoods());
            oi.setSubtotal(cartItem.getSubtotal());
            oi.setOrder(order);
            orderItemList.add(oi);//将订单条目添加到集合中
        }
        //将所有的订单条目添加进订单中
        order.setOrderItemList(orderItemList);
        cart.clear();//清空购物车

        orderService.add(order);

        request.setAttribute("order", order);
        return "f:/JSP/JSPs/order/desc.jsp";
    }

    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        从session域中得到当前用户，即得到用户uid
        使用uid调用orderService中的方法得到该用户的所有订单
        将订单列表保存到request域中，转发到JSP/JSPs/order/list
         */
        User user = (User) request.getSession().getAttribute("session_user");
        List<Order> orderList = orderService.myOrders(user.getUid());
        request.setAttribute("orderList", orderList);
        return "f:/JSP/JSPs/order/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("order", orderService.load(request.getParameter("oid")));
        return "f:/JSP/JSPs/order/desc.jsp";
    }

    //确认收货
    public String confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        try {
            orderService.confirm(oid);
            request.setAttribute("msg", "确认成功，交易完成!");
        } catch (OrderException e) {
            request.setAttribute("msg", e.getMessage());
        }
        return "f:/JSP/msg.jsp";
    }

    public String pay(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String oid = request.getParameter("oid");
        Order order = orderService.load(oid);
        request.setAttribute("order", order);
        String filePath = orderService.pay(order);
        request.setAttribute("filePath", filePath);
        return "f:/JSP/JSPs/order/newPay.jsp";
    }

    public void back(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, OrderException {
        boolean b = false;
        System.out.println("back");
        String trade_status = request.getParameter("trade_status");//返回的订单状态
        String out_trade_no = request.getParameter("out_trade_no");//返回订单编号

        Order order = orderService.load(out_trade_no);
        if (order == null) {
            request.setAttribute("msg", "订单不存在，无法完成付款！");
        }
        if (trade_status.equals("WAIT_BUYER_PAY")) {
            System.out.println("WAIT_BUYER_PAY");
        }
        if (trade_status.equals("TRADE_SUCCESS")) {
            System.out.println("TRADE_SUCCESS");
            orderService.confirm(order.getOid());
            b = true;
            response.getWriter().print(b);
        } else {
            b = false;
            response.getWriter().print(b);
        }
    }

    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oid = request.getParameter("oid");
        int state = orderService.findState(oid);
        if (state == 2) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }
}
