package com.vr.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.vr.utils.PageUtils;
import com.vr.entity.Museum_roamEntity;
import java.util.List;
import java.util.Map;
import com.vr.entity.vo.Museum_roamVO;
import org.apache.ibatis.annotations.Param;
import com.vr.entity.view.Museum_roamView;
public interface Museum_roamService extends IService<Museum_roamEntity>{
    PageUtils queryPage(Map<String, Object> params);

    List<Museum_roamVO> selectListVO(Wrapper<Museum_roamEntity> wrapper);

    Museum_roamVO selectVO(@Param("ew") Wrapper<Museum_roamEntity> wrapper);

    List<Museum_roamView> selectListView(Wrapper<Museum_roamEntity> wrapper);

    Museum_roamView selectView(@Param("ew") Wrapper<Museum_roamEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<Museum_roamEntity> wrapper);
}
