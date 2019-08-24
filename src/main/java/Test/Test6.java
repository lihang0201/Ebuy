package Test;

import JDBC_Druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Test6 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "SELECT * FROM orderitem i,goods g WHERE i.gid = g.gid AND oid = ?";
        List<Map<String, Object>> mapList = template.queryForList(sql,"A788A41B8EB94B21945E2EE40DBC526B");
        System.out.println(mapList);
    }
}
