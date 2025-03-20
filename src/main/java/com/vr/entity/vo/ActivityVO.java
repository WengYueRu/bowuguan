package com.vr.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
public class ActivityVO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String aname;
    private String apicture;
    private String atime;
    private String aintroduction;
    private String atype;
    private String aaddress;
    private int anumber;
    private String anote;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date aannounce;
    private int acomment;
    private int acollect;
    private String aenroll;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date clicktime;
    private Integer clicknum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApicture() {
        return apicture;
    }

    public void setApicture(String apicture) {
        this.apicture = apicture;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getAintroduction() {
        return aintroduction;
    }

    public void setAintroduction(String aintroduction) {
        this.aintroduction = aintroduction;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getAaddress() {
        return aaddress;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress;
    }

    public int getAnumber() {
        return anumber;
    }

    public void setAnumber(int anumber) {
        this.anumber = anumber;
    }

    public String getAnote() {
        return anote;
    }

    public void setAnote(String anote) {
        this.anote = anote;
    }

    public Date getAannounce() {
        return aannounce;
    }

    public void setAannounce(Date aannounce) {
        this.aannounce = aannounce;
    }

    public int getAcomment() {
        return acomment;
    }

    public void setAcomment(int acomment) {
        this.acomment = acomment;
    }

    public int getAcollect() {
        return acollect;
    }

    public void setAcollect(int acollect) {
        this.acollect = acollect;
    }

    public String getAenroll() {
        return aenroll;
    }

    public void setAenroll(String aenroll) {
        this.aenroll = aenroll;
    }

    public Date getClicktime() {
        return clicktime;
    }

    public void setClicktime(Date clicktime) {
        this.clicktime = clicktime;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }
}
