package Waste.Clothes;

import TOOLs.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsServlet")
public class ClothesServlet extends BaseServlet {
    private ClothesService clothesService = new ClothesService();

    public String findClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clothesList",clothesService.findClothes());
        return "f:/JSP/JSPs/Goods/Goods/clothesList.jsp";
    }

    public String Load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Waste/Clothes",clothesService.Load(request.getParameter("clid")));
        return "f:/JSP/JSPs/Goods/Goods/desc.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        request.setAttribute("clothesList",clothesService.findByCategory(cid));
        return "f:/JSP/JSPs/Goods/Goods/clothesList.jsp";
    }
}
