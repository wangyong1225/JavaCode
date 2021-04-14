package com.wy.domain;

import java.util.Date;

public class Study {
    private int id;
    private Date date;
    private double time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
