package com.openicu.boot.senior.mail;

import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/9/14
 */
@Service
public class SendMailService {

    @Value("${spring.mail.username}")
    private String userName ;

    @Resource
    private JavaMailSender sender;

    /**
     * 带附件的邮件发送方法
     * @param toUsers 接收人
     * @param subject 主题
     * @param content 内容
     * @param attachPath 附件地址
     * @return java.lang.String
     * @since 2023-07-10 17:03
     */
    public String sendMail (String[] toUsers,String subject,
                            String content,String attachPath) throws Exception {
        // MIME邮件类
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 邮件发送方 From 和接收方To
        helper.setFrom(userName);
        helper.setTo(toUsers);
        // 邮件主题和内容
        helper.setSubject(subject);
        helper.setText(content);
        // 邮件中的附件
        File attachFile = ResourceUtils.getFile(attachPath);
        helper.addAttachment(attachFile.getName(), attachFile);
        // 执行邮件发送命令
        sender.send(mimeMessage);
        return "send...mail...sus" ;
    }
}

