package Waste.Clothes;

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ClothesDAO {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    /**
     * 查询所有服装
     * @return
     */
    public List<Clothes> findClothes(){
        try{
            String sql = "SELECT * FROM clothes";
            return template.query(sql,new BeanPropertyRowMapper<Clothes>(Clothes.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<Clothes> findBycategory(String cid){
        try {
            String sql = "SELECT * FROM clothes WHERE cid = ?";
            return template.query(sql,new BeanPropertyRowMapper<Clothes>(Clothes.class),cid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //加载方法
    public Clothes findByclid(String clid){
        try {
            String sql = "SELECT * FROM clothes WHERE clid = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Clothes.class), clid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
