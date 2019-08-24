package Administrator;

public class Admin {
    String aname;
    String apassword;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }
}
