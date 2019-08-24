package Goods;

import Category.Category;
import Category.CategoryService;
import TOOLs.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminAddGoodsServlet",urlPatterns = "/admin/AdminAddGoodsServlet")
public class AdminAddGoodsServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsService();
    private CategoryService categoryService = new CategoryService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=ytf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory(2*1024*1024,new File("/JSP/img"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(2*1024*1024);

        try {
            List<FileItem> fileItemList = upload.parseRequest(request);
            /*
            将fileItemList中的数据封装到Goods对象中
            先把所有的普通表单字段数据封装到Map中
            再把Map中的数据封装到Goods对象中
             */
            Map<String,String> map = new HashMap<>();
            for (FileItem fileitem: fileItemList) {
                if (fileitem.isFormField()) {
                    map.put(fileitem.getFieldName(), fileitem.getString("UTF-8"));
                }
            }
            Goods goods = CommonUtils.toBean(map,Goods.class);
            goods.setGid(CommonUtils.uuid());//主键不能为空
            Category category = CommonUtils.toBean(map,Category.class);
            goods.setCategory(category);

            //保存上传的文件（目录与名称）
            String savepath = this.getServletContext().getRealPath("/JSP/img");
            String filename = CommonUtils.uuid() + "_" + fileItemList.get(1).getName();
            File destFile = new File(savepath,filename);
            fileItemList.get(1).write(destFile);
            //设置image的路径
            goods.setGimage("JSP/img/" + filename);
            //使用GoodsService完成保存
            goodsService.add(goods);
            request.getRequestDispatcher("/admin/AdminGoodsServlet?method=findAll").forward(request,response);
        } catch (Exception e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException){
                request.setAttribute("msg","文件大小超过2M");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/JSP/admin/admin/goods/add.jsp").forward(request,response);
            }
        }

    }

}
