package com.wave.core.util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailUtil {
    /**
     * 发送邮件
     * @param host smtp服务器
     * @param user 用户名
     * @param pwd 密码
     * @param from 发件人地址
     * @param to 收件人地址 
     * @param cc 抄送人地址 
     * @param bcc 暗送人地址 
     * @param subject 邮件标题
     * @param content 邮件内容
     * @param files 附件文件
     * @param filenames 附件文件名称
     */
    public static void send(String host, String user, String pwd,
            String from, String[] to, String[] cc, String[] bcc, String subject,
            String content, String[] files, String[] filenames) {
        Properties props = new Properties();
        // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", host);
        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");
        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(true);
        // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try {
         // 加载发件人地址
         message.setFrom(new InternetAddress(from));

         // 加载收件人地址
         if (null != to && 0 < to.length) {
             for (String s : to) {
                 message.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
             }
         }
         // 加载抄送人地址
         if (null != cc && 0 < cc.length) {
             for (String s : cc) {
                 message.addRecipient(Message.RecipientType.CC, new InternetAddress(s));
             }
         }
         // 加载暗送人地址
         if (null != bcc && 0 < bcc.length) {
             for (String s : to) {
                 message.addRecipient(Message.RecipientType.BCC, new InternetAddress(s));
             }
         }
         // 加载标题
         message.setSubject(subject);
         // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
         Multipart multipart = new MimeMultipart();

         // 设置邮件的文本内容
         BodyPart contentPart = new MimeBodyPart();
         contentPart.setContent(content, "text/html;charset=UTF-8");
         multipart.addBodyPart(contentPart);
         
         // 添加附件
         if (null != files && 0 < files.length) {
             for (int i = 0; i < files.length; i++) {
                 BodyPart mdp = new MimeBodyPart();
                 FileDataSource fds = new FileDataSource(files[i]);
                 DataHandler dh = new DataHandler(fds);
                 mdp.setDataHandler(dh);
                 mdp.setFileName(MimeUtility.encodeText(filenames[i]));
                 multipart.addBodyPart(mdp);
             }
         }
         
         // 将multipart对象放到message中
         message.setContent(multipart);
         message.setSentDate(new Date());
         // 保存邮件
         message.saveChanges();
         // 发送邮件
         Transport transport = session.getTransport("smtp");
         // 连接服务器的邮箱
         transport.connect(host, user, pwd);
         // 把邮件发送出去
         transport.sendMessage(message, message.getAllRecipients());
         transport.close();
        }
        catch (Exception e) {
         e.printStackTrace();
        }
    }
}
