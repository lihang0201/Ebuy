package Order;

import TOOLs.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderServlet",urlPatterns = "/admin/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查询所有的订单，调用service方法
         * */

        List<Order> orderList = orderService.findAll();
        request.setAttribute("orderList", orderList);
        return "f:/JSP/admin/admin/order/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        Order order = orderService.load(oid);
        request.setAttribute("order", order);
        request.setAttribute("btn", request.getParameter("btn"));

        return "f:/JSP/admin/admin/order/desc.jsp";
    }

    public String findByState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state =  request.getParameter("state");
        List<Order> orderList = orderService.findByState(state);
        request.setAttribute("orderList", orderList);
        return "f:/JSP/admin/admin/order/list.jsp";
    }

    /**
     * 发货
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        /*
         * 更改订单状态
         * */
        if (orderService.findState(oid) != 2) {
            request.setAttribute("msg", "订单状态错误，请查证后再进行处理!");
        }
        try {
            orderService.confirm( "3");
            request.setAttribute("oid", oid);
            return load(request, response);
        } catch (OrderException e) {
            request.setAttribute("msg","修改失败！");
            return "f:/JSP/admin/admin/order/list.jsp";
        }
    }

    public String cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        /*
         * 更改订单状态
         * */
        if (orderService.findState(oid) != 4) {
            request.setAttribute("msg", "订单状态错误，请查证后再进行处理!");
        }
        try {
            orderService.right("4");
            request.setAttribute("oid", oid);
            return load(request, response);
        } catch (OrderException e) {
            request.setAttribute("msg","修改失败！");
            return "f:/JSP/admin/admin/order/list.jsp";
        }
    }
}

