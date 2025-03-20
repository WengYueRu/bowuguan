package com.vr.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.vr.entity.ActivityEntity;
import com.vr.entity.view.ActivityView;
import com.vr.entity.vo.ActivityVO;
import com.vr.utils.PageUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ActivityService extends IService<ActivityEntity>{
    PageUtils queryPage(Map<String, Object> params);

    List<ActivityVO> selectListVO(Wrapper<ActivityEntity> wrapper);

    ActivityVO selectVO(@Param("ew") Wrapper<ActivityEntity> wrapper);

    List<ActivityView> selectListView(Wrapper<ActivityEntity> wrapper);

    ActivityView selectView(@Param("ew") Wrapper<ActivityEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityEntity> wrapper);
    String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException;

    boolean save(ActivityEntity entity);
}
