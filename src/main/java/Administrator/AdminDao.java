package Administrator;

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDao {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public Admin login(String aname){
        try{
            String sql = "SELECT * FROM administrator WHERE aname = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(Admin.class),aname);
        }catch(EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
