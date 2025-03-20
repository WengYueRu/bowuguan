package com.vr.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

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

import com.vr.entity.CangpinxinxiEntity;
import com.vr.entity.view.CangpinxinxiView;

import com.vr.service.CangpinxinxiService;
import com.vr.utils.PageUtils;
import com.vr.utils.R;
import com.vr.utils.MPUtil;

/**
 * 藏品信息
 * 后端接口
 */
@RestController
@RequestMapping("/cangpinxinxi")
public class CangpinxinxiController {

    @Autowired
    private CangpinxinxiService cangpinxinxiService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CangpinxinxiEntity cangpinxinxi,
				  HttpServletRequest request){
        EntityWrapper<CangpinxinxiEntity> ew = new EntityWrapper<CangpinxinxiEntity>();
		PageUtils page = cangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangpinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, CangpinxinxiEntity cangpinxinxi,
				  HttpServletRequest request){
        EntityWrapper<CangpinxinxiEntity> ew = new EntityWrapper<CangpinxinxiEntity>();
		PageUtils page = cangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CangpinxinxiEntity cangpinxinxi){
       	EntityWrapper<CangpinxinxiEntity> ew = new EntityWrapper<CangpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cangpinxinxi, "cangpinxinxi"));
        return R.ok().put("data", cangpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CangpinxinxiEntity cangpinxinxi){
        EntityWrapper<CangpinxinxiEntity> ew = new EntityWrapper<CangpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cangpinxinxi, "cangpinxinxi"));
		CangpinxinxiView zangpinxinxiView =  cangpinxinxiService.selectView(ew);
		return R.ok("查询藏品信息成功").put("data", zangpinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CangpinxinxiEntity cangpinxinxi = cangpinxinxiService.selectById(id);
		cangpinxinxi.setClicknum(cangpinxinxi.getClicknum()+1);
		cangpinxinxi.setClicktime(new Date());
		cangpinxinxiService.updateById(cangpinxinxi);
        return R.ok().put("data", cangpinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CangpinxinxiEntity cangpinxinxi = cangpinxinxiService.selectById(id);
		cangpinxinxi.setClicknum(cangpinxinxi.getClicknum()+1);
		cangpinxinxi.setClicktime(new Date());
		cangpinxinxiService.updateById(cangpinxinxi);
        return R.ok().put("data", cangpinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CangpinxinxiEntity cangpinxinxi, HttpServletRequest request){
		cangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zangpinxinxi);
        cangpinxinxiService.insert(cangpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CangpinxinxiEntity cangpinxinxi, HttpServletRequest request){
		cangpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zangpinxinxi);
        cangpinxinxiService.insert(cangpinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CangpinxinxiEntity cangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zangpinxinxi);
        cangpinxinxiService.updateById(cangpinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cangpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
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
		
		Wrapper<CangpinxinxiEntity> wrapper = new EntityWrapper<CangpinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = cangpinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params, CangpinxinxiEntity cangpinxinxi, HttpServletRequest request, String pre){
        EntityWrapper<CangpinxinxiEntity> ew = new EntityWrapper<CangpinxinxiEntity>();
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
		PageUtils page = cangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangpinxinxi), params), params));
        return R.ok().put("data", page);
    }







}
