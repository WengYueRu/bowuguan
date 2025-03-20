///**
// * 【辅助类】
// * 1、活动状态枚举类
// *
// * 用于统一管理活动反馈的状态标识，包含以下状态：
// * - PENDING: 待审核
// * - PUBLISHED: 已发布
// * - DELETED: 已删除
// */
//package com.vr.enums;
//
//public enum ActivityStatus {
//
//    /** 待审核状态 */
//    PENDING(0, "待审核"),
//
//    /** 已发布状态 */
//    PUBLISHED(1, "已发布"),
//
//    /** 已删除状态 */
//    DELETED(2, "已删除");
//
//
//    // =============================================
//    // 私有属性
//    // =============================================
//
//    /** 状态码（与数据库存储值保持一致） */
//    private final int code;
//
//    /** 状态描述（用于前端展示） */
//    private final String desc;
//
//
//    // =============================================
//    // 构造方法
//    // =============================================
//
//    /**
//     * 私有构造方法，确保枚举实例只能在类内部创建
//     *
//     * @param code 状态码（必须唯一）
//     * @param desc 状态描述（建议使用中文）
//     */
//    ActivityStatus(int code, String desc) {
//        this.code = code;
//        this.desc = desc;
//    }
//
//
//    // =============================================
//    // Getter 方法
//    // =============================================
//
//    /**
//     * 获取状态码
//     *
//     * @return 状态码（数值类型）
//     */
//    public int getCode() {
//        return code;
//    }
//
//
//    /**
//     * 获取状态描述
//     *
//     * @return 状态描述（字符串类型）
//     */
//    public String getDesc() {
//        return desc;
//    }
//
//
//    // =============================================
//    // 静态工厂方法
//    // =============================================
//
//    /**
//     * 根据状态码获取对应的枚举实例
//     *
//     * @param code 状态码
//     * @return 匹配的枚举实例，未找到返回 null
//     */
//    public static ActivityStatus getByCode(int code) {
//        for (ActivityStatus status : ActivityStatus.values()) {
//            if (status.code == code) {
//                return status;
//            }
//        }
//        return null;
//    }
//
//
//    /**
//     * 根据状态描述获取对应的枚举实例
//     *
//     * @param desc 状态描述
//     * @return 匹配的枚举实例，未找到返回 null
//     */
//    public static ActivityStatus getByDesc(String desc) {
//        for (ActivityStatus status : ActivityStatus.values()) {
//            if (status.desc.equals(desc)) {
//                return status;
//            }
//        }
//        return null;
//    }
//
//
//    // =============================================
//    // 扩展方法示例
//    // =============================================
//
//    /**
//     * 获取所有状态的列表（用于下拉框等场景）
//     *
//     * @return 包含状态码和描述的 Map 列表
//     */
//    public static java.util.List<java.util.Map<String, Object>> getStatusList() {
//        java.util.List<java.util.Map<String, Object>> list = new java.util.ArrayList<>();
//        for (ActivityStatus status : ActivityStatus.values()) {
//            java.util.Map<String, Object> item = new java.util.HashMap<>();
//            item.put("code", status.code);
//            item.put("desc", status.desc);
//            list.add(item);
//        }
//        return list;
//    }
//}
//
//
///**
// * 【实现说明】
// * 1.构造方法：
// * （1）私有构造方法确保枚举实例只能在类内部创建
// * （2）参数 code 和 desc 用于初始化枚举属性
// * 2.Getters：
// * （1）getCode() 返回状态码
// * （2）getDesc() 返回状态描述
// * 3.实用方法：
// * （1）getByCode(int code) 根据状态码获取枚举实例
// * （2）getByDesc(String desc) 根据描述获取枚举实例
// */
