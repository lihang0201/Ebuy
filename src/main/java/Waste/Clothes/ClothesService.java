package Waste.Clothes;

import java.util.List;

public class ClothesService {
    private ClothesDAO clothesDao = new ClothesDAO();
    public List<Clothes> findClothes(){
        return clothesDao.findClothes();
    }
    public List<Clothes> findByCategory(String cid){return clothesDao.findBycategory(cid);}
    public Clothes Load(String clid){
        return clothesDao.findByclid(clid);
    }
}
