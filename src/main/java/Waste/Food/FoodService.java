package Waste.Food;

import java.util.List;

public class FoodService {
    private FoodDAO foodDao = new FoodDAO();
    public List<Food> findFood(){
        return foodDao.findFood();
    }
    public List<Food> findByCategory(String cid){return foodDao.findBycategory(cid);}
    public Food Load(String fid){
        return foodDao.findByfid(fid);
    }
}
