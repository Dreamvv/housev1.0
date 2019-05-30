package com.mq.mail.service;

import com.mq.mail.entity.MailEntity;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqReceive {

    @Autowired
    private MailService mailService;

    @RabbitListener(queuesToDeclare =@Queue("mailQueue"))
    public  void process(MailEntity mailEntity){
        String title = mailEntity.getTitle();
        String text = mailEntity.getText();
        String mail = mailEntity.getMail();
        try {
            mailService.sendMail(title,text,mail);
            System.out.println("发送成功");
        } catch (Exception e) {
            System.out.println("发送失败");
        }

    }
}
