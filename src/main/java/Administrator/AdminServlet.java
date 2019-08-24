package Administrator;


import TOOLs.BaseServlet;
import TOOLs.CommonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin/AdminServlet")
public class AdminServlet extends BaseServlet {
    private AdminService adminService = new AdminService();

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin form = CommonUtils.toBean(request.getParameterMap(),Admin.class);
        try {
            Admin admin = adminService.login(form);
            request.getSession().setAttribute("session_admin", admin);
            return "r:/JSP/admin/admin/main.jsp";
        } catch (AdminException e) {
            request.getSession().setAttribute("msg",e.getMessage());
            request.getSession().setAttribute("form",form);
            return "f:/JSP/admin/admin/login.jsp";
        }
    }
}
