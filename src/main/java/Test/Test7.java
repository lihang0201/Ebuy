package Test;

import JDBC_Druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test7 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "SELECT state FROM orders WHERE oid = ?";
        int num =(Integer) template.queryForObject(sql,java.lang.Integer.class,"7ACB0EC847F0431EA37AE883F529223A");
        System.out.println(num);
    }
}
