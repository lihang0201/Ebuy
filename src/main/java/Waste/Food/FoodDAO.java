package Waste.Food;

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FoodDAO {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public List<Food> findFood(){
        try{
            String sql = "SELECT * FROM food";
            return template.query(sql,new BeanPropertyRowMapper<Food>(Food.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<Food> findBycategory(String cid){
        try {
            String sql = "SELECT * FROM food WHERE cid = ?";
            return template.query(sql,new BeanPropertyRowMapper<Food>(Food.class),cid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //加载方法
    public Food findByfid(String fid){
        try {
            String sql = "SELECT * FROM food WHERE fid = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Food.class), fid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
