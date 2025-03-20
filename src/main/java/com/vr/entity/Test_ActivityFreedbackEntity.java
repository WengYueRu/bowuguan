//package com.vr.entity;
//
//import com.baomidou.mybatisplus.annotations.TableField;
//import com.baomidou.mybatisplus.annotations.TableId;
//import com.baomidou.mybatisplus.annotations.TableName;
//import com.baomidou.mybatisplus.enums.FieldFill;
//import com.baomidou.mybatisplus.enums.IdType;
//import lombok.Data;
//
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//// ActivityFreedbackEntity.java
//@Data
//@TableName("activity_feedback")
//public class Test_ActivityFreedbackEntity {
//    @TableId(type = IdType.AUTO)
//    private Long id;
//
//    @NotNull(message = "活动ID不能为空")
//    private Long activityId;
//
//    @Max(value = 5, message = "评分不能超过5分")
//    private Integer score;
//
//    @Size(max = 500, message = "反馈内容不能超过500字")
//    private String content;
//
//    @TableField(fill = FieldFill.INSERT)
//    private Integer status;
//}
