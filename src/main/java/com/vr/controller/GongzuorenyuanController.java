package com.vr.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

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

import com.vr.entity.GongzuorenyuanEntity;
import com.vr.entity.view.GongzuorenyuanView;

import com.vr.service.GongzuorenyuanService;
import com.vr.service.TokenService;
import com.vr.utils.PageUtils;
import com.vr.utils.R;
import com.vr.utils.MPUtil;
//import com.vr.service.StoreupService;

/**
 * 工作人员
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
@RestController
@RequestMapping("/gongzuorenyuan")
public class GongzuorenyuanController {
    @Autowired
    private GongzuorenyuanService gongzuorenyuanService;

//    @Autowired
//    private StoreupService storeupService;

    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		GongzuorenyuanEntity user = gongzuorenyuanService.selectOne(new EntityWrapper<GongzuorenyuanEntity>().eq("gongzuobianhao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(user.getId(), username,"gongzuorenyuan",  "工作人员" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody GongzuorenyuanEntity gongzuorenyuan){
    	//ValidatorUtils.validateEntity(gongzuorenyuan);
    	GongzuorenyuanEntity user = gongzuorenyuanService.selectOne(new EntityWrapper<GongzuorenyuanEntity>().eq("gongzuobianhao", gongzuorenyuan.getGongzuobianhao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		gongzuorenyuan.setId(uId);
        gongzuorenyuanService.insert(gongzuorenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        GongzuorenyuanEntity user = gongzuorenyuanService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	GongzuorenyuanEntity user = gongzuorenyuanService.selectOne(new EntityWrapper<GongzuorenyuanEntity>().eq("gongzuobianhao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setMima("123456");
        gongzuorenyuanService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GongzuorenyuanEntity gongzuorenyuan,
				  HttpServletRequest request){
        EntityWrapper<GongzuorenyuanEntity> ew = new EntityWrapper<GongzuorenyuanEntity>();
		PageUtils page = gongzuorenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuorenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, GongzuorenyuanEntity gongzuorenyuan,
				  HttpServletRequest request){
        EntityWrapper<GongzuorenyuanEntity> ew = new EntityWrapper<GongzuorenyuanEntity>();
		PageUtils page = gongzuorenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuorenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(GongzuorenyuanEntity gongzuorenyuan){
       	EntityWrapper<GongzuorenyuanEntity> ew = new EntityWrapper<GongzuorenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuorenyuan, "gongzuorenyuan")); 
        return R.ok().put("data", gongzuorenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuorenyuanEntity gongzuorenyuan){
        EntityWrapper< GongzuorenyuanEntity> ew = new EntityWrapper< GongzuorenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuorenyuan, "gongzuorenyuan")); 
		GongzuorenyuanView gongzuorenyuanView =  gongzuorenyuanService.selectView(ew);
		return R.ok("查询工作人员成功").put("data", gongzuorenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(id);
        return R.ok().put("data", gongzuorenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(id);
        return R.ok().put("data", gongzuorenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuorenyuanEntity gongzuorenyuan, HttpServletRequest request){
    	gongzuorenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuorenyuan);
    	GongzuorenyuanEntity user = gongzuorenyuanService.selectOne(new EntityWrapper<GongzuorenyuanEntity>().eq("gongzuobianhao", gongzuorenyuan.getGongzuobianhao()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		gongzuorenyuan.setId(new Date().getTime());
        gongzuorenyuanService.insert(gongzuorenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuorenyuanEntity gongzuorenyuan, HttpServletRequest request){
    	gongzuorenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuorenyuan);
    	GongzuorenyuanEntity user = gongzuorenyuanService.selectOne(new EntityWrapper<GongzuorenyuanEntity>().eq("gongzuobianhao", gongzuorenyuan.getGongzuobianhao()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		gongzuorenyuan.setId(new Date().getTime());
        gongzuorenyuanService.insert(gongzuorenyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongzuorenyuanEntity gongzuorenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuorenyuan);
        gongzuorenyuanService.updateById(gongzuorenyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzuorenyuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GongzuorenyuanEntity> wrapper = new EntityWrapper<GongzuorenyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = gongzuorenyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
