package com.vr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vr.dao.Museum_roamDao;
import com.vr.entity.Museum_roamEntity;
import com.vr.entity.view.Museum_roamView;
import com.vr.entity.vo.Museum_roamVO;
import com.vr.service.Museum_roamService;
import com.vr.utils.PageUtils;
import com.vr.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("museum_roamService")
public class Museum_roamServiceImpl extends ServiceImpl<Museum_roamDao, Museum_roamEntity> implements Museum_roamService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Museum_roamEntity> page = this.selectPage(
                new Query<Museum_roamEntity>(params).getPage(),
                new EntityWrapper<Museum_roamEntity>()
        );
        return new PageUtils(page);
    }
    @Override
    public List<Museum_roamVO> selectListVO(Wrapper<Museum_roamEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public Museum_roamVO selectVO(Wrapper<Museum_roamEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<Museum_roamView> selectListView(Wrapper<Museum_roamEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public Museum_roamView selectView(Wrapper<Museum_roamEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<Museum_roamEntity> wrapper) {
        Page<Museum_roamView> page =new Query<Museum_roamView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
