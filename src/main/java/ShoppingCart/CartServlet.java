package ShoppingCart;

import Goods.Goods;
import Goods.GoodsService;
import TOOLs.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends BaseServlet {
    //添加购物车条目
/*    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        *//*
        得到登陆用户的购物车
        得到条目(商品和数量)
         *//*
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String clid = request.getParameter("clid");
        String fid = request.getParameter("fid");
        String eid = request.getParameter("eid");
        String oid = request.getParameter("oid");
        Goods clothes = new GoodsService().Load(clid);
        Food food = new FoodService().Load(fid);
        Electronics electronics = new ElectronicsService().Load(eid);
        Others others = new OthersService().Load(oid);
        int countcl = Integer.parseInt(request.getParameter("countcl"));
        int countfo = Integer.parseInt(request.getParameter("countfo"));
        int countele = Integer.parseInt(request.getParameter("countele"));
        int countot = Integer.parseInt(request.getParameter("counto"));
        CartItem cartItem = new CartItem();
        cartItem.setClothes(clothes);
        cartItem.setCountcl(countcl);
        cartItem.setFood(food);
        cartItem.setCountfo(countfo);
        cartItem.setElectronics(electronics);
        cartItem.setCountele(countele);
        cartItem.setOthers(others);
        cartItem.setCountot(countot);
        cart.add(cartItem);
        return "f:/JSP/JSPs/cart/list.jsp";
    }*/
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
        try {
            String gid = request.getParameter("gid");
            Goods goods = new GoodsService().Load(gid);
            int count = Integer.parseInt(request.getParameter("count"));
            CartItem cartitem = new CartItem();
            cartitem.setGoods(goods);
            cartitem.setCount(count);
            cart.add(cartitem);
        }catch (Exception e){
            if(cart == null){
                request.setAttribute("msg","请登录");
            }
        }
        return "f:/JSP/JSPs/cart/list.jsp";
    }
    //清空
    public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        return "f:/JSP/JSPs/cart/list.jsp";
    }
    //删除
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String gid = request.getParameter("gid");
        cart.delete(gid);
        return "f:/JSP/JSPs/cart/list.jsp";
    }
}
