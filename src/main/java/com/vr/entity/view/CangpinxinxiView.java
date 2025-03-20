package com.vr.entity.view;

import com.vr.entity.CangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 藏品信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
@TableName("cangpinxinxi")
public class CangpinxinxiView extends CangpinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CangpinxinxiView(){
	}
 
 	public CangpinxinxiView(CangpinxinxiEntity cangpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, cangpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
