package com.jack.review.test.sendEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @Description: 阿里云服务器 通过JavaMail发送邮箱STMP问题 25端口被禁用 使用SSL协议465端口 https://www.cnblogs.com/loveincode/p/6476358.html
 * @Auther: Jack You
 * @Date: 2021/05/14/15:58
 */
public class outLook {
    /*https://blog.csdn.net/ZUFE_ZXh/article/details/104297132
    云主机(服务器)无法PING通及端口开放的问题，安全组如何设置
    初次使用云主机时，会有一些需要注意的地方，如：可以远程登录云主机但是无法ping通，在云主机安装数据库后，无法远程连接，搭建了邮件服务器但是无法发送邮件等等，这些主要都是涉及端口的开放。*/

    public static boolean SendEmail(String sender,String password,String host,String port,String receiver)
    {

        try{

            Properties props = new Properties();
            // 开启debug调试
            props.setProperty("mail.debug", "true");  //false
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", host);
            // 发送邮件协议名称 这里使用的是smtp协议
            props.setProperty("mail.transport.protocol", "smtp");
            // 服务端口号
            props.setProperty("mail.smtp.port", port);
            props.put("mail.smtp.starttls.enable", "true");

            // 设置环境信息
            Session session = Session.getInstance(props);

            // 创建邮件对象
            MimeMessage msg = new MimeMessage(session);

            // 设置发件人
            msg.setFrom(new InternetAddress(sender));

            // 设置收件人
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            // 设置邮件主题
            msg.setSubject("this is subject");

            // 设置邮件内容
            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            //发送邮件的文本内容
            textPart.setText("this is the text");
            multipart.addBodyPart(textPart);

            // 添加附件
            MimeBodyPart attachPart = new MimeBodyPart();
            //可以选择发送文件...
            //DataSource source = new FileDataSource("C:\\Users\\36268\\Desktop\\WorkSpace\\MyApp\\Program.cs");
            //attachPart.setDataHandler(new DataHandler(source));
            //设置文件名
            //attachPart.setFileName("Program.cs");
            multipart.addBodyPart(attachPart);

            msg.setContent(multipart);

            Transport transport = session.getTransport();
            // 连接邮件服务器
            transport.connect(sender, password);
            // 发送邮件
            transport.sendMessage(msg, new Address[]{new InternetAddress(receiver)});
            // 关闭连接
            transport.close();

            return true;
        }catch( Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

        /*String sender = "client@mingshiim.com";
        String password = "Ms566540436"; //填写你的outlook帐户的密码
        Ms566540436

        // 收件人邮箱地址
        String receiver = "452733450@qq.com";

        // office365 邮箱服务器地址及端口号
        //这个就是之前的Server Name，注意：你使用的Outlook应用可能使用了不同的服务器，根据自己刚才拿到的地址为准
        *//*String host = "40.73.164.194";*//*
        // AUTH登录命令跟踪被抑制
        *//*String host = "smtp.office365.com";*//*
        String host = "smtp.partner.outlook.cn";
        String port = "587";    //这个就是拿到的port
        boolean b = SendEmail(sender, password, host, port, receiver);
        if(b)
        {
            System.out.println("发送成功");
        }else
        {
            System.out.println("发送失败");
        }*/

        sendSMTPMail("452733450@qq.com","hello","hi");
    }


    /*static String  USER_NAME   ="client@mingshiim.com";
    static String  PASSWORD    = "Ms5665404361";*/

    static String  USER_NAME   ="meishi@mingshiim.com";
    static String  PASSWORD    = "Mn123321";

    /*static String  USER_NAME   ="xiayouJack@outlook.com";
    static String  PASSWORD    = "pb951028";*/

    public static boolean sendSMTPMail(String to, String text, String title) {
        // smtp.partner.outlook.cn   smtp.office365.com  40.73.164.194 pop3
        String host = "smtp.partner.outlook.cn";
        String mailStoreType = "smtp";
        String popPort = "587";
        final Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.store.protocol", mailStoreType);
        props.put( "mail.smtp.port", popPort );
        //开启SSL
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port",popPort);
        props.put("mail.smtp.socketFactory.fallback","false");
        try {
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER_NAME, PASSWORD);//账号密码
                }
            });
            session.setDebug(true);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            InternetAddress form = new InternetAddress(USER_NAME);
            message.setFrom(form);
            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            // 设置邮件标题
            message.setSubject(title);
            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
