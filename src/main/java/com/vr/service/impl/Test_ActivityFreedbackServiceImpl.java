//package com.vr.service.impl;
//
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.vr.dao.ActivityFreedbackDao;
//import com.vr.entity.Test_ActivityFreedbackEntity;
//import com.vr.service.Test_ActivityFreedbackService;
//import com.vr.utils.PageUtils;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.springframework.stereotype.Service;
//import java.util.Map;
//
//@Service("activityService")
//public class Test_ActivityFreedbackServiceImpl extends ServiceImpl<ActivityFreedbackDao, Test_ActivityFreedbackEntity>
//        implements Test_ActivityFreedbackService {
//
//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        Page<Test_ActivityFreedbackEntity> page = new Page<>(
//                Long.parseLong(params.get("page").toString()),
//                Long.parseLong(params.get("limit").toString())
//        );
//        IPage<Test_ActivityFreedbackEntity> result = page(page);
//        return new PageUtils(result);
//    }
//}