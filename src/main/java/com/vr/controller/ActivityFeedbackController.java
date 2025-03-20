//package com.vr.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Date;
//import java.io.IOException;
//import javax.servlet.http.HttpServletRequest;
//
//import com.vr.entity.ActivityFeedbackEntity;
//import com.vr.entity.view.ActivityFeedbackView;
//import com.vr.service.ActivityFeedbackService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.vr.annotation.IgnoreAuth;
//
//import com.vr.utils.PageUtils;
//import com.vr.utils.R;
//import com.vr.utils.MPUtil;
//
//@RestController
//@RequestMapping("/activityFeedback")
//public class ActivityFeedbackFeedbackController {
//    @Autowired
//    private ActivityFeedbackService activityFeedbackService;
//
//    @PostMapping("/test")
//    public R testSave() {
//        ActivityFeedbackEntity entity = new ActivityFeedbackEntity();
//        entity.setAname("测试活动");
//        boolean success = activityFeedbackService.save(entity);
//        return R.ok().put("success", success);
//    }
//
//    @RequestMapping("/page")
//    public R page(@RequestParam Map<String, Object> params, ActivityFeedbackEntity activityFeedback,
//                  HttpServletRequest request){
//
//        // 验证分页参数
//        if (params.get("current") == null || params.get("size") == null) {
//            return R.error("分页参数缺失");
//        }
//
//        EntityWrapper<ActivityFeedbackEntity> ew = new EntityWrapper<ActivityFeedbackEntity>();
//
//        Integer tableName = activityFeedback.getAcollect();
//        Integer username = activityFeedback.getAcomment();
//
//        if (tableName != null) {
//            ew.eq("acollect", activityFeedback.getAcollect());
//        }
//        if (username != null) {
//            ew.eq("acomment", activityFeedback.getAcomment());
//        }
//
//        PageUtils page = activityFeedbackService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityFeedback), params), params));
//        return R.ok().put("data", page);
//    }
//
//    @IgnoreAuth
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params, ActivityFeedbackEntity activityFeedback,
//                  HttpServletRequest request){
//        EntityWrapper<ActivityFeedbackEntity> ew = new EntityWrapper<ActivityFeedbackEntity>();
//        PageUtils page = activityFeedbackService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityFeedback), params), params));
//        return R.ok().put("data", page);
//    }
//    /**
//     * 列表
//     */
//    @RequestMapping("/lists")
//    public R list(ActivityFeedbackEntity activityFeedback){
//        EntityWrapper<ActivityFeedbackEntity> ew = new EntityWrapper<ActivityFeedbackEntity>();
//        ew.allEq(MPUtil.allEQMapPre( activityFeedback, "activityFeedback"));
//        return R.ok().put("data", activityFeedbackService.selectListView(ew));
//    }
//    /**
//     * 查询
//     */
//    @RequestMapping("/query")
//    public R query(ActivityFeedbackEntity activityFeedback){
//        EntityWrapper< ActivityFeedbackEntity> ew = new EntityWrapper< ActivityFeedbackEntity>();
//        ew.allEq(MPUtil.allEQMapPre( activityFeedback, "activityFeedback"));
//        ActivityFeedbackView activityFeedbackView =  activityFeedbackService.selectView(ew);
//        return R.ok("查询信息成功").put("data", activityFeedbackView);
//    }
//    /**
//     * 后端详情
//     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Long id){
//        ActivityFeedbackEntity activityFeedback = activityFeedbackService.selectById(id);
//        activityFeedback.setClicknum(activityFeedback.getClicknum()+1);
//        activityFeedback.setClicktime(new Date());
//        activityFeedbackService.updateById(activityFeedback);
//        return R.ok().put("data", activityFeedback);
//    }
//
//    /**
//     * 前端详情
//     */
//    @IgnoreAuth
//    @RequestMapping("/detail/{id}")
//    public R detail(@PathVariable("id") Long id){
//        ActivityFeedbackEntity activityFeedback = activityFeedbackService.selectById(id);
//        activityFeedback.setClicknum(activityFeedback.getClicknum()+1);
//        activityFeedback.setClicktime(new Date());
//        activityFeedbackService.updateById(activityFeedback);
//        return R.ok().put("data", activityFeedback);
//    }
//    /**
//     * 后端保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody ActivityFeedbackEntity activityFeedback, HttpServletRequest request){
//        activityFeedback.setId((new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
//        activityFeedbackService.insert(activityFeedback);
//        return R.ok();
//    }
//    //    @PostMapping("/save")
//    public R saveActivityFeedback(@RequestBody ActivityFeedbackEntity activityFeedback) {
//        try {
//            activityFeedbackService.save(activityFeedback);
//            return R.ok().put("data", activityFeedback);
//        } catch (Exception e) {
//            return R.error("保存失败: " + e.getMessage());
//        }
//    }
//
//    /**
//     * 前端保存
//     */
//    @RequestMapping("/add")
//    public R add(@RequestBody ActivityFeedbackEntity activityFeedback, HttpServletRequest request){
//        activityFeedback.setId((new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
//        activityFeedbackService.insert(activityFeedback);
//        return R.ok();
//    }
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @Transactional
//    public R update(@RequestBody ActivityFeedbackEntity activityFeedback, HttpServletRequest request){
//        activityFeedbackService.updateById(activityFeedback);//全部更新
//        return R.ok();
//    }
//
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Long[] ids){
//        activityFeedbackService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }
//    /**
//     * 提醒接口
//     */
//    @RequestMapping("/remind/{columnName}/{type}")
//    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
//                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
//        map.put("column", columnName);
//        map.put("type", type);
//
//        if(type.equals("2")) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar c = Calendar.getInstance();
//            Date remindStartDate = null;
//            Date remindEndDate = null;
//            if(map.get("remindstart")!=null) {
//                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
//                c.setTime(new Date());
//                c.add(Calendar.DAY_OF_MONTH,remindStart);
//                remindStartDate = c.getTime();
//                map.put("remindstart", sdf.format(remindStartDate));
//            }
//            if(map.get("remindend")!=null) {
//                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
//                c.setTime(new Date());
//                c.add(Calendar.DAY_OF_MONTH,remindEnd);
//                remindEndDate = c.getTime();
//                map.put("remindend", sdf.format(remindEndDate));
//            }
//        }
//
//        Wrapper<ActivityFeedbackEntity> wrapper = new EntityWrapper<ActivityFeedbackEntity>();
//        if(map.get("remindstart")!=null) {
//            wrapper.ge(columnName, map.get("remindstart"));
//        }
//        if(map.get("remindend")!=null) {
//            wrapper.le(columnName, map.get("remindend"));
//        }
//
////        String tableName = request.getSession().getAttribute("tableName").toString();
////        if(tableName.equals("gongzuorenyuan")) {
////            wrapper.eq("gongzuobianhao", (String)request.getSession().getAttribute("username"));
////        }
//
//        int count = activityFeedbackService.selectCount(wrapper);
//        return R.ok().put("count", count);
//    }
//
//    /**
//     * 前端智能排序
//     */
//    @IgnoreAuth
//    @RequestMapping("/autoSort")
//    public R autoSort(@RequestParam Map<String, Object> params, ActivityFeedbackEntity activityFeedback, HttpServletRequest request, String pre){
//        EntityWrapper<ActivityFeedbackEntity> ew = new EntityWrapper<ActivityFeedbackEntity>();
//        Map<String, Object> newMap = new HashMap<String, Object>();
//        Map<String, Object> param = new HashMap<String, Object>();
//        Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, Object> entry = it.next();
//            String key = entry.getKey();
//            String newKey = entry.getKey();
//            if (pre.endsWith(".")) {
//                newMap.put(pre + newKey, entry.getValue());
//            } else if (StringUtils.isEmpty(pre)) {
//                newMap.put(newKey, entry.getValue());
//            } else {
//                newMap.put(pre + "." + newKey, entry.getValue());
//            }
//        }
//        params.put("sort", "clicknum");
//        params.put("order", "desc");
//        PageUtils page = activityFeedbackService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityFeedback), params), params));
//        return R.ok().put("data", page);
//    }
//    /**
//     * 文件上传
//     */
//    /**
//     * 文件上传
//     */
//    @RequestMapping("/upload")
//    public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        try {
//            String url = activityFeedbackService.uploadFile(file, request);
//            return R.ok().put("url", url);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return R.error("文件上传失败: " + e.getMessage());
//        }
//    }
//
//}
