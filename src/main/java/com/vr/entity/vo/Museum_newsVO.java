package com.vr.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
public class Museum_newsVO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String enname;
    private String encover;
    private String enarea;
    private String enintroduction;
    private String mntime;
    private String mnaddress;
    private String mnheader;
    private Long mntelephone;
    private String mnintroduction;
    private String mnbus;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date clicktime;
    private Integer clicknum;

    public String getMnbus() {
        return mnbus;
    }

    public void setMnbus(String mnbus) {
        this.mnbus = mnbus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getEncover() {
        return encover;
    }

    public void setEncover(String encover) {
        this.encover = encover;
    }

    public String getEnarea() {
        return enarea;
    }

    public void setEnarea(String enarea) {
        this.enarea = enarea;
    }

    public String getEnintroduction() {
        return enintroduction;
    }

    public void setEnintroduction(String enintroduction) {
        this.enintroduction = enintroduction;
    }

    public String getMntime() {
        return mntime;
    }

    public void setMntime(String mntime) {
        this.mntime = mntime;
    }

    public String getMnaddress() {
        return mnaddress;
    }

    public void setMnaddress(String mnaddress) {
        this.mnaddress = mnaddress;
    }

    public String getMnheader() {
        return mnheader;
    }

    public void setMnheader(String mnheader) {
        this.mnheader = mnheader;
    }

    public Long getMntelephone() {
        return mntelephone;
    }

    public void setMntelephone(Long mntelephone) {
        this.mntelephone = mntelephone;
    }

    public String getMnintroduction() {
        return mnintroduction;
    }

    public void setMnintroduction(String mnintroduction) {
        this.mnintroduction = mnintroduction;
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
