package User;

import ShoppingCart.Cart;
import TOOLs.*;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@WebServlet(name = "UserServlet")
public class UserServlet extends BaseServlet {

    /**
     * 注册功能
     * 封装表单数据到form对象中
     * 补全：uid,code
     * 输入校验
     * 调用service方法完成注册
     * 发邮件
     * 保存成功信息转发到主页
     */

    private UserService userservice = new UserService();
    public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1.获取参数激活码
        2.调用service方法完成激活
            失败：保存错误信息到request域，转发到msg.jsp
            成功：保存成功信息到request域，转发到msg.jsp
         */
        String code = request.getParameter("code");
        try {
            userservice.active(code);
            request.setAttribute("msg","激活成功！");
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "f:/JSP/msg.jsp";
    }

    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MessagingException {
        //封装表单数据
        User form  = CommonUtils.toBean(request.getParameterMap(), User.class);
        //补全
        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
        /*
        输入校验
        1.创建一个Map用来封装错误信息，其中key为表单字段名称，值为错误信息
        2.获取form中的username，password，Email进行校验
        3.判读是否存在错误信息
         */
        Map<String,String> error = new HashMap<>();
        String username = form.getUsername();
        if(username == null || username.trim().isEmpty()){
            error.put("username","用户名不能为空！");
        }else if(username.length() < 6 || username.length() > 10){
            error.put("username","用户名长度为6至10位");
        }

        String password = form.getPassword();
        if(password == null || password.trim().isEmpty()){
            error.put("password","密码不能为空！");
        }else if(password.length() < 6 || password.length() > 10){
            error.put("password","密码长度为6至10位");
        }

        String email = form.getEmail();
        if(email == null || email.trim().isEmpty()){
            error.put("email","邮箱不能为空！");
        }else if(!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")){//使用正则表达式验证邮箱是否匹配格式
            error.put("email","邮箱不存在！");
        }
        if(error.size() > 0){
            //存在错误信息，保存错误信息，保存表单数据，转发到register.jsp
            request.setAttribute("error",error);
            request.setAttribute("form",form);
            return "f:/JSP/Register.jsp";
        }
        try {
            userservice.regist(form);
            /*若是可以执行到此处，则说明userService执行成功
                保存成功信息
                转发到msg.jsp
            */
        }catch (UserException e){
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("form",form);
            return "f:/JSP/Register.jsp";
        }
       /* *//*
        发邮件
            准备配置文件Email_template.properties
            获取配置文件内容
         *//*
        Properties pp = new Properties();
        pp.load(this.getClass().getClassLoader().getResourceAsStream("Email_template.properties"));
        String host = pp.getProperty("host");//获取服务器主机
        String uname = pp.getProperty("uname");//获取用户名
        String pwd = pp.getProperty("pwd");//密码
        String from = pp.getProperty("from");//发件人
        String to = form.getEmail();//收件人
        String subject = pp.getProperty("subject");//标题
        String content = pp.getProperty("content");//正文
        String cc = pp.getProperty("cc");
        content = MessageFormat.format(content,form.getCode());//将占位符替换为code
        Session session = MailUtil.createSession(host,uname,pwd);
        Mail mail = new Mail(from,to,subject,content);
        mail.addCcAddress(cc);
        MailUtil.send(session,mail);
        request.setAttribute("msg","注册成功！激活码已发送至您的邮箱，请进入邮箱激活账号");
        return "f:/JSP/msg.jsp";
*/
        request.setAttribute("msg","注册成功！激活码已发送至您的邮箱，请进入邮箱激活账号,可能会有些延迟，请耐心等待");
        return "f:/JSP/msg.jsp"                                                                                                 ;
    }

    private String sendMail(User user) throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader().getResourceAsStream("/Email_template.properties"));
        String host = props.getProperty("host");//获取服务器主机
        String uname = props.getProperty("uname");//获取用户名
        String pwd = "jssqlh123456";//获取密码
        String from = props.getProperty("from");//获取发件人
        String to = user.getEmail();//获取收件人
        //  String cc = props.getProperty("cc");//进行抄送

        //乱码处理
        String subject = props.getProperty("subject");//获取邮件标题
        String content = props.getProperty("content");//获取邮件内容

        content = MessageFormat.format(content, user.getCode());//替换占位符{0}
        Session session = MailUtil.createSession(host, uname, pwd);//得到session

        Mail mail = new Mail(from, to, subject, content);//创建邮件对象
        //    mail.addCcAddress(cc);//先进行抄送，在进行邮件发送
        try {

            MailUtil.send(session, mail);
            return "注册成功,请到邮件中激活后登录！";

        } catch (MessagingException e) {
            throw new RuntimeException(e);
            //return "邮件发送失败,失败错误信息："+e.getMessage();
//                request.setAttribute("msg","注册成功，邮件发送失败");
//                return "f:/jsps/msg.jsp";
        }
    }


    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        封装数据到form中
        校验验证码
        调用service方法完成激活
         */
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);


        try {
            User user = userservice.login(form);
            String vcode = (String)request.getSession().getAttribute("img");
            String text = request.getParameter("Vcode");
            if(!vcode.equalsIgnoreCase(text)){
                request.setAttribute("msg","验证码错误！");
                return "f:/JSP/Login.jsp";
            }

            request.getSession().setAttribute("session_user", user);
            //登陆成功后给用户添加购物车，即在session中保存一个Cart对象
            request.getSession().setAttribute("cart",new Cart());
            return "r:/JSP/JSPs/main.jsp";
        } catch (UserException e) {
            request.getSession().setAttribute("msg",e.getMessage());
            request.getSession().setAttribute("form",form);
            return "f:/JSP/Login.jsp";
        }
    }


    public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        return "r:/JSP/JSPs/main.jsp";
    }


}
