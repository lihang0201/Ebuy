package Test;

import Category.Category;
import JDBC_Druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test5 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "SELECT * FROM category";
        System.out.println(template.query(sql, new BeanPropertyRowMapper<Category>(Category.class)));
    }
}
