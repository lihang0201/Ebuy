package Test;

import JDBC_Druid.DruidUtils;
import User.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test3 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

        String sql = "SELECT * FROM bs_user WHERE uid = ?";
        User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),"1");
        System.out.println(user.toString());
    }
}
