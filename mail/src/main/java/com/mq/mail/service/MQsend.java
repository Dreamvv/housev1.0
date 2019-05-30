package com.mq.mail.service;

import com.mq.mail.entity.MailEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MQsend {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(MailEntity mailEntity){
        rabbitTemplate.convertAndSend("mailQueue",mailEntity);
    }
}
