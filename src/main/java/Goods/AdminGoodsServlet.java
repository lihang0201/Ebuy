package Goods;

import Category.Category;
import Category.CategoryService;
import TOOLs.BaseServlet;
import TOOLs.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;

@WebServlet(name = "AdminGoodsServlet",urlPatterns = "/admin/AdminGoodsServlet")
public class AdminGoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsService();
    private CategoryService categoryService = new CategoryService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("goodsList",goodsService.findAll());
        return "f:/JSP/admin/admin/goods/list.jsp";
    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("goods",goodsService.Load(request.getParameter("gid")));
        request.setAttribute("categoryList",categoryService.findAll());
        return "f:/JSP/admin/admin/goods/desc.jsp";
    }

    public String addPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList",categoryService.findAll());
        return "f:/JSP/admin/admin/goods/add.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid = request.getParameter("gid");
        goodsService.delete(gid);
        return findAll(request,response);
    }

    public String change(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Goods goods = CommonUtils.toBean(request.getParameterMap(), Goods.class);
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        goods.setCategory(category);
        goodsService.change(goods);
        return findAll(request, response);
    }
}
