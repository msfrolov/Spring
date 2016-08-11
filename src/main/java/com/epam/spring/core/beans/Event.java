package com.epam.spring.core.beans;

import java.util.Date;
import java.util.Random;

public class Event {
    private long id;
    private String msg;
    private Date date;

    public Event(String msg) {
        this.id = new Random().nextInt(1000);
        this.msg = msg;
    }

    @Override public String toString() {
        return "Event{" + "id=" + id + ", msg='" + msg + '\'' + ", date=" + date + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
