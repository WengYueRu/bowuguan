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
@TableName("activity")
public class ActivityEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public ActivityEntity() {
    }
    public ActivityEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @TableId
    private Long id;
    private String aname;
    private String apicture;
    private String atime;
    private String aintroduction;
    private String atype;
    private String aaddress;
    private Integer anumber;  // 改为 Integer
    private String anote;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date aannounce;
    private Integer acomment;  // 改为 Integer
    private Integer acollect;  // 改为 Integer
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

    public Integer getAnumber() {  // 改为 Integer
        return anumber;
    }

    public void setAnumber(Integer anumber) {  // 改为 Integer
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

    public Integer getAcomment() {  // 改为 Integer
        return acomment;
    }

    public void setAcomment(Integer acomment) {  // 改为 Integer
        this.acomment = acomment;
    }

    public Integer getAcollect() {  // 改为 Integer
        return acollect;
    }

    public void setAcollect(Integer acollect) {  // 改为 Integer
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