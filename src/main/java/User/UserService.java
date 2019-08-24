package User;


/**
 * User业务层
 */
public class UserService {
    private UserDao userdao = new UserDao();
    /*
    注册功能
    校验用户名和邮箱是否已被注册
     */
    public void regist(User form) throws UserException{
        //查询数据库中是否存在用户名  查询数据库中是否存在邮箱
        User user = userdao.findByUsername(form.getUsername());
        if(user != null) throw new UserException("用户名已被注册！");

        // 校验email
        user = userdao.findByEmail(form.getEmail());
        if(user != null) throw new UserException("Email已被注册！");

        // 插入用户到数据库
        userdao.add(form);

    }
    /*
    激活功能
     */
    public void active(String code) throws UserException {
        //使用code查询数据库
        User user2 = userdao.findByCode(code);
        //如果不存在，说明激活码错误
        if(user2 == null){
            throw new UserException("激活码失效");
        }
        //查看用户的状态
        if(user2.isState())throw new UserException("已经激活，重复无效");
        //修改用户状态
        userdao.UpdateState(user2.getUid(),true);
    }
    public User login(User form) throws UserException {
        /*
        登陆模块需要校验用户名密码和激活状态
        1.使用username查询
        2.如果user为null，抛出异常（用户名不存在）
        3.比较form和user的密码，若不同，抛出异常（密码错误）
        4.查看用户的状态，若为false，抛出异常（未激活）
         */
        User user3 = userdao.findByUsername(form.getUsername());
        if(user3 == null) throw new UserException("用户不存在！");
        if(!user3.getPassword().equals(form.getPassword())) throw new UserException("密码错误！");
        if(!user3.isState()) throw  new UserException("用户未激活，请到邮箱激活");
        return user3;
    }
}
