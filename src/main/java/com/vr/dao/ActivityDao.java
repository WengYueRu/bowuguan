package com.vr.dao;

import com.vr.entity.ActivityEntity;
import com.vr.entity.view.ActivityView;
import com.vr.entity.vo.ActivityVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
public interface ActivityDao extends BaseMapper<ActivityEntity>{
    List<ActivityVO> selectListVO(@Param("ew") Wrapper<ActivityEntity> wrapper);

    ActivityVO selectVO(@Param("ew") Wrapper<ActivityEntity> wrapper);

    List<ActivityView> selectListView(@Param("ew") Wrapper<ActivityEntity> wrapper);

    List<ActivityView> selectListView(Pagination page,@Param("ew") Wrapper<ActivityEntity> wrapper);

    ActivityView selectView(@Param("ew") Wrapper<ActivityEntity> wrapper);
}
