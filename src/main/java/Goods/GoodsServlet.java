package Goods;

import TOOLs.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsServlet",urlPatterns = "/GoodsServlet")
public class GoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("goodsList", goodsService.findAll());
        return "f:/JSP/JSPs/Goods/List.jsp";
    }

    public String Load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Goods", goodsService.Load(request.getParameter("gid")));
        return "f:/JSP/JSPs/Goods/Desc.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        request.setAttribute("goodsList", goodsService.findByCategory(cid));
        return "f:/JSP/JSPs/Goods/List.jsp";
    }
}
