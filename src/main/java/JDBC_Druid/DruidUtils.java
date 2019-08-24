package JDBC_Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    //定义成员变量DataSource
    private static DataSource ds;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    static {
        //加载配置文件
        Properties pp = new Properties();
        try {
            pp.load(new FileReader("D:\\JavaProject5\\bysj\\src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param st
     * @param con
     */
    public static void close(Statement st,Connection con){
        close(null,st,con);
    }

    public static void close(ResultSet rs,Statement st, Connection con){
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //归还连接
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 开启事务
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();//获取当前线程的事务连接
        if(con != null) throw new SQLException("已经开启了事务，不能重复开启！");
        con = ds.getConnection();//给con赋值，表示开启了事务
        con.setAutoCommit(false);//设置为手动提交
        tl.set(con);//把当前事务连接放到tl中
    }

    /**
     * 提交事务
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();//获取当前线程的事务连接
        if(con == null) throw new SQLException("没有事务不能提交！");
        con.commit();//提交事务
        con.close();//关闭连接
        con = null;//表示事务结束！
        tl.remove();
    }

    /**
     * 回滚事务
     * @throws SQLException
     */
    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();//获取当前线程的事务连接
        if(con == null) throw new SQLException("没有事务不能回滚！");
        con.rollback();
        con.close();
        con = null;
        tl.remove();
    }


    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
