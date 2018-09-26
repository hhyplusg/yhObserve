/*
Navicat MySQL Data Transfer

Source Server         : localhsot
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : waveplus

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-05-22 10:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for eqinquiry
-- ----------------------------
DROP TABLE IF EXISTS `eqinquiry`;
CREATE TABLE `eqinquiry` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `corpId` int(11) DEFAULT NULL COMMENT '询价机构Id',
  `inquiryContent` varchar(2048) DEFAULT NULL COMMENT '询价内容',
  `inquiryDate` datetime DEFAULT NULL COMMENT '询价日期',
  `attribute1` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eqinquiry
-- ----------------------------

-- ----------------------------
-- Table structure for eqinquirytarget
-- ----------------------------
DROP TABLE IF EXISTS `eqinquirytarget`;
CREATE TABLE `eqinquirytarget` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `inquiryId` int(11) DEFAULT NULL COMMENT '询价ID',
  `corpId` int(11) DEFAULT NULL COMMENT '银行Id',
  `attribute1` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eqinquirytarget
-- ----------------------------

-- ----------------------------
-- Table structure for equote
-- ----------------------------
DROP TABLE IF EXISTS `equote`;
CREATE TABLE `equote` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `inquiryId` int(11) DEFAULT NULL COMMENT '询价ID',
  `corpId` int(11) DEFAULT NULL COMMENT '银行Id',
  `quoteDate` datetime DEFAULT NULL COMMENT '报价日期',
  `rateSevenday` decimal(10,0) DEFAULT NULL COMMENT '7D',
  `rateFourteenday` decimal(10,0) DEFAULT NULL COMMENT '14D',
  `rateOneMonth` decimal(10,0) DEFAULT NULL COMMENT '1M',
  `rateTwoMonth` decimal(10,0) DEFAULT NULL COMMENT '2M',
  `rateThreeMonth` decimal(10,0) DEFAULT NULL COMMENT '3M',
  `rateSixMonth` decimal(10,0) DEFAULT NULL COMMENT '6M',
  `oneYear` decimal(10,0) DEFAULT NULL COMMENT '1Y',
  `quoteType` varchar(128) DEFAULT NULL COMMENT '报价类型公开/对私/对询价 public/private/toInquiry',
  `attribute1` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equote
-- ----------------------------

-- ----------------------------
-- Table structure for equotetarget
-- ----------------------------
DROP TABLE IF EXISTS `equotetarget`;
CREATE TABLE `equotetarget` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `quoteId` int(11) DEFAULT NULL COMMENT '报价ID',
  `corpId` int(11) DEFAULT NULL COMMENT '机构Id：机构类型为corp的机构',
  `attribute1` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equotetarget
-- ----------------------------

-- ----------------------------
-- Table structure for syscorpcontact
-- ----------------------------
DROP TABLE IF EXISTS `syscorpcontact`;
CREATE TABLE `syscorpcontact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `corpId` int(11) DEFAULT NULL COMMENT '机构id',
  `contactName` varchar(128) DEFAULT NULL COMMENT '联系人姓名',
  `contactPhone` varchar(128) DEFAULT NULL COMMENT '联系人电话',
  `contactMailAddress` varchar(128) DEFAULT NULL COMMENT '邮箱地址',
  `identityCardNo` varchar(128) DEFAULT NULL COMMENT '联系人身份证号',
  `status` varchar(128) DEFAULT NULL COMMENT '状态',
  `attribute1` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syscorpcontact
-- ----------------------------

-- ----------------------------
-- Table structure for syscorpfiles
-- ----------------------------
DROP TABLE IF EXISTS `syscorpfiles`;
CREATE TABLE `syscorpfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `corpId` int(11) DEFAULT NULL COMMENT '机构id',
  `fileName` varchar(128) DEFAULT NULL COMMENT '文件名字',
  `fileStorageUrl` varchar(128) DEFAULT NULL COMMENT '存储路径',
  `attribute1` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syscorpfiles
-- ----------------------------

-- ----------------------------
-- Table structure for syscorpinfor
-- ----------------------------
DROP TABLE IF EXISTS `syscorpinfor`;
CREATE TABLE `syscorpinfor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `corpCode` varchar(128) DEFAULT NULL COMMENT '机构编码',
  `corpName` varchar(128) DEFAULT NULL COMMENT '机构全称',
  `corpShortName` varchar(128) DEFAULT NULL COMMENT '机构简称',
  `corpType` varchar(128) DEFAULT NULL COMMENT '机构类型',
  `password` varchar(128) DEFAULT '1' COMMENT '密码',
  `status` varchar(128) DEFAULT NULL COMMENT '审核标志',
  `userLoginName` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute2` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `attribute3` varchar(128) DEFAULT NULL COMMENT '扩展属性',
  `createdBy` varchar(128) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `lastUpdateBy` varchar(128) DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syscorpinfor
-- ----------------------------
INSERT INTO `syscorpinfor` VALUES ('4', '000001', '管理员', '管理员', '3', '9b4b5ac88c4aacc0df2dae07ebb0794e', null, 'Admin', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for version_update_explain
-- ----------------------------
DROP TABLE IF EXISTS `version_update_explain`;
CREATE TABLE `version_update_explain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一编码',
  `version_no` varchar(20) NOT NULL,
  `update_content` varchar(1024) NOT NULL,
  `publish_datetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '版本发布时间',
  `publish_person` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of version_update_explain
-- ----------------------------

-- ----------------------------
-- View structure for v_eqinquiry
-- ----------------------------
DROP VIEW IF EXISTS `v_eqinquiry`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_eqinquiry` AS SELECT
	corp.corpCode,
	corp.corpName,
	corp.corpShortName,
	corp.corpType,
	inq.*
FROM
	eqinquiry inq 
	join syscorpinfor corp on inq.corpId = corp.id ;

-- ----------------------------
-- View structure for v_eqinquiry_target
-- ----------------------------
DROP VIEW IF EXISTS `v_eqinquiry_target`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_eqinquiry_target` AS SELECT
	corp.corpCode,
	corp.corpName,
	corp.corpShortName,
	corp.corpType,
  corptar.id corpIdTar,
	corptar.corpCode corpCodeTar,
	corptar.corpName corpNameTar,
	corptar.corpShortName corpShortNameTar,
	corptar.corpType corpTypeTar,
  inqtar.inquiryId,
	inq.*
FROM
	eqinquiry inq 
	join syscorpinfor corp on inq.corpId = corp.id 
  join eqinquirytarget inqtar on inq.id = inqtar.inquiryId
  join syscorpinfor corptar on inqtar.corpId = corptar.id ;

-- ----------------------------
-- View structure for v_equote
-- ----------------------------
DROP VIEW IF EXISTS `v_equote`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`::1` SQL SECURITY DEFINER  VIEW `v_equote` AS SELECT
  corp.corpCode as bjcorpCode,
  eq.corpId as bjcorpId,
  corp.corpName as bjcorpName,
  corp.corpShortName as bjcorpShortName,
  corp.corpType as bjcorpType,
  equtag.corpId as xjcorpid,
  equtag.id as quoteId,
  corpt.corpName as xjcorpName,
  eq.rateSevenday,
  eq.rateFourteenday,
  eq.rateOneMonth,
  eq.rateTwoMonth,
  eq.rateThreeMonth,
  eq.rateSixMonth,
  eq.oneYear,
  eq.inquiryId,
  eq.quoteDate,
  eq.quoteType
FROM
  equote eq 
    join syscorpinfor corp on eq.corpId = corp.id 
	join equotetarget equtag on equtag.quoteId = eq.id
	join syscorpinfor corpt on corpt.id = equtag.corpId ;

-- 增加id字段
DROP VIEW IF EXISTS `v_equote`;
CREATE  VIEW `v_equote` AS SELECT
   eq.id id,
	`corp`.`corpCode` AS `bjcorpCode`,
	`eq`.`corpId` AS `bjcorpId`,
	`corp`.`corpName` AS `bjcorpName`,
	`corp`.`corpShortName` AS `bjcorpShortName`,
	`corp`.`corpType` AS `bjcorpType`,
	`equtag`.`corpId` AS `xjcorpid`,
	`equtag`.`id` AS `quoteId`,
	`corpt`.`corpName` AS `xjcorpName`,
	`eq`.`rateSevenday` AS `rateSevenday`,
	`eq`.`rateFourteenday` AS `rateFourteenday`,
	`eq`.`rateOneMonth` AS `rateOneMonth`,
	`eq`.`rateTwoMonth` AS `rateTwoMonth`,
	`eq`.`rateThreeMonth` AS `rateThreeMonth`,
	`eq`.`rateSixMonth` AS `rateSixMonth`,
	`eq`.`oneYear` AS `oneYear`,
	`eq`.`inquiryId` AS `inquiryId`,
	`eq`.`quoteDate` AS `quoteDate`,
	`eq`.`quoteType` AS `quoteType`
FROM
	(
		(
			(
				`equote` `eq`
				JOIN `syscorpinfor` `corp` ON (
					(`eq`.`corpId` = `corp`.`id`)
				)
			)
			JOIN `equotetarget` `equtag` ON (
				(
					`equtag`.`quoteId` = `eq`.`id`
				)
			)
		)
		JOIN `syscorpinfor` `corpt` ON (
			(
				`corpt`.`id` = `equtag`.`corpId`
			)
		)
	);
