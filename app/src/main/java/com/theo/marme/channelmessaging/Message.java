package com.theo.marme.channelmessaging;

import java.util.Date;

/**
 * Created by marmet on 06/02/2017.
 */
public class Message {

    public int userId;
    public String message;
    public Date date;
    public String url;

    public Message(int userId, String message, Date date, String url) {
        this.userId = userId;
        this.message = message;
        this.date = date;
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
