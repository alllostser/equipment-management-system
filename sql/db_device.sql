/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : db_device

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 08/03/2021 01:22:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_scd_apply
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_apply`;
CREATE TABLE `tb_scd_apply`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请编号',
  `apply_emp` bigint(20) NULL DEFAULT NULL COMMENT '申请人',
  `status` int(2) NULL DEFAULT NULL COMMENT '申请状态',
  `deal_emp` bigint(20) NULL DEFAULT NULL COMMENT '审核人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `deal_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  `deal_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理意见',
  `apply_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备申请表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_apply
-- ----------------------------
INSERT INTO `tb_scd_apply` VALUES (1, 'AP1010101', 4, 2, 4, '测试', '2015-12-23 21:54:44', '2021-03-06 23:00:59', '2015-12-23 21:54:47', '2015-12-23 21:54:48', 4, 4, 1, 'ss', '测试');
INSERT INTO `tb_scd_apply` VALUES (19, 'AP1367735', 4, 2, 4, NULL, '2021-03-05 15:13:30', '2021-03-06 23:01:17', '2021-03-05 15:13:30', NULL, NULL, NULL, 1, '同意', '打游戏');
INSERT INTO `tb_scd_apply` VALUES (21, 'AP1368215', 12, 4, 12, NULL, '2021-03-06 23:03:34', '2021-03-07 00:06:50', '2021-03-06 23:03:34', NULL, NULL, NULL, 1, NULL, '上课');
INSERT INTO `tb_scd_apply` VALUES (23, 'AP1368221', 12, 4, 12, NULL, '2021-03-06 23:25:30', '2021-03-07 00:13:38', '2021-03-06 23:25:30', NULL, NULL, NULL, 1, NULL, '没电了');
INSERT INTO `tb_scd_apply` VALUES (24, 'AP1368233', 12, 4, 12, NULL, '2021-03-07 00:12:24', '2021-03-07 00:13:52', '2021-03-07 00:12:24', NULL, NULL, NULL, 1, NULL, '算是');
INSERT INTO `tb_scd_apply` VALUES (25, 'AP1368234', 12, 4, 12, NULL, '2021-03-07 00:17:38', '2021-03-07 00:18:11', '2021-03-07 00:17:38', NULL, NULL, NULL, 1, '同意', '测试');
INSERT INTO `tb_scd_apply` VALUES (26, 'AP1368264', 12, 2, 4, NULL, '2021-03-07 02:16:09', '2021-03-07 20:04:29', '2021-03-07 02:16:09', NULL, NULL, NULL, 1, '同意', '借用1个');
INSERT INTO `tb_scd_apply` VALUES (27, 'AP1368531', 6, 4, 6, NULL, '2021-03-07 19:57:33', '2021-03-07 22:07:01', '2021-03-07 19:57:33', NULL, NULL, NULL, 1, '同意', '孙树');
INSERT INTO `tb_scd_apply` VALUES (28, 'AP1368532', 6, 4, 6, NULL, '2021-03-07 20:02:01', '2021-03-07 22:02:56', '2021-03-07 20:02:01', NULL, NULL, NULL, 1, '同意', '测试');
INSERT INTO `tb_scd_apply` VALUES (29, 'AP1368562', 13, 5, 13, NULL, '2021-03-07 22:00:56', '2021-03-07 22:01:31', '2021-03-07 22:00:56', NULL, NULL, NULL, 1, '不缺了', '机房缺机器');
INSERT INTO `tb_scd_apply` VALUES (30, 'AP1368562', 13, 2, 4, NULL, '2021-03-07 22:01:53', '2021-03-07 22:08:05', '2021-03-07 22:01:53', NULL, NULL, NULL, 1, '同意', '又缺了');

-- ----------------------------
-- Table structure for tb_scd_apply_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_apply_item`;
CREATE TABLE `tb_scd_apply_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请项编号',
  `dev_id` bigint(20) NULL DEFAULT NULL COMMENT '设备编号',
  `dev_num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  `apply_id` bigint(20) NULL DEFAULT NULL COMMENT '申请id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备申请项表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_apply_item
-- ----------------------------
INSERT INTO `tb_scd_apply_item` VALUES (1, 'IT10101101', 1, 10, '测试', '2015-12-24 00:59:37', '2015-12-24 00:59:40', 4, 4, 1, 1);
INSERT INTO `tb_scd_apply_item` VALUES (11, NULL, 3, 1, NULL, '2021-03-05 15:13:30', NULL, NULL, NULL, 1, 19);
INSERT INTO `tb_scd_apply_item` VALUES (13, NULL, 3, 2, NULL, '2021-03-06 23:03:34', NULL, NULL, NULL, 1, 21);
INSERT INTO `tb_scd_apply_item` VALUES (15, NULL, 1, 2, NULL, '2021-03-06 23:25:30', NULL, NULL, NULL, 1, 23);
INSERT INTO `tb_scd_apply_item` VALUES (16, NULL, 3, 1, NULL, '2021-03-07 00:12:24', NULL, NULL, NULL, 1, 24);
INSERT INTO `tb_scd_apply_item` VALUES (17, NULL, 3, 2, NULL, '2021-03-07 00:17:38', NULL, NULL, NULL, 1, 25);
INSERT INTO `tb_scd_apply_item` VALUES (18, NULL, 3, 1, NULL, '2021-03-07 02:16:09', NULL, NULL, NULL, 1, 26);
INSERT INTO `tb_scd_apply_item` VALUES (19, NULL, 2758, 8, NULL, '2021-03-07 19:57:33', NULL, NULL, NULL, 1, 27);
INSERT INTO `tb_scd_apply_item` VALUES (20, NULL, 2760, 3, NULL, '2021-03-07 20:02:01', NULL, NULL, NULL, 1, 28);
INSERT INTO `tb_scd_apply_item` VALUES (21, NULL, 2764, 10, NULL, '2021-03-07 22:00:56', NULL, NULL, NULL, 1, 29);
INSERT INTO `tb_scd_apply_item` VALUES (22, NULL, 2764, 10, NULL, '2021-03-07 22:01:53', NULL, NULL, NULL, 1, 30);

-- ----------------------------
-- Table structure for tb_scd_dev
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev`;
CREATE TABLE `tb_scd_dev`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dev_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `bar_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条形码',
  `dev_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `cate_id` int(11) NULL DEFAULT NULL COMMENT '类别id',
  `model_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
  `standard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '单价',
  `country_id` int(11) NULL DEFAULT NULL COMMENT '国家id',
  `firm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂商',
  `out_firm_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产日期',
  `purchase_time` datetime NULL DEFAULT NULL COMMENT '购置时间',
  `found_id` int(11) NULL DEFAULT NULL COMMENT '经费科目',
  `origin_id` int(11) NULL DEFAULT NULL COMMENT '设备来源',
  `deposit_id` int(11) NULL DEFAULT NULL COMMENT '存放地',
  `dev_sum` int(11) NULL DEFAULT NULL COMMENT '设备数量',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  `dev_power` int(2) NULL DEFAULT NULL COMMENT '设备权限',
  `direc_id` int(11) NULL DEFAULT NULL COMMENT '设备使用方向',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2765 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备基本信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev
-- ----------------------------
INSERT INTO `tb_scd_dev` VALUES (1, 'De101011', 'No1010101', '集成电池', 1, '南孚', '9V', 3, 1, '测试厂商', 'ceshi001', '2015-12-20 14:25:21', 1, 1, 1, 16, '测试', '2015-12-20 14:25:39', '2015-12-20 14:25:41', 4, 4, 1, NULL, 1);
INSERT INTO `tb_scd_dev` VALUES (3, 'NO123456', NULL, '大烧杯', 6, '500ml', '500ml×1', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_scd_dev` VALUES (2758, 'De101012', NULL, '惠普显示器', 13, 'a101', '500w', 1000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_scd_dev` VALUES (2759, 'No123452', NULL, '小烧杯', 6, '200ml', '200ml×1', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_scd_dev` VALUES (2760, 'De101013', NULL, '中烧杯', 6, '300ml', '300ml×1', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tb_scd_dev` VALUES (2764, 'De23401144', NULL, '惠普主机', 14, 'g102', '1000w', 2000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);

-- ----------------------------
-- Table structure for tb_scd_dev_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_category`;
CREATE TABLE `tb_scd_dev_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父id 0为顶级分类',
  `cate_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别号',
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备类别表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev_category
-- ----------------------------
INSERT INTO `tb_scd_dev_category` VALUES (1, 0, 'CG101010101', '办公设备', '2015-12-16 21:37:23', '2015-12-16 21:37:25', 4, 4, 1);
INSERT INTO `tb_scd_dev_category` VALUES (2, 0, 'CG10101010102', '实验室设备', '2015-12-16 21:37:47', '2015-12-16 21:37:49', 4, 4, 1);
INSERT INTO `tb_scd_dev_category` VALUES (3, 1, 'CG101010102', '桌子', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (4, 3, 'CG101010103', '办公桌', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (5, 2, 'CG101010104', '实验器皿', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (6, 5, 'CG101010105', '烧杯', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (7, 0, 'CG101010106', '家具', NULL, NULL, NULL, NULL, 0);
INSERT INTO `tb_scd_dev_category` VALUES (8, 7, 'CG101010107', '桌椅', NULL, NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (9, 0, 'CG1022135', '电子类', '2021-03-05 20:01:09', NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (10, 9, 'GC2220112', '电脑类', '2021-03-05 20:01:32', NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (13, 10, 'CG22221115', '显示器', '2021-03-05 20:08:19', NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (14, 10, 'CG123452', '主机', '2021-03-05 20:14:40', NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (15, 0, 'CG222222', '实验耗材', '2021-03-05 20:16:21', NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (16, 15, 'cg555555', '网线', '2021-03-05 20:22:28', NULL, NULL, NULL, 1);
INSERT INTO `tb_scd_dev_category` VALUES (23, 0, 'CG10223245', '测试类别', '2021-03-07 21:57:06', NULL, NULL, NULL, 0);
INSERT INTO `tb_scd_dev_category` VALUES (24, 23, 'Cg23313', '测试类别2', '2021-03-07 21:57:23', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for tb_scd_dev_country
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_country`;
CREATE TABLE `tb_scd_dev_country`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家编号',
  `country_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备国别表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev_country
-- ----------------------------
INSERT INTO `tb_scd_dev_country` VALUES (1, 'Co1010101', '中国', '2015-12-20 16:48:42', '2015-12-20 16:48:44', 4, 4, 1);
INSERT INTO `tb_scd_dev_country` VALUES (2, 'Co1010102', '日本', '2015-12-20 16:49:05', '2015-12-20 16:49:07', 4, 4, 1);

-- ----------------------------
-- Table structure for tb_scd_dev_deposit
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_deposit`;
CREATE TABLE `tb_scd_dev_deposit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_deposit_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备存放地编号',
  `dev_deposit_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备存放地名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备存放地表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev_deposit
-- ----------------------------
INSERT INTO `tb_scd_dev_deposit` VALUES (1, 'Do1010101', '一号实验室', '2015-12-20 16:49:37', '2015-12-20 16:49:39', 4, 4, 1);
INSERT INTO `tb_scd_dev_deposit` VALUES (2, 'Do1010101', '二号实验室', '2015-12-20 16:49:56', '2015-12-20 16:49:58', 4, 4, 1);

-- ----------------------------
-- Table structure for tb_scd_dev_found_sub
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_found_sub`;
CREATE TABLE `tb_scd_dev_found_sub`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `found_sub_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经费科目编号',
  `found_sub_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经费科目名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备经费科目表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev_found_sub
-- ----------------------------
INSERT INTO `tb_scd_dev_found_sub` VALUES (1, 'Fs101010101', '测试经费1', '2015-12-20 16:50:44', '2015-12-20 16:50:46', 4, 4, 1);
INSERT INTO `tb_scd_dev_found_sub` VALUES (2, 'Fs101010101', '测试经费2', '2015-12-20 16:51:05', '2015-12-20 16:51:07', 4, 4, 1);

-- ----------------------------
-- Table structure for tb_scd_dev_input
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_input`;
CREATE TABLE `tb_scd_dev_input`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `input_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库编号',
  `bar_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条形码',
  `dev_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `cate_id` int(11) NULL DEFAULT NULL COMMENT '类别id',
  `model_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
  `standard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '单价',
  `country_id` int(11) NULL DEFAULT NULL COMMENT '国家id',
  `firm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产厂家',
  `out_firm_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出厂日期',
  `purchase_time` datetime NULL DEFAULT NULL COMMENT '购买时间',
  `found_id` int(11) NULL DEFAULT NULL COMMENT '经费科目',
  `origin_id` int(11) NULL DEFAULT NULL COMMENT '设备来源',
  `deposit_id` int(11) NULL DEFAULT NULL COMMENT '存放地',
  `dev_num` int(11) NULL DEFAULT NULL COMMENT '设备数量',
  `deal_emp` bigint(20) NULL DEFAULT NULL COMMENT '经手人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备入库记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_scd_dev_origin
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_origin`;
CREATE TABLE `tb_scd_dev_origin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_origin_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备来源编号',
  `dev_origin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备来源名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备来源表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev_origin
-- ----------------------------
INSERT INTO `tb_scd_dev_origin` VALUES (1, 'ON1010101011', '校友捐赠', '2015-12-16 21:11:28', '2015-12-16 21:11:30', 4, 4, 1);
INSERT INTO `tb_scd_dev_origin` VALUES (2, 'ON1010101012', '学校购买', '2015-12-16 21:24:59', '2015-12-16 21:25:01', 4, 4, 1);

-- ----------------------------
-- Table structure for tb_scd_dev_status
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_status`;
CREATE TABLE `tb_scd_dev_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dev_status_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备现状编号',
  `dev_status_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备现状名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备现状表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_scd_dev_use_direc
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dev_use_direc`;
CREATE TABLE `tb_scd_dev_use_direc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `use_direc_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用方向编号',
  `use_direc_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用方向名称',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备使用方向表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dev_use_direc
-- ----------------------------
INSERT INTO `tb_scd_dev_use_direc` VALUES (1, 'Di101010101', '测试使用方向1', '2015-12-20 16:51:48', '2015-12-20 16:51:50', 4, 4, 1);
INSERT INTO `tb_scd_dev_use_direc` VALUES (2, 'Di101010101', '测试使用方向2', '2015-12-20 16:52:06', '2015-12-20 16:52:08', 4, 4, 1);

-- ----------------------------
-- Table structure for tb_scd_dump
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_dump`;
CREATE TABLE `tb_scd_dump`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dev_id` bigint(20) NULL DEFAULT NULL COMMENT '设备id',
  `dump_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废编号',
  `dump_num` int(11) NULL DEFAULT NULL COMMENT '报废数量',
  `dump_reason` int(2) NULL DEFAULT NULL COMMENT '报废原因',
  `dump_time` datetime NULL DEFAULT NULL COMMENT '报废时间',
  `dump_emp` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废负责人',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备报废记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_dump
-- ----------------------------
INSERT INTO `tb_scd_dump` VALUES (1, 1, 'DU1010101', 10, 1, '2015-12-24 00:35:26', '测试', '2015-12-24 00:35:30', '2015-12-24 00:35:32', 4, 4, 1, '测试');
INSERT INTO `tb_scd_dump` VALUES (2, 1, 'DU1010102', 5, 2, '2015-12-24 00:36:02', '测试', '2015-12-24 00:36:06', '2015-12-24 00:36:08', 4, 4, 1, '测试');

-- ----------------------------
-- Table structure for tb_scd_maintain
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_maintain`;
CREATE TABLE `tb_scd_maintain`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `maintain_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修记录编号',
  `dev_id` bigint(20) NULL DEFAULT NULL COMMENT '设备Id',
  `maintain_num` int(11) NULL DEFAULT NULL COMMENT '设备数量',
  `maintain_emp` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修负责人',
  `status` int(11) NULL DEFAULT NULL COMMENT '维修状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备维修记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_maintain
-- ----------------------------
INSERT INTO `tb_scd_maintain` VALUES (1, 'MT1010101', 1, 10, '测试', 1, '册数', '2015-12-23 23:51:08', '2015-12-23 23:51:09', 4, 4, 1);

-- ----------------------------
-- Table structure for tb_scd_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_menu`;
CREATE TABLE `tb_scd_menu`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `type` int(11) NULL DEFAULT NULL COMMENT '菜单地址',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级菜单id',
  `open_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  `role_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_menu
-- ----------------------------
INSERT INTO `tb_scd_menu` VALUES ('1', '工作空间', 0, 'layui-icon layui-icon-home', NULL, NULL, 0, 1, '1,2,3');
INSERT INTO `tb_scd_menu` VALUES ('10', '数据分析', 1, 'layui-icon layui-icon-console', '_iframe', 'view/console/console2.html', 1, 1, '1,2,3');
INSERT INTO `tb_scd_menu` VALUES ('100', '设备管理', 0, 'layui-icon layui-icon-console', NULL, NULL, 0, 1, '1,2');
INSERT INTO `tb_scd_menu` VALUES ('101', '设备列表', 1, 'layui-icon layui-icon-console', '_iframe', 'view/equipment/equipment.html', 100, 1, '1,2');
INSERT INTO `tb_scd_menu` VALUES ('102', '设备申请列表', 1, 'layui-icon layui-icon-console', '_iframe', 'view/equipment/equipment-Application.html', 100, 1, '1,2');
INSERT INTO `tb_scd_menu` VALUES ('103', '设备添加或导入', 1, 'layui-icon layui-icon-console', '_iframe', 'view/equipment/add.html', 100, 1, '1');
INSERT INTO `tb_scd_menu` VALUES ('200', '设备申请', 0, 'layui-icon layui-icon-console', NULL, NULL, 0, 1, '2,3');
INSERT INTO `tb_scd_menu` VALUES ('201', '设备列表', 1, 'layui-icon layui-icon-console', '_iframe', 'view/equipment-student/equipment-list-student.html', 200, 1, '2,3');
INSERT INTO `tb_scd_menu` VALUES ('202', '我的申请', 1, 'layui-icon layui-icon-console', '_iframe', 'view/equipment-student/equipment-Application.html', 200, 1, '2,3');
INSERT INTO `tb_scd_menu` VALUES ('300', '类别管理', 0, 'layui-icon layui-icon-component', NULL, NULL, 0, 1, '1');
INSERT INTO `tb_scd_menu` VALUES ('301', '类别列表', 1, 'layui-icon layui-icon-console', '_iframe', 'view/category/category-list.html', 300, 1, '1');
INSERT INTO `tb_scd_menu` VALUES ('600', '系统管理', 0, 'layui-icon layui-icon-set-fill', NULL, NULL, 0, 1, '1');
INSERT INTO `tb_scd_menu` VALUES ('601', '用户管理', 1, 'layui-icon layui-icon-face-smile', '_iframe', 'view/system/user.html', 600, 1, '1');
INSERT INTO `tb_scd_menu` VALUES ('602', '角色管理', 1, 'layui-icon layui-icon-face-cry', '_iframe', 'view/system/role.html', 600, 1, '1');

-- ----------------------------
-- Table structure for tb_scd_power
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_power`;
CREATE TABLE `tb_scd_power`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `power_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `power_context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限内容',
  `create_time` datetime NULL DEFAULT NULL,
  `modify_time` datetime NULL DEFAULT NULL,
  `create_emp` bigint(20) NULL DEFAULT NULL,
  `modify_emp` bigint(20) NULL DEFAULT NULL,
  `is_valid` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_scd_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_role`;
CREATE TABLE `tb_scd_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `status` int(10) NOT NULL DEFAULT 1 COMMENT '状态',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_role
-- ----------------------------
INSERT INTO `tb_scd_role` VALUES (1, '超级管理员', 'ROLE_ADMIN', 1, '超级管理员');
INSERT INTO `tb_scd_role` VALUES (2, '教师', 'ROLE_TEACHER', 1, '教师');
INSERT INTO `tb_scd_role` VALUES (3, '学生', 'ROLE_STUDENT', 1, '学生');

-- ----------------------------
-- Table structure for tb_scd_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_scd_user`;
CREATE TABLE `tb_scd_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `user_sex` int(2) NULL DEFAULT NULL COMMENT '性别',
  `user_role` int(2) NULL DEFAULT NULL COMMENT '角色',
  `user_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `user_menu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单列表',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_emp` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `modify_emp` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `is_valid` int(2) NULL DEFAULT 1 COMMENT '是否有效 1：有效 0：无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_scd_user
-- ----------------------------
INSERT INTO `tb_scd_user` VALUES (4, 'admin', '$2a$10$ysZUOe.iwbmb0SGegKBsROu18d135YOfRCJzybiEmFqoTTKMpXB4K', '杨利鹏', 1, 1, '18235140527', '1,2,3,4,5', '2021-03-04 10:35:32', '2015-12-25 21:39:36', NULL, 4, 1, NULL);
INSERT INTO `tb_scd_user` VALUES (6, 'lisi', '$2a$10$879/GRBGJsldEuIx10lnnuMiNmL9AbU7.Y.icze3c3UztW6e0Vl/S', '李四', 2, 2, '15081336458', NULL, '2021-03-04 10:35:34', NULL, NULL, NULL, 1, NULL);
INSERT INTO `tb_scd_user` VALUES (12, 'student1', '$2a$10$ysZUOe.iwbmb0SGegKBsROu18d135YOfRCJzybiEmFqoTTKMpXB4K', '李秋水', 2, 3, '15532334561', NULL, '2021-03-06 18:18:56', NULL, NULL, NULL, 1, NULL);
INSERT INTO `tb_scd_user` VALUES (13, 'student2', '$2a$10$ZERiHp9eAc8XPzyavIyVGe.iWvfP/QDf5VIxtCo0/qNgwAhK4KjXa', '无崖子', 1, 3, '15022313124', NULL, '2021-03-07 21:55:35', NULL, NULL, NULL, 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
