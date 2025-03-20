package com.vr.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
@TableName("museum_news")
public class Museum_newsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public Museum_newsEntity() {

    }
    public Museum_newsEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId
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
