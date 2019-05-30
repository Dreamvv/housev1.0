package com.mq.mail.controller;

import com.mq.mail.entity.MailEntity;
import com.mq.mail.service.MQsend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

    @Autowired
    private MQsend mQsend;
    @RequestMapping("/send")
    public String send(@RequestBody MailEntity mailEntity){
        System.out.println(mailEntity);
        mQsend.send(mailEntity);
        return "success";
    }
}
