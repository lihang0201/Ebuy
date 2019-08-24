package Goods;

import Category.Category;
import JDBC_Druid.DruidUtils;
import TOOLs.CommonUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsDAO {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    public List<Goods> findAll(){
        try{
            String sql = "SELECT * FROM goods WHERE del = false ";
            return template.query(sql,new BeanPropertyRowMapper<Goods>(Goods.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<Goods> findBycategory(String cid){
        try {
            String sql = "SELECT * FROM goods WHERE cid = ? AND del = false";
            return template.query(sql,new BeanPropertyRowMapper<Goods>(Goods.class),cid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //加载方法
    public Goods findBygid(String gid){
        try {
            String sql = "SELECT * FROM goods WHERE gid = ? AND del = false";
            Map<String,Object> map = template.queryForMap(sql,gid);
            Category category = CommonUtils.toBean(map,Category.class);
            Goods goods = CommonUtils.toBean(map,Goods.class);
            goods.setCategory(category);
            return goods;
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public int getCountByCid(String cid){
        try{
            String sql = "SELECT COUNT(*) FROM goods WHERE cid = ?";
            return template.queryForObject(sql,java.lang.Integer.class,cid);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return 0;
        }
    }

    public void add(Goods goods) {
        try{
            String sql = "INSERT INTO goods VALUES(?,?,?,?,?)";
            Object[] params = {goods.getGid(),goods.getGname(),
                    goods.getGimage(),goods.getGprice(),goods.getCategory().getCid()};
            template.update(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //删除只是改变其del状态
    public void delete(String gid) {
        try{
            String sql = "UPDATE goods SET del = true WHERE gid = ?";
            template.update(sql,gid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void change(Goods goods) {
        try {
            String sql = "UPDATE goods SET gname=?, gprice=?, gimage=?, cid=? WHERE gid=?";
            Object[] params = {goods.getGname(), goods.getGprice(), goods.getGimage(),
                    goods.getCategory().getCid(), goods.getGid()};
            template.update(sql, params);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
