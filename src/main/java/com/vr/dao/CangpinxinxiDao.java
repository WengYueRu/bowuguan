package com.vr.dao;

import com.vr.entity.CangpinxinxiEntity;
import com.vr.entity.view.CangpinxinxiView;
import com.vr.entity.vo.CangpinxinxiVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 藏品信息
 * 
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
public interface CangpinxinxiDao extends BaseMapper<CangpinxinxiEntity> {
	
	List<CangpinxinxiVO> selectListVO(@Param("ew") Wrapper<CangpinxinxiEntity> wrapper);
	
	CangpinxinxiVO selectVO(@Param("ew") Wrapper<CangpinxinxiEntity> wrapper);
	
	List<CangpinxinxiView> selectListView(@Param("ew") Wrapper<CangpinxinxiEntity> wrapper);

	List<CangpinxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<CangpinxinxiEntity> wrapper);
	
	CangpinxinxiView selectView(@Param("ew") Wrapper<CangpinxinxiEntity> wrapper);
	

}
