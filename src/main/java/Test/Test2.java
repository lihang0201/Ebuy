package Test;

import TOOLs.Mail;
import TOOLs.MailUtil;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException, MessagingException {
        Session session = MailUtil.createSession
                ("smtp.163.com","jssqlih","jssqlh123");
        Mail mail = new Mail("jssqlih@163.com","759328128@qq.com",
                "面试通知","欢迎来到德莱联盟！");
        mail.addCcAddress("jssqlih@163.com");
        MailUtil.send(session,mail);
    }
}
