/*
Navicat MySQL Data Transfer

Source Server         : datamining
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : stacarinf

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-12-29 15:02:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for boorecarbase
-- ----------------------------
DROP TABLE IF EXISTS `boorecarbase`;
CREATE TABLE `boorecarbase` (
  `Skey` int(11) NOT NULL,
  `Snumber` char(20) NOT NULL,
  `Sname` char(20) NOT NULL,
  `Splnumber` char(20) NOT NULL,
  `Sbocarday` char(20) DEFAULT NULL,
  `Srecarday` char(20) DEFAULT NULL,
  PRIMARY KEY (`Skey`),
  KEY `Snumber` (`Snumber`),
  KEY `Splnumber` (`Splnumber`),
  CONSTRAINT `boorecarbase_ibfk_1` FOREIGN KEY (`Snumber`) REFERENCES `stainfbase` (`Snumber`),
  CONSTRAINT `boorecarbase_ibfk_2` FOREIGN KEY (`Splnumber`) REFERENCES `carinfbase` (`Splnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boorecarbase
-- ----------------------------

-- ----------------------------
-- Table structure for carinfbase
-- ----------------------------
DROP TABLE IF EXISTS `carinfbase`;
CREATE TABLE `carinfbase` (
  `Splnumber` char(20) NOT NULL,
  `Stype` char(20) NOT NULL,
  `Sbebo` char(20) NOT NULL,
  PRIMARY KEY (`Splnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carinfbase
-- ----------------------------
INSERT INTO `carinfbase` VALUES ('123456', '奔驰', '无');
INSERT INTO `carinfbase` VALUES ('123457', '宝马', '无');
INSERT INTO `carinfbase` VALUES ('123458', '奥迪', '无');

-- ----------------------------
-- Table structure for stainfbase
-- ----------------------------
DROP TABLE IF EXISTS `stainfbase`;
CREATE TABLE `stainfbase` (
  `Snumber` char(20) NOT NULL,
  `Sname` char(20) NOT NULL,
  `Ssex` char(20) NOT NULL,
  `Sage` char(20) NOT NULL,
  `Sifbo` char(20) NOT NULL,
  PRIMARY KEY (`Snumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stainfbase
-- ----------------------------
INSERT INTO `stainfbase` VALUES ('1', '张三', '男', '21', '无');
INSERT INTO `stainfbase` VALUES ('2', '李四', '男', '22', '无');
INSERT INTO `stainfbase` VALUES ('3', '赵一', '男', '23', '无');
INSERT INTO `stainfbase` VALUES ('4', '钱二', '男', '24', '无');
INSERT INTO `stainfbase` VALUES ('5', '孙三', '男', '25', '无');
INSERT INTO `stainfbase` VALUES ('6', '李丽', '女', '25', '无');
INSERT INTO `stainfbase` VALUES ('7', '吴思', '男', '26', '无');
INSERT INTO `stainfbase` VALUES ('8', '郑旋', '女', '24', '无');

-- ----------------------------
-- Table structure for userbase
-- ----------------------------
DROP TABLE IF EXISTS `userbase`;
CREATE TABLE `userbase` (
  `Sname` char(20) NOT NULL,
  `Spassword` char(20) NOT NULL,
  PRIMARY KEY (`Sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userbase
-- ----------------------------
INSERT INTO `userbase` VALUES ('7890@qq.com', '123');

-- ----------------------------
-- View structure for newview
-- ----------------------------
DROP VIEW IF EXISTS `newview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `newview` AS select `userbase`.`Sname` AS `Sname` from `userbase` ;

-- ----------------------------
-- View structure for view2
-- ----------------------------
DROP VIEW IF EXISTS `view2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view2` AS select `stainfbase`.`Snumber` AS `Snumber` from `stainfbase` ;

-- ----------------------------
-- View structure for view3
-- ----------------------------
DROP VIEW IF EXISTS `view3`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view3` AS select `carinfbase`.`Splnumber` AS `Splnumber` from `carinfbase` ;

-- ----------------------------
-- View structure for view4
-- ----------------------------
DROP VIEW IF EXISTS `view4`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view4` AS select `boorecarbase`.`Skey` AS `Skey` from `boorecarbase` ;
