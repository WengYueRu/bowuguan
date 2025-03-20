package com.vr.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vr.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vr.entity.UserEntity;
import com.vr.service.TokenService;
import com.vr.service.UserService;
import com.vr.utils.MPUtil;
import com.vr.utils.PageUtils;
import com.vr.utils.R;

/**
 * 登录相关
 */
@RequestMapping("users")
@RestController
public class UserController{

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@IgnoreAuth
	@PostMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		logger.info("用户登录: {}", username);

		UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));
		if(user==null || !user.getPassword().equals(password)) {
			logger.warn("登录失败: 账号或密码不正确, username={}", username);
			return R.error("账号或密码不正确");
		}

		// 1. 生成token
		String token = tokenService.generateToken(user.getId(), username, "users", user.getRole());

		// 2. 同时将信息存入session
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", user.getId());
		session.setAttribute("username", username);

		// 根据用户角色设置tableName
		String tableName;
		if ("管理员".equals(user.getRole())) {
			tableName = "users";
		} else if ("工作人员".equals(user.getRole())) {
			tableName = "gongzuorenyuan";
		} else {
			tableName = "yonghu";
		}
		session.setAttribute("tableName", tableName);

		logger.info("登录成功，设置session: userId={}, username={}, tableName={}, sessionId={}",
				user.getId(), username, tableName, session.getId());

		// 3. 返回token给客户端
		return R.ok().put("token", token);
	}

	/**
	 * 注册
	 */
	@IgnoreAuth
	@PostMapping(value = "/register")
	@Transactional(rollbackFor = Exception.class)
	public R register(@RequestBody UserEntity user){
		logger.info("用户注册: {}", user.getUsername());

//    	ValidatorUtils.validateEntity(user);
		if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
			logger.warn("注册失败: 用户已存在, username={}", user.getUsername());
			return R.error("用户已存在");
		}
		userService.insert(user);
		logger.info("注册成功: {}", user.getUsername());
		return R.ok();
	}

	/**
	 * 退出
	 */
	@GetMapping(value = "logout")
	public R logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			logger.info("用户退出: userId={}, sessionId={}",
					session.getAttribute("userId"), session.getId());
			session.invalidate();
		}
		return R.ok("退出成功");
	}

	/**
	 * 密码重置
	 */
	@IgnoreAuth
	@RequestMapping(value = "/resetPass")
	@Transactional(rollbackFor = Exception.class)
	public R resetPass(String username, HttpServletRequest request){
		logger.info("密码重置: {}", username);

		UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));
		if(user==null) {
			logger.warn("密码重置失败: 账号不存在, username={}", username);
			return R.error("账号不存在");
		}
		user.setPassword("123456");
		userService.update(user,null);
		logger.info("密码重置成功: {}", username);
		return R.ok("密码已重置为：123456");
	}

	/**
	 * 列表
	 */
	@RequestMapping("/page")
	public R page(@RequestParam Map<String, Object> params, UserEntity user){
		logger.info("查询用户列表");

		EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
		PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
		return R.ok().put("data", page);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(UserEntity user){
		logger.info("查询用户列表");

		EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
		ew.allEq(MPUtil.allEQMapPre(user, "user"));
		return R.ok().put("data", userService.selectListView(ew));
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") String id){
		logger.info("查询用户信息: id={}", id);

		if (id == null || id.trim().isEmpty()) {
			logger.warn("查询用户信息失败: ID为空");
			return R.error("ID不能为空");
		}

		UserEntity user = userService.selectById(id);
		if (user == null) {
			logger.warn("查询用户信息失败: 用户不存在, id={}", id);
			return R.error("用户不存在");
		}

		return R.ok().put("data", user);
	}

	/**
	 * 获取用户的session用户信息
	 */
	@RequestMapping("/session")
	public R getCurrUser(HttpServletRequest request){
		logger.info("获取当前用户信息");

		HttpSession session = request.getSession(false);
		if (session == null) {
			logger.warn("获取当前用户信息失败: 会话不存在");
			return R.error("会话已过期，请重新登录");
		}

		Object userIdObj = session.getAttribute("userId");
		if (userIdObj == null) {
			logger.warn("获取当前用户信息失败: 会话中userId为空, sessionId={}", session.getId());
			return R.error("会话已过期，请重新登录");
		}

		logger.info("从会话获取userId: {}, 类型: {}", userIdObj, userIdObj.getClass().getName());

		try {
			Long id;
			if (userIdObj instanceof Long) {
				id = (Long) userIdObj;
			} else if (userIdObj instanceof String) {
				id = Long.parseLong((String) userIdObj);
			} else {
				logger.warn("获取当前用户信息失败: userId类型不支持, type={}", userIdObj.getClass().getName());
				return R.error("会话数据类型错误，请重新登录");
			}

			UserEntity user = userService.selectById(id);
			if (user == null) {
				logger.warn("获取当前用户信息失败: 用户不存在, userId={}", id);
				return R.error("用户不存在");
			}

			logger.info("获取当前用户信息成功: userId={}, username={}", id, user.getUsername());
			return R.ok().put("data", user);
		} catch (Exception e) {
			logger.error("获取当前用户信息异常", e);
			return R.error("获取用户信息失败: " + e.getMessage());
		}
	}

	/**
	 * 保存
	 */
	@PostMapping("/save")
	@Transactional(rollbackFor = Exception.class)
	public R save(@RequestBody UserEntity user){
		logger.info("保存用户: {}", user.getUsername());

//    	ValidatorUtils.validateEntity(user);
		if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) !=null) {
			logger.warn("保存用户失败: 用户已存在, username={}", user.getUsername());
			return R.error("用户已存在");
		}
		userService.insert(user);
		logger.info("保存用户成功: {}", user.getUsername());
		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@Transactional(rollbackFor = Exception.class)
	public R update(@RequestBody UserEntity user){
		logger.info("更新用户: id={}, username={}", user.getId(), user.getUsername());

//        ValidatorUtils.validateEntity(user);
		UserEntity u = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername()));
		if(u!=null && u.getId()!=user.getId() && u.getUsername().equals(user.getUsername())) {
			logger.warn("更新用户失败: 用户名已存在, username={}", user.getUsername());
			return R.error("用户名已存在。");
		}
		userService.updateById(user);//全部更新
		logger.info("更新用户成功: id={}, username={}", user.getId(), user.getUsername());
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@Transactional(rollbackFor = Exception.class)
	public R delete(@RequestBody Long[] ids){
		logger.info("删除用户: ids={}", Arrays.toString(ids));

		userService.deleteBatchIds(Arrays.asList(ids));
		logger.info("删除用户成功");
		return R.ok();
	}
}