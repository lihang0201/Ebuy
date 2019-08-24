package User;
/**
 * 数据库连接池
 * User持久层
 */

import JDBC_Druid.DruidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {
    public JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    /*
    按用户名查找
     */
    public User findByUsername(String username){
        try{
            String sql = "SELECT * FROM bs_user WHERE username = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    /*
    按邮箱查找
     */
    public User findByEmail(String email){
        try{
            String sql = "SELECT * FROM bs_user WHERE email = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),email);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    /*
  按激活码查找
   */
    public User findByCode(String code){
        try{
            String sql = "SELECT * FROM bs_user WHERE code = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
    /*
       修改用户的激活状态
     */
    public void UpdateState(String uid,Boolean state){
        String sql = "UPDATE bs_user SET state = ? WHERE uid = ?";
        template.update(sql,state,uid);
    }

    /*
    添加用户
     */
    public void add(User user){
        try{
            String sql = "INSERT INTO bs_user VALUES(?,?,?,?,?,?)";
            Object[] params = {user.getUid(), user.getUsername(), user.getPassword(),
            user.getEmail(), user.getCode(), user.isState()};
            template.update(sql,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
