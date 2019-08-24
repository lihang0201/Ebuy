package Waste.Others;

import TOOLs.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodServlet",urlPatterns = "/FoodServlet")
public class OthersServlet extends BaseServlet {
    private OthersService othersService = new OthersService();

    public String findOthers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("othersList",othersService.findOthers());
        return "f:/JSP/JSPs/Goods/Others/othersList.jsp";
    }

    public String Load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Waste/Others",othersService.Load(request.getParameter("oid")));
        return "f:/JSP/JSPs/Goods/Others/desc.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        request.setAttribute("othersList",othersService.findByCategory(cid));
        return "f:/JSP/JSPs/Goods/Others/othersList.jsp";
    }
}
