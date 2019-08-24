package Order;

import Goods.Goods;
import JDBC_Druid.DruidUtils;
import TOOLs.CommonUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDAO {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    private OrderItem toOrderItem(Map<String, Object> map) {
        //将一个Map转换为一个orderItem对象
        OrderItem orderItem = CommonUtils.toBean(map,OrderItem.class);
        Goods goods = CommonUtils.toBean(map,Goods.class);
        orderItem.setGoods(goods);
        return orderItem;
    }

    private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
        //将mapList中的每个Map转换成两个对象，并建立关系
        List<OrderItem> orderItemList = new ArrayList<>();
        for (Map<String,Object> map : mapList) {
            OrderItem item = toOrderItem(map);
            orderItemList.add(item);
        }
        return orderItemList;
    }

    private void loadOrderItems(Order order) {
        //用于加载指定订单的条目
        try {
            //使用多表查询orderitem和goods
            String sql = "SELECT * FROM orderitem i,goods g WHERE i.gid = g.gid AND oid = ?";
            List<Map<String, Object>> mapList = template.queryForList(sql, order.getOid());
            //使用一个Map生成两个对象：OrderItem,Goods,再建立二者关系
            List<OrderItem> orderItemList = toOrderItemList(mapList);
            order.setOrderItemList(orderItemList);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

    }



    //插入订单
    public void addOrder(Order order) {
        try {
            String sql = "INSERT INTO orders VALUES (?,?,?,?,?,?)";
        /*
        要将数据存入数据库中，order.getOrdertime()得到的为UTIL的Date，要将其转换为sql下的Timestamp
         */
            Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
            Object[] params = {order.getOid(), timestamp, order.getTotal(),
                    order.getState(), order.getOwner().getUid(), order.getAddress()};
            template.update(sql, params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //插入订单条目
    public void addOrderItemList(List<OrderItem> orderItemList){
        try {
            String sql = "INSERT INTO orderitem VALUES (?,?,?,?,?)";
            List<Object[]> params = new ArrayList<>();
            for(int i = 0;i < orderItemList.size();i++){
                OrderItem item = orderItemList.get(i);
                Object [] arr = new Object[5];
                arr[0] = item.getIid();
                arr[1] = item.getCount();
                arr[2] = item.getSubtotal();
                arr[3] = item.getOrder().getOid();
                arr[4] = item.getGoods().getGid();
                params.add(arr);
            }
            template.batchUpdate(sql,params);


        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Order> findByUid(String uid){
        try{
            //得到当前用户的所有订单
            String sql = "SELECT * FROM orders WHERE uid = ?";
            List<Order> orderList = template.query(sql,new BeanPropertyRowMapper<>(Order.class),uid);
            //循环遍历所有的Order，加载所有的订单条目
            for (Order order:orderList) {
                loadOrderItems(order);
            }
            return orderList;
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public Order load(String oid){
        try{
            //得到当前用户的所有订单
            String sql = "SELECT * FROM orders WHERE oid = ?";
            Order order = template.queryForObject(sql,new BeanPropertyRowMapper<>(Order.class),oid);
            loadOrderItems(order);
            return order;
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //通过oid查看订单状态
    public int getStateByOid(String oid){
        try{
            String sql = "SELECT state FROM orders WHERE oid = ?";
            return template.queryForObject(sql,java.lang.Integer.class,oid);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return 0;
        }
    }

    //修改订单状态
    public  void updateState(String oid,int state){
        try{
            String sql = "UPDATE orders SET state = ? WHERE oid = ?";
            template.update(sql,state,oid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Order> findAll() {
        try{
            String sql = "SELECT * FROM orders";
            List<Order> orderList = template.query(sql,new BeanPropertyRowMapper<>(Order.class));
            for (Order order:orderList) {
                loadOrderItems(order);
            }
            return orderList;
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> findByState(String state) {
        try{
            String sql = "SELECT * FROM orders WHERE state = ?";
            List<Order> orderList = template.query(sql,new BeanPropertyRowMapper<>(Order.class),state);
            for (Order order:orderList) {
                loadOrderItems(order);
            }
            return orderList;
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

}
