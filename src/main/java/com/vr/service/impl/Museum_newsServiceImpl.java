package com.vr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vr.dao.Museum_newsDao;
import com.vr.entity.Museum_newsEntity;
import com.vr.entity.view.Museum_newsView;
import com.vr.entity.vo.Museum_newsVO;
import com.vr.service.Museum_newsService;
import com.vr.utils.PageUtils;
import com.vr.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("museum_newsService")
public class Museum_newsServiceImpl extends ServiceImpl<Museum_newsDao, Museum_newsEntity> implements Museum_newsService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Museum_newsEntity> page = this.selectPage(
                new Query<Museum_newsEntity>(params).getPage(),
                new EntityWrapper<Museum_newsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<Museum_newsVO> selectListVO(Wrapper<Museum_newsEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public Museum_newsVO selectVO(Wrapper<Museum_newsEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<Museum_newsView> selectListView(Wrapper<Museum_newsEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public Museum_newsView selectView(Wrapper<Museum_newsEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<Museum_newsEntity> wrapper) {
        Page<Museum_newsView> page =new Query<Museum_newsView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
