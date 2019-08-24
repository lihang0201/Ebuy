package Waste.Electronics;

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ElectronicsDAO {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public List<Electronics> findEletronics(){
        try{
            String sql = "SELECT * FROM electronics";
            return template.query(sql,new BeanPropertyRowMapper<Electronics>(Electronics.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<Electronics> findBycategory(String cid){
        try {
            String sql = "SELECT * FROM electronics WHERE cid = ?";
            return template.query(sql,new BeanPropertyRowMapper<Electronics>(Electronics.class),cid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //加载方法
    public Electronics findByeid(String eid){
        try {
            String sql = "SELECT * FROM electronics WHERE eid = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Electronics.class), eid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
