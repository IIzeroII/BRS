/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50018
Source Host           : 127.0.0.1:3306
Source Database       : brs

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2017-01-12 09:18:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `adminId` varchar(36) NOT NULL,
  `password` varchar(36) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY  (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('20144206132', 'zx.5612', '1');
INSERT INTO `admins` VALUES ('20144206133', 'zx.5612', '1');
INSERT INTO `admins` VALUES ('20144206134', 'zx.5612', '1');
INSERT INTO `admins` VALUES ('20144206135', 'zx.5612', '1');
INSERT INTO `admins` VALUES ('20144206143', 'zx.5612', '1');
INSERT INTO `admins` VALUES ('20144206155', 'zx.5612', '1');
INSERT INTO `admins` VALUES ('20144206166', 'zx.5612', '1');

-- ----------------------------
-- Table structure for bicycle
-- ----------------------------
DROP TABLE IF EXISTS `bicycle`;
CREATE TABLE `bicycle` (
  `bicId` varchar(36) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` int(36) NOT NULL,
  `imgId` varchar(36) default NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY  (`bicId`),
  KEY `foreign1` (`imgId`),
  CONSTRAINT `foreign1` FOREIGN KEY (`imgId`) REFERENCES `imgs` (`imgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bicycle
-- ----------------------------
INSERT INTO `bicycle` VALUES ('186428ba-1f78-4c1e-830d-2771b21ca993', '攀爬车', '14', '186428ba-1f78-4c1e-830d-2771b21ca993', '1');
INSERT INTO `bicycle` VALUES ('1bed33cd-fc00-40ff-a88e-bda9dfe587bf', '土坡车', '9', '1bed33cd-fc00-40ff-a88e-bda9dfe587bf', '1');
INSERT INTO `bicycle` VALUES ('2a317135-6732-4366-9cab-24fb99d794a3', '折叠自行车', '5', '2a317135-6732-4366-9cab-24fb99d794a3', '1');
INSERT INTO `bicycle` VALUES ('52304057-f57c-4c17-bdf2-49f2b51e9774', '山地车', '11', '52304057-f57c-4c17-bdf2-49f2b51e9774', '1');
INSERT INTO `bicycle` VALUES ('54a61ed6-6abe-4eb8-9cb2-1bbb770cd944', '电动助力车', '10', '54a61ed6-6abe-4eb8-9cb2-1bbb770cd944', '-1');
INSERT INTO `bicycle` VALUES ('5bacd6d3-fc3d-4a04-a705-3c0a56857c5f', '山马车', '9', '5bacd6d3-fc3d-4a04-a705-3c0a56857c5f', '-1');
INSERT INTO `bicycle` VALUES ('7c0adf73-9e65-4836-bfd4-fc5ea3df8796', '城市休闲车', '8', '7c0adf73-9e65-4836-bfd4-fc5ea3df8796', '1');
INSERT INTO `bicycle` VALUES ('8b8ac763-4608-43e0-8e92-3bd21e08ea59', '旅行车', '15', '8b8ac763-4608-43e0-8e92-3bd21e08ea59', '1');
INSERT INTO `bicycle` VALUES ('d62782f0-c23c-45d8-adb9-d84a97363a53', '公路车', '10', 'd62782f0-c23c-45d8-adb9-d84a97363a53', '1');
INSERT INTO `bicycle` VALUES ('f70ad409-bc21-4922-9434-e1bd26831ee1', '8号公路', '8', 'f70ad409-bc21-4922-9434-e1bd26831ee1', '1');
INSERT INTO `bicycle` VALUES ('fc5c9dd5-b295-43f6-8a82-7ba3e900e948', '固齿车', '12', 'fc5c9dd5-b295-43f6-8a82-7ba3e900e948', '1');

-- ----------------------------
-- Table structure for imgs
-- ----------------------------
DROP TABLE IF EXISTS `imgs`;
CREATE TABLE `imgs` (
  `imgId` varchar(36) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY  (`imgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imgs
-- ----------------------------
INSERT INTO `imgs` VALUES ('186428ba-1f78-4c1e-830d-2771b21ca993', '186428ba-1f78-4c1e-830d-2771b21ca993.png');
INSERT INTO `imgs` VALUES ('1bed33cd-fc00-40ff-a88e-bda9dfe587bf', '1bed33cd-fc00-40ff-a88e-bda9dfe587bf.png');
INSERT INTO `imgs` VALUES ('2a317135-6732-4366-9cab-24fb99d794a3', '2a317135-6732-4366-9cab-24fb99d794a3.png');
INSERT INTO `imgs` VALUES ('2c5ac1b4-16a7-4905-85bd-43d299d05196', '2c5ac1b4-16a7-4905-85bd-43d299d05196.png');
INSERT INTO `imgs` VALUES ('2ce2b5ac-3446-4f74-8787-f33d0235baa7', '2ce2b5ac-3446-4f74-8787-f33d0235baa7.png');
INSERT INTO `imgs` VALUES ('3165f390-e4b3-42a9-b9e4-25337c40be9f', '3165f390-e4b3-42a9-b9e4-25337c40be9f.png');
INSERT INTO `imgs` VALUES ('35ff609a-1efc-4844-ac70-35d1cce14cb5', '35ff609a-1efc-4844-ac70-35d1cce14cb5.png');
INSERT INTO `imgs` VALUES ('48bb39bd-048c-417c-9213-f6f8a17b5236', '48bb39bd-048c-417c-9213-f6f8a17b5236.png');
INSERT INTO `imgs` VALUES ('52304057-f57c-4c17-bdf2-49f2b51e9774', '52304057-f57c-4c17-bdf2-49f2b51e9774.png');
INSERT INTO `imgs` VALUES ('54a61ed6-6abe-4eb8-9cb2-1bbb770cd944', '54a61ed6-6abe-4eb8-9cb2-1bbb770cd944.png');
INSERT INTO `imgs` VALUES ('5bacd6d3-fc3d-4a04-a705-3c0a56857c5f', '5bacd6d3-fc3d-4a04-a705-3c0a56857c5f.png');
INSERT INTO `imgs` VALUES ('6560230f-9b5a-455b-a386-f62c9514afb7', '6560230f-9b5a-455b-a386-f62c9514afb7.png');
INSERT INTO `imgs` VALUES ('727db71f-a218-4af0-afe9-f057c654838c', '727db71f-a218-4af0-afe9-f057c654838c.png');
INSERT INTO `imgs` VALUES ('73407eec-b547-4373-bd05-8b469f394f7d', '73407eec-b547-4373-bd05-8b469f394f7d.png');
INSERT INTO `imgs` VALUES ('7bfb5a78-224b-452a-a91c-197311faa18e', '7bfb5a78-224b-452a-a91c-197311faa18e.png');
INSERT INTO `imgs` VALUES ('7c0adf73-9e65-4836-bfd4-fc5ea3df8796', '7c0adf73-9e65-4836-bfd4-fc5ea3df8796.png');
INSERT INTO `imgs` VALUES ('8b8ac763-4608-43e0-8e92-3bd21e08ea59', '8b8ac763-4608-43e0-8e92-3bd21e08ea59.png');
INSERT INTO `imgs` VALUES ('92f48f70-4d25-4244-94c1-7ef6f4c508db', '92f48f70-4d25-4244-94c1-7ef6f4c508db.png');
INSERT INTO `imgs` VALUES ('9b4b2177-2451-4601-a314-ed249942382e', '9b4b2177-2451-4601-a314-ed249942382e.png');
INSERT INTO `imgs` VALUES ('a28f47c5-9c91-456b-b5d0-da555451b16e', 'a28f47c5-9c91-456b-b5d0-da555451b16e.png');
INSERT INTO `imgs` VALUES ('bc537fe4-cff5-490f-bf55-558bd8a0d738', 'bc537fe4-cff5-490f-bf55-558bd8a0d738.png');
INSERT INTO `imgs` VALUES ('d62782f0-c23c-45d8-adb9-d84a97363a53', 'd62782f0-c23c-45d8-adb9-d84a97363a53.png');
INSERT INTO `imgs` VALUES ('d6e7b101-aa8d-4f81-80b2-222635b9ef3b', 'd6e7b101-aa8d-4f81-80b2-222635b9ef3b.png');
INSERT INTO `imgs` VALUES ('dab2bc7d-fe9b-4859-9a8c-96ed31de0f83', 'dab2bc7d-fe9b-4859-9a8c-96ed31de0f83.png');
INSERT INTO `imgs` VALUES ('f70ad409-bc21-4922-9434-e1bd26831ee1', 'f70ad409-bc21-4922-9434-e1bd26831ee1.png');
INSERT INTO `imgs` VALUES ('fc5c9dd5-b295-43f6-8a82-7ba3e900e948', 'fc5c9dd5-b295-43f6-8a82-7ba3e900e948.png');

-- ----------------------------
-- Table structure for rental
-- ----------------------------
DROP TABLE IF EXISTS `rental`;
CREATE TABLE `rental` (
  `id` varchar(36) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `bicId` varchar(36) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `number` int(36) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `foreign3` (`userId`),
  KEY `foreign4` (`bicId`),
  CONSTRAINT `foreign3` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
  CONSTRAINT `foreign4` FOREIGN KEY (`bicId`) REFERENCES `bicycle` (`bicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rental
-- ----------------------------
INSERT INTO `rental` VALUES ('001', '1073343143', '186428ba-1f78-4c1e-830d-2771b21ca993', '2017-01-10 07:36:28', '2017-01-11 07:36:28', '2', '1');
INSERT INTO `rental` VALUES ('002', '1213840358', '1bed33cd-fc00-40ff-a88e-bda9dfe587bf', '2017-01-10 07:27:00', '2017-01-10 20:34:35', '5', '1');
INSERT INTO `rental` VALUES ('003', '1427514836', '2a317135-6732-4366-9cab-24fb99d794a3', '2017-01-11 03:36:43', '2017-01-13 10:23:24', '1', '1');
INSERT INTO `rental` VALUES ('004', '1472958166', '52304057-f57c-4c17-bdf2-49f2b51e9774', '2017-01-25 04:42:25', '2017-01-26 01:42:25', '4', '1');
INSERT INTO `rental` VALUES ('005', '3143681290', '8b8ac763-4608-43e0-8e92-3bd21e08ea59', '2017-01-20 07:44:44', '2017-01-21 07:12:24', '1', '1');
INSERT INTO `rental` VALUES ('006', '3143694348', '52304057-f57c-4c17-bdf2-49f2b51e9774', '2017-01-20 00:00:00', '2017-01-23 11:23:24', '3', '1');
INSERT INTO `rental` VALUES ('007', '1213840358', '7c0adf73-9e65-4836-bfd4-fc5ea3df8796', '2017-02-06 06:33:34', '2017-02-10 00:26:41', '10', '1');
INSERT INTO `rental` VALUES ('008', '3143689767', 'fc5c9dd5-b295-43f6-8a82-7ba3e900e948', '2017-04-20 13:31:33', '2017-05-01 11:23:34', '1', '1');
INSERT INTO `rental` VALUES ('009', '3143693660', 'd62782f0-c23c-45d8-adb9-d84a97363a53', '2017-01-19 09:53:44', '2017-01-27 01:33:44', '2', '1');
INSERT INTO `rental` VALUES ('010', '1472958166', '8b8ac763-4608-43e0-8e92-3bd21e08ea59', '2017-01-30 13:30:35', '2017-02-03 11:33:34', '3', '1');
INSERT INTO `rental` VALUES ('011', '3143682006', '52304057-f57c-4c17-bdf2-49f2b51e9774', '2017-01-18 12:34:44', '2017-01-24 12:34:44', '5', '1');
INSERT INTO `rental` VALUES ('012', '1847542284', '1bed33cd-fc00-40ff-a88e-bda9dfe587bf', '2017-01-20 06:14:34', '2017-02-15 06:14:34', '5', '1');
INSERT INTO `rental` VALUES ('013', '16864646226', '2a317135-6732-4366-9cab-24fb99d794a3', '2017-01-20 13:44:20', '2017-02-11 08:44:20', '2', '1');
INSERT INTO `rental` VALUES ('014', '18461644445', 'd62782f0-c23c-45d8-adb9-d84a97363a53', '2017-05-16 17:32:33', '2017-05-30 07:31:33', '3', '1');
INSERT INTO `rental` VALUES ('015', '18624532284', '186428ba-1f78-4c1e-830d-2771b21ca993', '2017-01-19 16:42:33', '2017-01-31 12:42:43', '9', '1');
INSERT INTO `rental` VALUES ('016', '18874488785', '8b8ac763-4608-43e0-8e92-3bd21e08ea59', '2017-06-12 17:34:26', '2017-06-22 17:42:33', '88', '1');
INSERT INTO `rental` VALUES ('017', '18973702284', 'f70ad409-bc21-4922-9434-e1bd26831ee1', '2017-04-10 13:44:34', '2017-04-19 13:44:34', '66', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` varchar(36) NOT NULL,
  `name` varchar(255) default NULL,
  `password` varchar(36) NOT NULL,
  `sex` varchar(36) default NULL,
  `imgId` varchar(36) default NULL,
  `tel` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY  (`userId`),
  KEY `foreign2` (`imgId`),
  CONSTRAINT `foreign2` FOREIGN KEY (`imgId`) REFERENCES `imgs` (`imgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1073343143', '陈乔恩', 'ibf834687', '女', '727db71f-a218-4af0-afe9-f057c654838c', '13901637671', '1073343143@qq.com', '-1');
INSERT INTO `users` VALUES ('1213840358', '刘亦菲', 'asgfg5486', '女', '35ff609a-1efc-4844-ac70-35d1cce14cb5', '18973702284', '1213840358@qq.com', '1');
INSERT INTO `users` VALUES ('1427514836', '李冰冰', 'kkkk11055', '女', '7bfb5a78-224b-452a-a91c-197311faa18e', '13612671267', '1427514836@qq.com', '-1');
INSERT INTO `users` VALUES ('1472958166', '刘诗诗', 'adfs56456', '女', '6560230f-9b5a-455b-a386-f62c9514afb7', '18233113377', '1472958166@qq.com', '1');
INSERT INTO `users` VALUES ('16864646226', '苏轼', 'sdfaf56a41', '男', '9b4b2177-2451-4601-a314-ed249942382e', '16864646226', '16864646226@qq.com', '1');
INSERT INTO `users` VALUES ('18461644445', '刘禹锡', 'sfgag54841', '男', '48bb39bd-048c-417c-9213-f6f8a17b5236', '18461644445', '18461644445@qq.com', '1');
INSERT INTO `users` VALUES ('1847542284', '陶渊明', 'asgsd1823', '男', '73407eec-b547-4373-bd05-8b469f394f7d', '1847542284', '1847542284@qq.com', '1');
INSERT INTO `users` VALUES ('18624532284', '白居易', 'sfagaa5461', '男', 'a28f47c5-9c91-456b-b5d0-da555451b16e', '18624532284', '18624532284@qq.com', '1');
INSERT INTO `users` VALUES ('18874488785', '杜甫', 'zx.5612', '男', 'd6e7b101-aa8d-4f81-80b2-222635b9ef3b', '18874488785', '18874488785@qq.com', '1');
INSERT INTO `users` VALUES ('18973702284', '李白', 'sfsd216541', '男', '2c5ac1b4-16a7-4905-85bd-43d299d05196', '18973702284', '18973702284@qq.com', '1');
INSERT INTO `users` VALUES ('3143681290', '唐嫣', 'mnk82s769', '女', '2ce2b5ac-3446-4f74-8787-f33d0235baa7', '18236888873', '3143681290@qq.com', '-1');
INSERT INTO `users` VALUES ('3143682006', '莫文蔚', 'a17121155', '女', '3165f390-e4b3-42a9-b9e4-25337c40be9f', '13576300000', '3143682006@qq.com', '1');
INSERT INTO `users` VALUES ('3143689767', '杨幂', 'sixie6587', '女', 'bc537fe4-cff5-490f-bf55-558bd8a0d738', '13121332345', '3143689767@qq.com', '-1');
INSERT INTO `users` VALUES ('3143693660', '王研之', 'hangba472', '女', 'dab2bc7d-fe9b-4859-9a8c-96ed31de0f83', '15239583737', '3143693660@qq.com', '1');
INSERT INTO `users` VALUES ('3143694348', '陈妍希', 'ggkdud024', '女', '92f48f70-4d25-4244-94c1-7ef6f4c508db', '13011133456', '3143694348@qq.com', '-1');
