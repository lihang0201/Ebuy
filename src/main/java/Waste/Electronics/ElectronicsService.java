package Waste.Electronics;

import java.util.List;

public class ElectronicsService {
    private ElectronicsDAO electronicsDao = new ElectronicsDAO();
    public List<Electronics> findElectronics(){
        return electronicsDao.findEletronics();
    }
    public List<Electronics> findByCategory(String cid){return electronicsDao.findBycategory(cid);}
    public Electronics Load(String eid){
        return electronicsDao.findByeid(eid);
    }
}
