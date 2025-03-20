package com.vr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vr.utils.PageUtils;
import com.vr.utils.Query;


import com.vr.dao.CangpinxinxiDao;
import com.vr.entity.CangpinxinxiEntity;
import com.vr.service.CangpinxinxiService;
import com.vr.entity.vo.CangpinxinxiVO;
import com.vr.entity.view.CangpinxinxiView;

@Service("cangpinxinxiService")
public class CangpinxinxiServiceImpl extends ServiceImpl<CangpinxinxiDao, CangpinxinxiEntity> implements CangpinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CangpinxinxiEntity> page = this.selectPage(
                new Query<CangpinxinxiEntity>(params).getPage(),
                new EntityWrapper<CangpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CangpinxinxiEntity> wrapper) {
		  Page<CangpinxinxiView> page =new Query<CangpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CangpinxinxiVO> selectListVO(Wrapper<CangpinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CangpinxinxiVO selectVO(Wrapper<CangpinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CangpinxinxiView> selectListView(Wrapper<CangpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CangpinxinxiView selectView(Wrapper<CangpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
