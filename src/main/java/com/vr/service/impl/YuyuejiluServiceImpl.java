package com.vr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vr.utils.PageUtils;
import com.vr.utils.Query;

import com.vr.dao.YuyuejiluDao;
import com.vr.entity.YuyuejiluEntity;
import com.vr.service.YuyuejiluService;
import com.vr.entity.vo.YuyuejiluVO;
import com.vr.entity.view.YuyuejiluView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("yuyuejiluService")
@Transactional(rollbackFor = Exception.class)  // 添加类级别的事务注解
public class YuyuejiluServiceImpl extends ServiceImpl<YuyuejiluDao, YuyuejiluEntity> implements YuyuejiluService {

	private static final Logger logger = LoggerFactory.getLogger(YuyuejiluServiceImpl.class);

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<YuyuejiluEntity> page = this.selectPage(
				new Query<YuyuejiluEntity>(params).getPage(),
				new EntityWrapper<YuyuejiluEntity>()
		);
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuejiluEntity> wrapper) {
		Page<YuyuejiluView> page = new Query<YuyuejiluView>(params).getPage();
		page.setRecords(baseMapper.selectListView(page, wrapper));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
	}

	@Override
	public List<YuyuejiluVO> selectListVO(Wrapper<YuyuejiluEntity> wrapper) {
		if (wrapper == null) {
			logger.warn("Wrapper is null in selectListVO");
			wrapper = new EntityWrapper<>();
		}
		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public YuyuejiluVO selectVO(Wrapper<YuyuejiluEntity> wrapper) {
		if (wrapper == null) {
			logger.warn("Wrapper is null in selectVO");
			wrapper = new EntityWrapper<>();
		}
		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<YuyuejiluView> selectListView(Wrapper<YuyuejiluEntity> wrapper) {
		if (wrapper == null) {
			logger.warn("Wrapper is null in selectListView");
			wrapper = new EntityWrapper<>();
		}
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuejiluView selectView(Wrapper<YuyuejiluEntity> wrapper) {
		if (wrapper == null) {
			logger.warn("Wrapper is null in selectView");
			wrapper = new EntityWrapper<>();
		}
		logger.debug("Executing selectView with wrapper: {}", wrapper.getSqlSegment());
		return baseMapper.selectView(wrapper);
	}
}