package com.openicu.boot.senior.mail;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/9/14
 */

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailWeb {

    @Resource
    private SendMailService sendMailService;

    @GetMapping("/send/mail")
    public String sendMail(){
        String[] toUsers = new String[]{"邮箱1","邮箱2"};
        String subject = "2023-07-10邮件";
        String content = "2023-07-10邮件内容" ;
        String attachPath = "classpath:mail/attach-mail.jpg" ;
        try {
            return sendMailService.sendMail(toUsers,subject,content,attachPath) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "send...mail...fail" ;
    }

}
