package com.vr.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.vr.utils.PageUtils;
import com.vr.entity.CangpinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.vr.entity.vo.CangpinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.vr.entity.view.CangpinxinxiView;


/**
 * 藏品信息
 *
 * @author 
 * @email 
 * @date 2022-05-03 15:16:55
 */
public interface CangpinxinxiService extends IService<CangpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CangpinxinxiVO> selectListVO(Wrapper<CangpinxinxiEntity> wrapper);
   	
   	CangpinxinxiVO selectVO(@Param("ew") Wrapper<CangpinxinxiEntity> wrapper);
   	
   	List<CangpinxinxiView> selectListView(Wrapper<CangpinxinxiEntity> wrapper);
   	
   	CangpinxinxiView selectView(@Param("ew") Wrapper<CangpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CangpinxinxiEntity> wrapper);
   	

}

