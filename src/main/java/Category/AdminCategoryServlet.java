package Category;

import TOOLs.BaseServlet;
import TOOLs.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/admin/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryService();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList",categoryList);
        return "f:/JSP/admin/admin/category/list.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
        category.setCid(CommonUtils.uuid());
        categoryService.addCategory(category);
        return findAll(request,response);
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cid = request.getParameter("cid");
        try{
            categoryService.delete(cid);
            return findAll(request,response);
        }catch (CategoryException e){
            request.setAttribute("msg",e.getMessage());
            return "f:/JSP/admin/msg.jsp";
        }
    }

    //修改前需要加载分类
    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        request.setAttribute("category",categoryService.load(cid));
        return "f:/JSP/admin/admin/category/mod.jsp";
    }

    //修改分类
    public String change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = CommonUtils.toBean(request.getParameterMap(),Category.class);
        categoryService.change(category);
        return findAll(request,response);
    }
}
