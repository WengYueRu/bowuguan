package com.vr.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.vr.utils.PageUtils;
import com.vr.entity.Museum_newsEntity;
import java.util.List;
import java.util.Map;
import com.vr.entity.vo.Museum_newsVO;
import org.apache.ibatis.annotations.Param;
import com.vr.entity.view.Museum_newsView;
public interface Museum_newsService extends IService<Museum_newsEntity>{
    PageUtils queryPage(Map<String, Object> params);

    List<Museum_newsVO> selectListVO(Wrapper<Museum_newsEntity> wrapper);

    Museum_newsVO selectVO(@Param("ew") Wrapper<Museum_newsEntity> wrapper);

    List<Museum_newsView> selectListView(Wrapper<Museum_newsEntity> wrapper);

    Museum_newsView selectView(@Param("ew") Wrapper<Museum_newsEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<Museum_newsEntity> wrapper);
}
