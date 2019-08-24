package Test;

import JDBC_Druid.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Map;

/**
 * 测试数据库连接是否可以使用
 */
public class Test1 {
    public static void main(String[] args) {
        //创建JDBCTemplate对象，传入DataSource参数
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        //调用方法进行测试
        String sql = "SELECT * FROM class WHERE cid = '103'";
        Map map = template.queryForMap(sql);
        System.out.println(map);
    }
}
