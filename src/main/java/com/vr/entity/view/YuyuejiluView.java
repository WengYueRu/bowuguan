package com.vr.entity.view;

import com.vr.entity.YuyuejiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预约记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
@TableName("yuyuejilu")
public class YuyuejiluView  extends YuyuejiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyuejiluView(){
	}
 
 	public YuyuejiluView(YuyuejiluEntity yuyuejiluEntity){
 	try {
			BeanUtils.copyProperties(this, yuyuejiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
