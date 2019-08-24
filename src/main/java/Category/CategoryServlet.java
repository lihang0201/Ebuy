package Category;

import TOOLs.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CategoryServlet",urlPatterns = "/CategoryServlet")
public class CategoryServlet extends BaseServlet {
    private CategoryService CategoryService = new CategoryService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList",CategoryService.findAll());
        return "f:/JSP/JSPs/left.jsp";
    }
    public String findALL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList",CategoryService.findAll());
        return "f:/JSP/All.jsp";
    }

    public Category findByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return CategoryService.load(request.getParameter("cid"));
    }
    public String findBycid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList",CategoryService.load(request.getParameter("cid")));
        return "f:/JSP/All.jsp";
    }
}
