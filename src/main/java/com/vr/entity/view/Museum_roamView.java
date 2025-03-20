package com.vr.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vr.entity.Museum_roamEntity;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
@TableName("museum_roam")
public class Museum_roamView extends Museum_roamEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    public Museum_roamView(){
    }
    public Museum_roamView(Museum_roamEntity museum_roamEntity){
        try {
            BeanUtils.copyProperties(this, museum_roamEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
