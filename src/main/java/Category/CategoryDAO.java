package Category;

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDAO {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public List<Category> findAll(){
        try {
            String sql = "SELECT * FROM category";
            return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public void addCategory(Category category){
        try{
            String sql = "INSERT INTO category VALUES(?,?)";
            template.update(sql,category.getCid(),category.getCname());
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }
    }

    public void delete(String cid){
        try{
            String sql = "DELETE FROM category WHERE cid = ?";
            template.update(sql,cid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Category load(String cid){
        try {
            String sql = "SELECT * FROM category WHERE cid = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), cid);
            }catch(EmptyResultDataAccessException e){
                e.printStackTrace();
                return null;
            }
    }

    public void change(Category category) {
        try{
            String sql = "UPDATE category SET cname = ? WHERE cid = ?";
            template.update(sql,category.getCname(),category.getCid());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
