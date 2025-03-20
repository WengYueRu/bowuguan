package com.vr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vr.dao.ActivityDao;
import com.vr.entity.ActivityEntity;
import com.vr.entity.view.ActivityView;
import com.vr.entity.vo.ActivityVO;
import com.vr.service.ActivityService;
import com.vr.utils.PageUtils;
import com.vr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("activityService")
public class ActivityServiceImpl extends ServiceImpl<ActivityDao, ActivityEntity> implements ActivityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityEntity> page = this.selectPage(
                new Query<ActivityEntity>(params).getPage(),
                new EntityWrapper<ActivityEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<ActivityVO> selectListVO(Wrapper<ActivityEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ActivityVO selectVO(Wrapper<ActivityEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ActivityView> selectListView(Wrapper<ActivityEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ActivityView selectView(Wrapper<ActivityEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ActivityEntity> wrapper) {
        Page<ActivityView> page =new Query<ActivityView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("上传文件不能为空");
        }

        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 生成新文件名
        String fileName = System.currentTimeMillis() + suffix;  // 使用时间戳作为文件名

        // 设置文件存储路径（使用固定路径）
        // 这个路径应该是您的项目根目录下的 upload 文件夹
        String projectPath = System.getProperty("user.dir");
        String uploadPath = projectPath + "/src/main/resources/static/upload/";

        // 确保目录存在
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 保存文件
        File destFile = new File(uploadPath + fileName);
        file.transferTo(destFile);

        // 返回文件访问路径
        return "/upload/" + fileName;
    }

    @Override
    public boolean save(ActivityEntity entity) {
        return false;
    }
}
