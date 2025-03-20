package com.vr.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 藏品信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
public class CangpinxinxiVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 藏品名称
	 */

	private String cangpinmingcheng;
	/**
	 * 藏品类别
	 */
	
	private String cangpinleibie;
		
	/**
	 * 藏品图片
	 */
	
	private String cangpintupian;
		
	/**
	 * 藏品年代
	 */
	
	private String cangpinniandai;
		
	/**
	 * 有关历史
	 */
	
	private String youguanlishi;
		
	/**
	 * 场馆位置
	 */
	
	private String changguanweizhi;
		
	/**
	 * 藏品简介
	 */
	
	private String cangpinjianjie;
		
	/**
	 * 藏品详情
	 */
	
	private String cangpinxiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;

	public String getCangpinmingcheng() {
		return cangpinmingcheng;
	}

	public void setCangpinmingcheng(String cangpinmingcheng) {
		this.cangpinmingcheng = cangpinmingcheng;
	}

	public String getCangpinleibie() {
		return cangpinleibie;
	}

	public void setCangpinleibie(String cangpinleibie) {
		this.cangpinleibie = cangpinleibie;
	}

	public String getCangpintupian() {
		return cangpintupian;
	}

	public void setCangpintupian(String cangpintupian) {
		this.cangpintupian = cangpintupian;
	}

	public String getCangpinniandai() {
		return cangpinniandai;
	}

	public void setCangpinniandai(String cangpinniandai) {
		this.cangpinniandai = cangpinniandai;
	}

	public String getYouguanlishi() {
		return youguanlishi;
	}

	public void setYouguanlishi(String youguanlishi) {
		this.youguanlishi = youguanlishi;
	}

	public String getChangguanweizhi() {
		return changguanweizhi;
	}

	public void setChangguanweizhi(String changguanweizhi) {
		this.changguanweizhi = changguanweizhi;
	}

	public String getCangpinjianjie() {
		return cangpinjianjie;
	}

	public void setCangpinjianjie(String cangpinjianjie) {
		this.cangpinjianjie = cangpinjianjie;
	}

	public String getCangpinxiangqing() {
		return cangpinxiangqing;
	}

	public void setCangpinxiangqing(String cangpinxiangqing) {
		this.cangpinxiangqing = cangpinxiangqing;
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
