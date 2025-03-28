package com.vr.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.vr.utils.PageUtils;
import com.vr.entity.YuyuejiluEntity;
import java.util.List;
import java.util.Map;
import com.vr.entity.vo.YuyuejiluVO;
import org.apache.ibatis.annotations.Param;
import com.vr.entity.view.YuyuejiluView;


/**
 * 预约记录
 *
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
public interface YuyuejiluService extends IService<YuyuejiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuejiluVO> selectListVO(Wrapper<YuyuejiluEntity> wrapper);
   	
   	YuyuejiluVO selectVO(@Param("ew") Wrapper<YuyuejiluEntity> wrapper);
   	
   	List<YuyuejiluView> selectListView(Wrapper<YuyuejiluEntity> wrapper);
   	
   	YuyuejiluView selectView(@Param("ew") Wrapper<YuyuejiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuejiluEntity> wrapper);
   	

}

