package Waste.Others;

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OthersDAO {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public List<Others> findOthers(){
        try{
            String sql = "SELECT * FROM others";
            return template.query(sql,new BeanPropertyRowMapper<Others>(Others.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<Others> findBycategory(String cid){
        try {
            String sql = "SELECT * FROM others WHERE cid = ?";
            return template.query(sql,new BeanPropertyRowMapper<Others>(Others.class),cid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //加载方法
    public Others findByoid(String oid){
        try {
            String sql = "SELECT * FROM others WHERE oid = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Others.class), oid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
