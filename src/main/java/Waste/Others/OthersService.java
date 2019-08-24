package Waste.Others;

import java.util.List;

public class OthersService {
    private OthersDAO otherDao = new OthersDAO();
    public List<Others> findOthers(){
        return otherDao.findOthers();
    }
    public List<Others> findByCategory(String cid){return otherDao.findBycategory(cid);}
    public Others Load(String oid){
        return otherDao.findByoid(oid);
    }
}
