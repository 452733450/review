package com.jack.review.test.sendEmail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/17/17:07
 */
public class office {

    private static void send() {
        //单文本邮件发送
        try {
            Properties props = new Properties();
            // 开启debug调试
            props.setProperty("mail.debug", "true");  //false
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.partner.outlook.cn");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");

            // 设置环境信息
            Session session = Session.getInstance(props);

            // 创建邮件对象
            Message msg = new MimeMessage(session);
            msg.setSubject("subject");
            // 设置邮件内容
            msg.setText("text");
            // 设置发件人
            msg.setFrom(new InternetAddress("client@mingshiim.com"));

            Transport transport = session.getTransport();
            // 连接邮件服务器
            transport.connect("client@mingshiim.com", "Ms5665404361");
            // 发送邮件
            transport.sendMessage(msg, new Address[]{new InternetAddress("xiayouJack@outlook.com")});
            // 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        send();
    }
}
