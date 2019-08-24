package Administrator;

import User.User;
import User.UserException;

public class AdminService {
    AdminDao adminDao = new AdminDao();
    public Admin login(Admin form) throws AdminException {
        /*
        登陆模块需要校验用户名密码和激活状态
        1.使用username查询
        2.如果user为null，抛出异常（用户名不存在）
        3.比较form和user的密码，若不同，抛出异常（密码错误）
        4.查看用户的状态，若为false，抛出异常（未激活）
         */
        Admin admin = adminDao.login(form.getAname());
        if(admin == null) throw new AdminException("用户不存在！");
        if(!admin.getApassword().equals(form.getApassword())) throw new AdminException("密码错误！");
        return admin;
    }
}
