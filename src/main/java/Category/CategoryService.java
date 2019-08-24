package Category;

import Goods.GoodsDAO;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDao = new CategoryDAO();
    private GoodsDAO goodsDAO = new GoodsDAO();
    public List<Category> findAll(){
        return categoryDao.findAll();
    }
    public void addCategory(Category category){
        categoryDao.addCategory(category);
    }
    public void delete(String cid) throws CategoryException {
        int count = goodsDAO.getCountByCid(cid);
        if(count > 0)throw new CategoryException("该分类下有商品，不能够删除此分类");
        categoryDao.delete(cid);
    }
    public Category load(String cid){
        return categoryDao.load(cid);
    }

    public void change(Category category) {
        categoryDao.change(category);
    }


}
