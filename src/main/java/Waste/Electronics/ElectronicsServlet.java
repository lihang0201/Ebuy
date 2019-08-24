package Waste.Electronics;

import TOOLs.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ElectronicsServlet",urlPatterns = "/ElectronicsServlet")
public class ElectronicsServlet extends BaseServlet {
    private ElectronicsService electronicsService = new ElectronicsService();

    public String findElectronics(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("electronicsList",electronicsService.findElectronics());
        return "f:/JSP/JSPs/Goods/Electronics/electronicsList.jsp";
    }

    public String Load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Waste/Electronics",electronicsService.Load(request.getParameter("eid")));
        return "f:/JSP/JSPs/Goods/Electronics/desc.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        request.setAttribute("electronicsList",electronicsService.findByCategory(cid));
        return "f:/JSP/JSPs/Goods/Electronics/electronicsList.jsp";
    }
}
