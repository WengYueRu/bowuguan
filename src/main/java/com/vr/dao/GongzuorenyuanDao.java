package com.vr.dao;

import com.vr.entity.GongzuorenyuanEntity;
import com.vr.entity.view.GongzuorenyuanView;
import com.vr.entity.vo.GongzuorenyuanVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 工作人员
 * 
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
public interface GongzuorenyuanDao extends BaseMapper<GongzuorenyuanEntity> {
	
	List<GongzuorenyuanVO> selectListVO(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	
	GongzuorenyuanVO selectVO(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	
	List<GongzuorenyuanView> selectListView(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);

	List<GongzuorenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	
	GongzuorenyuanView selectView(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	

}
