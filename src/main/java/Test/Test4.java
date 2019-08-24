package Test;

import Waste.Clothes.Clothes;
import JDBC_Druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test4 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "SELECT * FROM clothes";
        System.out.println(template.query(sql,new BeanPropertyRowMapper<Clothes>(Clothes.class)));
    }
}
