package Waste.Electronics;

import Category.Category;

public class Electronics {
    private String eid;
    private String ename;
    private String eimage;
    private double eprice;
    private Category category;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEimage() {
        return eimage;
    }

    public void setEimage(String eimage) {
        this.eimage = eimage;
    }

    public double getEprice() {
        return eprice;
    }

    public void setEprice(double eprice) {
        this.eprice = eprice;
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
                "eid='" + eid + '\'' +
                ", ename='" + ename + '\'' +
                ", eimage='" + eimage + '\'' +
                ", eprice=" + eprice +
                ", category=" + category +
                '}';
    }
}
