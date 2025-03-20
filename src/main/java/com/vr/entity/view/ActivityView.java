package com.vr.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vr.entity.ActivityEntity;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
@TableName("activity")
public class ActivityView extends ActivityEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    public ActivityView(){
    }
    public ActivityView(ActivityEntity activityEntity){
        try {
            BeanUtils.copyProperties(this, activityEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
