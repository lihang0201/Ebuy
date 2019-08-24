package Waste.Others;

import Category.Category;

public class Others {
    private String oid;
    private String oname;
    private String oimage;
    private double oprice;
    private Category category;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOimage() {
        return oimage;
    }

    public void setOimage(String oimage) {
        this.oimage = oimage;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
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
                "oid='" + oid + '\'' +
                ", oname='" + oname + '\'' +
                ", oimage='" + oimage + '\'' +
                ", oprice=" + oprice +
                ", category=" + category +
                '}';
    }
}
