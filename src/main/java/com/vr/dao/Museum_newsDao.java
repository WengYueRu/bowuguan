package com.vr.dao;

import com.vr.entity.Museum_newsEntity;
import com.vr.entity.view.Museum_newsView;
import com.vr.entity.vo.Museum_newsVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
public interface Museum_newsDao extends BaseMapper<Museum_newsEntity>{
    List<Museum_newsVO> selectListVO(@Param("ew") Wrapper<Museum_newsEntity> wrapper);

    Museum_newsVO selectVO(@Param("ew") Wrapper<Museum_newsEntity> wrapper);

    List<Museum_newsView> selectListView(@Param("ew") Wrapper<Museum_newsEntity> wrapper);

    List<Museum_newsView> selectListView(Pagination page,@Param("ew") Wrapper<Museum_newsEntity> wrapper);

    Museum_newsView selectView(@Param("ew") Wrapper<Museum_newsEntity> wrapper);

}
