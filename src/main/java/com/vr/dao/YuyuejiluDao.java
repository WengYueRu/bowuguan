package com.vr.dao;

import com.vr.entity.YuyuejiluEntity;
import com.vr.entity.view.YuyuejiluView;
import com.vr.entity.vo.YuyuejiluVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 预约记录
 */
public interface YuyuejiluDao extends BaseMapper<YuyuejiluEntity> {
	
	List<YuyuejiluVO> selectListVO(@Param("ew") Wrapper<YuyuejiluEntity> wrapper);
	
	YuyuejiluVO selectVO(@Param("ew") Wrapper<YuyuejiluEntity> wrapper);
	
	List<YuyuejiluView> selectListView(@Param("ew") Wrapper<YuyuejiluEntity> wrapper);

	List<YuyuejiluView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuejiluEntity> wrapper);
	
	YuyuejiluView selectView(@Param("ew") Wrapper<YuyuejiluEntity> wrapper);
	

}
