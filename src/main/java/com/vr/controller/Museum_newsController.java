package com.vr.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.vr.entity.Museum_newsEntity;
import com.vr.entity.view.Museum_newsView;
import com.vr.service.Museum_newsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.vr.annotation.IgnoreAuth;

import com.vr.utils.PageUtils;
import com.vr.utils.R;
import com.vr.utils.MPUtil;
//import com.vr.service.StoreupService;
@RestController
@RequestMapping("/museum_news")
public class Museum_newsController {
    @Autowired
    private Museum_newsService museum_newsService;

//    @Autowired
//    private StoreupService storeupService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, Museum_newsEntity museum_news,
                  HttpServletRequest request){
//        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("gongzuorenyuan")) {
//            zhanlanxinxi.setGongzuobianhao((String)request.getSession().getAttribute("username"));
//        }
        EntityWrapper<Museum_newsEntity> ew = new EntityWrapper<Museum_newsEntity>();
        PageUtils page = museum_newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, museum_news), params), params));
        return R.ok().put("data", page);
    }

    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, Museum_newsEntity museum_news,
                  HttpServletRequest request){
        EntityWrapper<Museum_newsEntity> ew = new EntityWrapper<Museum_newsEntity>();
        PageUtils page = museum_newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, museum_news), params), params));
        return R.ok().put("data", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(Museum_newsEntity museum_news){
        EntityWrapper<Museum_newsEntity> ew = new EntityWrapper<Museum_newsEntity>();
        ew.allEq(MPUtil.allEQMapPre( museum_news, "museum_news"));
        return R.ok().put("data", museum_newsService.selectListView(ew));
    }
    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(Museum_newsEntity museum_news){
        EntityWrapper< Museum_newsEntity> ew = new EntityWrapper< Museum_newsEntity>();
        ew.allEq(MPUtil.allEQMapPre( museum_news, "museum_news"));
        Museum_newsView museum_newsView =  museum_newsService.selectView(ew);
        return R.ok("查询展馆信息成功").put("data", museum_newsView);
    }
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Museum_newsEntity museum_news = museum_newsService.selectById(id);
        museum_news.setClicknum(museum_news.getClicknum()+1);
        museum_news.setClicktime(new Date());
        museum_newsService.updateById(museum_news);
        return R.ok().put("data", museum_news);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        Museum_newsEntity museum_news = museum_newsService.selectById(id);
        museum_news.setClicknum(museum_news.getClicknum()+1);
        museum_news.setClicktime(new Date());
        museum_newsService.updateById(museum_news);
        return R.ok().put("data", museum_news);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Museum_newsEntity museum_news, HttpServletRequest request){
        museum_news.setId((new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
        //ValidatorUtils.validateEntity(zhanlanxinxi);
        museum_newsService.insert(museum_news);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody Museum_newsEntity museum_news, HttpServletRequest request){
        museum_news.setId((new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue()));
        //ValidatorUtils.validateEntity(zhanlanxinxi);
        museum_newsService.insert(museum_news);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody Museum_newsEntity museum_news, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhanlanxinxi);
        museum_newsService.updateById(museum_news);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        museum_newsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if(type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if(map.get("remindstart")!=null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if(map.get("remindend")!=null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<Museum_newsEntity> wrapper = new EntityWrapper<Museum_newsEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }

//        String tableName = request.getSession().getAttribute("tableName").toString();
//        if(tableName.equals("gongzuorenyuan")) {
//            wrapper.eq("gongzuobianhao", (String)request.getSession().getAttribute("username"));
//        }

        int count = museum_newsService.selectCount(wrapper);
        return R.ok().put("count", count);
    }

    /**
     * 前端智能排序
     */
    @IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params, Museum_newsEntity museum_news, HttpServletRequest request, String pre){
        EntityWrapper<Museum_newsEntity> ew = new EntityWrapper<Museum_newsEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            String newKey = entry.getKey();
            if (pre.endsWith(".")) {
                newMap.put(pre + newKey, entry.getValue());
            } else if (StringUtils.isEmpty(pre)) {
                newMap.put(newKey, entry.getValue());
            } else {
                newMap.put(pre + "." + newKey, entry.getValue());
            }
        }
        params.put("sort", "clicknum");
        params.put("order", "desc");
        PageUtils page = museum_newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, museum_news), params), params));
        return R.ok().put("data", page);
    }

}
