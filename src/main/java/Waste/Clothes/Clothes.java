package Waste.Clothes;

import Category.Category;

public class Clothes {
    private String clid;
    private String clname;
    private String climage;
    private double clprice;
    private Category category;

    public String getClid() {
        return clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public String getClimage() {
        return climage;
    }

    public void setClimage(String climage) {
        this.climage = climage;
    }

    public double getClprice() {
        return clprice;
    }

    public void setClprice(double clprice) {
        this.clprice = clprice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "User{" +
                "clid='" + clid + '\'' +
                ", clname='" + clname + '\'' +
                ", climage='" + climage + '\'' +
                ", clprice=" + clprice +
                ", category=" + category +
                '}';
    }
}
