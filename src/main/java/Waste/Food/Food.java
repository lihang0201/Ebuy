package Waste.Food;

import Category.Category;

public class Food {
    private String fid;
    private String fname;
    private String fimage;
    private double fprice;
    private Category category;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }

    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
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
                "fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", fimage='" + fimage + '\'' +
                ", fprice=" + fprice +
                ", category=" + category +
                '}';
    }
}
