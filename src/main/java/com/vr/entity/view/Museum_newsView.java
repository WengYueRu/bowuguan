package com.vr.entity.view;

import com.vr.entity.Museum_newsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
@TableName("museum_news")
public class Museum_newsView extends Museum_newsEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    public Museum_newsView(){
    }
    public Museum_newsView(Museum_newsEntity museum_newsEntity){
        try {
            BeanUtils.copyProperties(this, museum_newsEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
