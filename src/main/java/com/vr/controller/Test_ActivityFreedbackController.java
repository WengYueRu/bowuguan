//package com.vr.controller;
//
//import com.vr.entity.Test_ActivityFreedbackEntity;
//import com.vr.service.Test_ActivityFreedbackService;
//import com.vr.utils.PageUtils;
//import com.vr.utils.R;
//import com.vr.utils.ValidatorUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/activityFeedback")
//public class Test_ActivityFreedbackController {
//    @Autowired
//    private Test_ActivityFreedbackService activityFreedbackService;
//
//    @PostMapping
//    public R save(@RequestBody Test_ActivityFreedbackEntity entity) {
//        // 数据校验
//        ValidatorUtils.validateAndThrow(entity);
//
//        // 设置默认值
//        entity.setScore(entity.getScore() == null ? 3 : entity.getScore());
//        entity.setStatus(0); // 待审核
//
//        activityFreedbackService.save(entity);
//        return R.ok();
//    }
//
//    @GetMapping
//    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = activityFreedbackService.queryPage(params);
//        return R.ok().put("data", page);
//    }
//}
