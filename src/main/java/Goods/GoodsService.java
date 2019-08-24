package Goods;

import java.util.List;

public class GoodsService {
    private GoodsDAO goodsDao = new GoodsDAO();
    public List<Goods> findAll(){
        return goodsDao.findAll();
    }
    public List<Goods> findByCategory(String cid){return goodsDao.findBycategory(cid);}
    public Goods Load(String gid){
        return goodsDao.findBygid(gid);
    }
    public void add(Goods goods) {
        goodsDao.add(goods);
    }
    public void delete(String gid){
        goodsDao.delete(gid);
    }

    public void change(Goods goods) {
        goodsDao.change(goods);
    }
}
