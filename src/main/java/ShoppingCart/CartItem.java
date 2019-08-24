package ShoppingCart;

import Category.Category;
import Goods.Goods;
import Waste.Clothes.Clothes;
import Waste.Electronics.Electronics;
import Waste.Food.Food;
import Waste.Others.Others;

import java.math.BigDecimal;

public class CartItem {
    private Category category;
    private Goods goods;
    private int count;

    public double getSubtotal(){
        BigDecimal d1 = new BigDecimal(goods.getGprice() + "");
        BigDecimal d2 = new BigDecimal(count + "");

        return d1.multiply(d2).doubleValue();


    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
