package com.mq.mail.entity;

import java.io.Serializable;

public class MailEntity implements Serializable {

    private String title;
    private String text;
    private String mail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "MailEntity{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
