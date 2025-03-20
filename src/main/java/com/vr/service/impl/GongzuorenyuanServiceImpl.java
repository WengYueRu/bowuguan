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


import com.vr.dao.GongzuorenyuanDao;
import com.vr.entity.GongzuorenyuanEntity;
import com.vr.service.GongzuorenyuanService;
import com.vr.entity.vo.GongzuorenyuanVO;
import com.vr.entity.view.GongzuorenyuanView;

@Service("gongzuorenyuanService")
public class GongzuorenyuanServiceImpl extends ServiceImpl<GongzuorenyuanDao, GongzuorenyuanEntity> implements GongzuorenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuorenyuanEntity> page = this.selectPage(
                new Query<GongzuorenyuanEntity>(params).getPage(),
                new EntityWrapper<GongzuorenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuorenyuanEntity> wrapper) {
		  Page<GongzuorenyuanView> page =new Query<GongzuorenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzuorenyuanVO> selectListVO(Wrapper<GongzuorenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzuorenyuanVO selectVO(Wrapper<GongzuorenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzuorenyuanView> selectListView(Wrapper<GongzuorenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuorenyuanView selectView(Wrapper<GongzuorenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
