package Waste.Food;

import TOOLs.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodServlet",urlPatterns = "/FoodServlet")
public class FoodServlet extends BaseServlet {
    private FoodService foodService = new FoodService();

    public String findFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("foodList",foodService.findFood());
        return "f:/JSP/JSPs/Goods/Food/foodList.jsp";
    }

    public String Load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Waste/Food",foodService.Load(request.getParameter("fid")));
        return "f:/JSP/JSPs/Goods/Food/desc.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        request.setAttribute("foodList",foodService.findByCategory(cid));
        return "f:/JSP/JSPs/Goods/Food/foodList.jsp";
    }
}
