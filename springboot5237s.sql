/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3305
 Source Server Type    : MySQL
 Source Server Version : 80040 (8.0.40)
 Source Host           : localhost:3305
 Source Schema         : springboot5237s

 Target Server Type    : MySQL
 Target Server Version : 80040 (8.0.40)
 File Encoding         : 65001

 Date: 21/03/2025 15:10:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `atime` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `apicture` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `aintroduction` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `atype` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `aaddress` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `anumber` int NOT NULL DEFAULT 0,
  `anote` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `aannounce` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `acomment` int NULL DEFAULT NULL,
  `acollect` int NULL DEFAULT NULL,
  `aenroll` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `clicktime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `clicknum` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1742090833532 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1741422136971, '回顾历史', '3月8日上午8:00', 'upload/zhanlanxinxi_changguantupian3.jpg', '<p>简介1</p>', '红色精神', '铁西馆', 40, '有序参观', '2025-03-08 16:22:16', 0, 0, '0', '2025-03-21 14:32:04', 15);
INSERT INTO `activity` VALUES (1741422508697, '朝气蓬勃', '3月20日上午9:30', 'upload/canguanrenshu_tupian4.jpg', '<p>嗨</p>', '青春', '铸造馆', 100, '注意安全', '2025-03-08 16:28:28', 0, 0, '0', '2025-03-19 19:54:43', 14);
INSERT INTO `activity` VALUES (1742090350583, '传承记忆', '3月19日下午1:00', 'upload/canguanrenshu_tupian3.jpg', '<p>你好</p>', '回忆', '机床馆', 20, '注意安全', '2025-03-16 09:59:10', 0, 0, NULL, '2025-03-19 19:57:08', 3);
INSERT INTO `activity` VALUES (1742090833531, '志愿活动', '4月1日上午7:00', 'upload/canguanrenshu_tupian1.jpg', '<p>hello</p>', '志愿', '博物馆大厅', 10, '准时到达', '2025-03-16 10:07:13', 0, 0, NULL, '2025-03-19 19:55:53', 17);

-- ----------------------------
-- Table structure for activity_enroll
-- ----------------------------
DROP TABLE IF EXISTS `activity_enroll`;
CREATE TABLE `activity_enroll`  (
  `id` bigint NOT NULL,
  `yonghuming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `aname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `atype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `aetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `aestate` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '否',
  `aenote` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `clicktime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`yonghuming` ASC) USING BTREE,
  INDEX `aid`(`aname` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_enroll
-- ----------------------------
INSERT INTO `activity_enroll` VALUES (1, '用户名1', '回顾历史', '红色精神', '2025-03-18 19:46:52', '是', '你好世界', '2025-03-19 19:49:06');
INSERT INTO `activity_enroll` VALUES (2, '用户名2', '朝气蓬勃', '青春', '2025-03-18 19:51:28', '是', '嗨嗨嗨', '2025-03-19 19:03:28');
INSERT INTO `activity_enroll` VALUES (1742384844515, '用户名4', '回顾历史', '红色精神', '2025-03-19 19:47:24', '是', '哈哈哈', '2025-03-19 19:49:08');
INSERT INTO `activity_enroll` VALUES (1742384882254, '用户名3', '回顾历史', '红色精神', '2025-03-19 19:48:01', '否', '我们一起', NULL);

-- ----------------------------
-- Table structure for activity_feedback
-- ----------------------------
DROP TABLE IF EXISTS `activity_feedback`;
CREATE TABLE `activity_feedback`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `activity_id` bigint NOT NULL COMMENT '活动 ID',
  `user_id` bigint NOT NULL COMMENT '用户 ID',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '反馈内容',
  `score` tinyint NOT NULL COMMENT '评分（1 - 5）',
  `image_paths` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '图片路径，多个路径用逗号分隔',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` tinyint NULL DEFAULT 0 COMMENT '状态（0: 待审核，1: 已审核，2: 已删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `activity_id`(`activity_id` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `activity_feedback_ibfk_1` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `activity_feedback_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for cangpinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `cangpinxinxi`;
CREATE TABLE `cangpinxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cangpinmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '藏品名称',
  `cangpinleibie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '藏品类别',
  `cangpintupian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '藏品图片',
  `cangpinniandai` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '藏品年代',
  `youguanlishi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '有关历史',
  `changguanweizhi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '场馆位置',
  `cangpinjianjie` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '藏品简介',
  `cangpinxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '藏品详情',
  `clicktime` datetime NULL DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int NULL DEFAULT 0 COMMENT '点击次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1742113245756 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '藏品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cangpinxinxi
-- ----------------------------
INSERT INTO `cangpinxinxi` VALUES (1, '2022-05-03 15:17:29', '达芬奇设计的锯床模型', '藏品类别1', 'upload/机床馆部分1图1.jpg', '藏品年代1', '有关历史1', '场馆位置1', '藏品简介1', '藏品详情1', '2025-03-17 10:46:23', 19);
INSERT INTO `cangpinxinxi` VALUES (2, '2022-05-03 15:17:29', 'C630型车床', '藏品类别2', 'upload/机床馆部分1图2.jpg', '藏品年代2', '有关历史2', '场馆位置2', '藏品简介2', '藏品详情2', '2022-05-03 15:17:29', 2);
INSERT INTO `cangpinxinxi` VALUES (3, '2022-05-03 15:17:29', 'C512单柱立式车床', '藏品类别3', 'upload/机床馆部分1图3.jpg', '藏品年代3', '有关历史3', '场馆位置3', '藏品简介3', '藏品详情3', '2022-05-03 15:17:29', 3);
INSERT INTO `cangpinxinxi` VALUES (4, '2022-05-03 15:17:29', '老式车床', '藏品类别4', 'upload/机床馆部分2图1.jpg', '藏品年代4', '有关历史4', '场馆位置4', '藏品简介4', '藏品详情4', '2022-05-03 15:17:29', 4);
INSERT INTO `cangpinxinxi` VALUES (5, '2022-05-03 15:17:29', 'M4220型珩磨机床', '藏品类别5', 'upload/机床馆部分2图2.jpg', '藏品年代5', '有关历史5', '场馆位置5', '藏品简介5', '藏品详情5', '2022-05-03 15:17:29', 5);
INSERT INTO `cangpinxinxi` VALUES (6, '2022-05-03 15:17:29', 'Z3140A万向摇臂钻床', '藏品类别6', 'upload/机床馆部分2图3.jpg', '藏品年代6', '有关历史6', '场馆位置6', '藏品简介6', '藏品详情6', '2022-05-03 15:17:29', 6);
INSERT INTO `cangpinxinxi` VALUES (7, '2025-03-16 16:20:45', 'CAK6150N型车床', '藏品类别7', 'upload/机床馆部分3图1.jpg', '藏品年代7', '有关历史7', '场馆位置7', '藏品简介7', '藏品详情7', '2025-03-17 09:24:29', 1);
INSERT INTO `cangpinxinxi` VALUES (8, '2025-03-17 09:07:22', 'THY5640型立式加工中心', '藏品类别8', 'upload/机床馆部分3图2.jpg', '藏品年代8', '有关历史8', '场馆位置8', '藏品简介8', '藏品详情8', NULL, 0);
INSERT INTO `cangpinxinxi` VALUES (9, '2025-03-17 09:08:34', 'VMC0656e型五轴加工中心', '藏品类别9', 'upload/机床馆部分3图3.jpg', '藏品年代9', '有关历史9', '场馆位置9', '藏品简介9', '藏品详情9', NULL, 0);
INSERT INTO `cangpinxinxi` VALUES (10, '2025-03-17 09:08:45', '上海SH760', '藏品类别10', 'upload/汽车馆图1.jpg', '藏品年代10', '有关历史10', '场馆位置10', '藏品简介10', '藏品详情10', NULL, 0);
INSERT INTO `cangpinxinxi` VALUES (11, '2025-03-17 09:08:58', '雪铁龙CX', '藏品类别11', 'upload/汽车馆图2.jpg', '藏品年代11', '有关历史11', '场馆位置11', '藏品简介11', '藏品详情11', NULL, 0);
INSERT INTO `cangpinxinxi` VALUES (12, '2025-03-17 09:09:14', '林肯加长车', '藏品类别12', 'upload/汽车馆图3.jpg', '藏品年代12', '有关历史12', '场馆位置12', '藏品简介12', '藏品详情12', NULL, 0);
INSERT INTO `cangpinxinxi` VALUES (13, '2025-03-17 10:02:28', '红旗牌旅行车CA-630', '藏品类别13', 'upload/汽车馆图4.jpg', '藏品年代13', '有关历史13', '场馆位置13', '藏品简介13', '藏品详情13', NULL, 0);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/picture1.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/picture2.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/picture3.jpg');

-- ----------------------------
-- Table structure for museum_news
-- ----------------------------
DROP TABLE IF EXISTS `museum_news`;
CREATE TABLE `museum_news`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `encover` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `enarea` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `enintroduction` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `mntime` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `mnaddress` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `mnheader` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `mntelephone` bigint NOT NULL,
  `mnintroduction` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `mnbus` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `clicktime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `clicknum` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1740803312368 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of museum_news
-- ----------------------------
INSERT INTO `museum_news` VALUES (1, '铁西馆', 'upload/zhanlanxinxi_changguantupian1.jpg', '300', '<p>1</p>', '上午9:00-下午17:00', '铸造馆西', '刘女士', 13823888885, '优美', '111', '2025-03-21 14:38:50', 106);
INSERT INTO `museum_news` VALUES (1740803055978, '机床馆', 'upload/zhanlanxinxi_changguantupian3.jpg', '300', '<p>7</p>', '上午9:00-下午17:00', '大厅西', '张女士', 13823888886, '历史悠久', '777', '2025-03-21 09:36:13', 23);
INSERT INTO `museum_news` VALUES (1740803312367, '汽车馆', 'upload/zhanlanxinxi_changguantupian4.jpg', '200', '<p>2</p>', '上午9:00-下午18:00', '铸造馆东', '王先生', 13704204884, '优雅气质', '222', '2025-03-21 09:36:28', 9);

-- ----------------------------
-- Table structure for museum_roam
-- ----------------------------
DROP TABLE IF EXISTS `museum_roam`;
CREATE TABLE `museum_roam`  (
  `id` bigint NOT NULL,
  `clicktime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mrname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mrcover` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mrposition` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mrintroduction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mrvideo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mrcomment` int NULL DEFAULT NULL,
  `clicknum` int NULL DEFAULT 0,
  `mrcollect` int NULL DEFAULT NULL,
  `mnheader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`, `mnheader`) USING BTREE,
  UNIQUE INDEX `mrname`(`mrname` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of museum_roam
-- ----------------------------
INSERT INTO `museum_roam` VALUES (1740999536406, '2025-03-14 15:16:45', '全景漫游', 'upload/zhanlanxinxi_changguantupian1.jpg', '中国工业博物馆', '<p>5</p>', 'https://upvr.net/index.php/Product/Index/index/id/227019', 0, 16, 0, '张女士');
INSERT INTO `museum_roam` VALUES (1740999760671, '2025-03-03 19:02:40', '机床馆', '', '博物馆', '<p>666</p>', 'https://upvr.net/index.php/Product/Index/index/id/227019?start_type=image&start_scene=image717916&shijiao=true&ath=85.0012650909715&atv=-1.062&fov=88.1199', 0, 0, 0, '刘女士');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'abo', 'users', '管理员', 'qzwcf184jegic2b52ruao72l5aadvzwt', '2024-10-28 20:55:12', '2025-03-21 15:39:56');
INSERT INTO `token` VALUES (2, 21, '用户名1', 'yonghu', '用户', 'kn6m1duh93o4rkdq9t3rwadyu267syto', '2025-02-15 16:02:54', '2025-03-21 15:52:28');
INSERT INTO `token` VALUES (3, 11, '工作编号1', 'gongzuorenyuan', '工作人员', '05us6c7cfnqxp21xq29gqmoxaqrwryvq', '2025-03-14 15:50:04', '2025-03-20 22:30:36');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'abo', 'abo', '管理员', '2022-05-03 15:17:29');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `mima` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `xingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `shouji` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yonghuming`(`yonghuming` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (21, '2022-05-03 15:17:29', '用户名1', '123456', '姓名1', '男', 'upload/yonghu_touxiang1.jpg', '13823888881');
INSERT INTO `yonghu` VALUES (22, '2022-05-03 15:17:29', '用户名2', '123456', '姓名2', '男', 'upload/yonghu_touxiang2.jpg', '13823888882');
INSERT INTO `yonghu` VALUES (23, '2022-05-03 15:17:29', '用户名3', '123456', '姓名3', '男', 'upload/yonghu_touxiang3.jpg', '13823888883');
INSERT INTO `yonghu` VALUES (24, '2022-05-03 15:17:29', '用户名4', '123456', '姓名4', '男', 'upload/yonghu_touxiang4.jpg', '13823888884');
INSERT INTO `yonghu` VALUES (25, '2022-05-03 15:17:29', '用户名5', '123456', '姓名5', '男', 'upload/yonghu_touxiang5.jpg', '13823888885');
INSERT INTO `yonghu` VALUES (26, '2022-05-03 15:17:29', '用户名6', '123456', '姓名6', '男', 'upload/yonghu_touxiang6.jpg', '13823888886');

SET FOREIGN_KEY_CHECKS = 1;
