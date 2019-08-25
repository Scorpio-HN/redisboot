package com.cssl.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private int sid;
    private String sname;
    private String semail;
    private Date sbornd;
    private int scid;
    private int cid;
    private String cname;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getSbornd() {
        return sbornd;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setSbornd(Date sbornd) {
        this.sbornd = sbornd;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Student(int sid, String sname, String semail, Date sbornd) {
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.sbornd = sbornd;
    }
}
