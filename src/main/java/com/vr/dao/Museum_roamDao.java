package com.vr.dao;

import com.vr.entity.Museum_roamEntity;
import com.vr.entity.view.Museum_roamView;
import com.vr.entity.vo.Museum_roamVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
public interface Museum_roamDao extends BaseMapper<Museum_roamEntity>{
    List<Museum_roamVO> selectListVO(@Param("ew") Wrapper<Museum_roamEntity> wrapper);

    Museum_roamVO selectVO(@Param("ew") Wrapper<Museum_roamEntity> wrapper);

    List<Museum_roamView> selectListView(@Param("ew") Wrapper<Museum_roamEntity> wrapper);

    List<Museum_roamView> selectListView(Pagination page,@Param("ew") Wrapper<Museum_roamEntity> wrapper);

    Museum_roamView selectView(@Param("ew") Wrapper<Museum_roamEntity> wrapper);
}
