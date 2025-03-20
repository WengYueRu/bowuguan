package com.vr.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
public class Museum_roamVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String mrname;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date clicktime;
    private String mrcover;
    private String mrposition;
    private String mrintroduction;
    private String mrvideo;
    private int mrcomment;
    private int mrcollect;
    private String mnheader;
    private Integer clicknum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMrname() {
        return mrname;
    }

    public void setMrname(String mrname) {
        this.mrname = mrname;
    }

    public Date getClicktime() {
        return clicktime;
    }

    public void setClicktime(Date clicktime) {
        this.clicktime = clicktime;
    }

    public String getMrcover() {
        return mrcover;
    }

    public void setMrcover(String mrcover) {
        this.mrcover = mrcover;
    }

    public String getMrposition() {
        return mrposition;
    }

    public void setMrposition(String mrposition) {
        this.mrposition = mrposition;
    }

    public String getMrintroduction() {
        return mrintroduction;
    }

    public void setMrintroduction(String mrintroduction) {
        this.mrintroduction = mrintroduction;
    }

    public String getMrvideo() {
        return mrvideo;
    }

    public void setMrvideo(String mrvideo) {
        this.mrvideo = mrvideo;
    }

    public int getMrcomment() {
        return mrcomment;
    }

    public void setMrcomment(int mrcomment) {
        this.mrcomment = mrcomment;
    }

    public int getMrcollect() {
        return mrcollect;
    }

    public void setMrcollect(int mrcollect) {
        this.mrcollect = mrcollect;
    }

    public String getMnheader() {
        return mnheader;
    }

    public void setMnheader(String mnheader) {
        this.mnheader = mnheader;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }
}
