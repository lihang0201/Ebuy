package ShoppingCart;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> map = new LinkedHashMap<>();

    /**
     * 添加条目到购物车中
     * 要判断购物车中是否存在该条目，若存在，只需要修改数量
     * 若不存在，则添加该条目
     * @param newcartitem
     */
    public void add(CartItem newcartitem){
        if(map.containsKey(newcartitem.getGoods().getGid())) {//判断原来车中是否存在该条目
            CartItem oldcartitem = map.get(newcartitem.getGoods().getGid());//返回原条目
            oldcartitem.setCount(oldcartitem.getCount() + newcartitem.getCount());//设置老条目的数量为，其自己数量+新条目的数量
            map.put(newcartitem.getGoods().getGid(), oldcartitem);
        } else {
            map.put(newcartitem.getGoods().getGid(), newcartitem);
        }
    }
    //清空购物车
    public void clear(){
        map.clear();
    }
    //删除某个条目
    public void delete(String id){
        map.remove(id);
    }
    //获取所有条目
    public Collection<CartItem> getCartitems(){
        return map.values();
    }
    //总计
    public double getTotal(){
        BigDecimal total = new BigDecimal("0");
        for (CartItem cartitem:map.values()
             ) {
            BigDecimal sum = new BigDecimal("" + cartitem.getSubtotal());
            total = total.add(sum);
        }
        return total.doubleValue();
    }
}
