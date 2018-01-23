-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.7.18-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.company 结构
CREATE TABLE IF NOT EXISTS `company` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `cdesc` varchar(100) DEFAULT NULL,
  `contract_name` varchar(200) DEFAULT NULL,
  `contract_code` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.employee 结构
CREATE TABLE IF NOT EXISTS `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `joinDate` date DEFAULT NULL,
  `leftDate` date DEFAULT NULL,
  `e_level` varchar(20) DEFAULT NULL,
  `on_off_duty` varchar(20) DEFAULT NULL,
  `idCard` varchar(18) DEFAULT NULL,
  `workplace` varchar(20) DEFAULT NULL,
  `Net_account` varchar(20) DEFAULT NULL,
  `Net_role` varchar(20) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `cno` int(11) DEFAULT NULL,
  `tno` int(11) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FK263y85nt0s6wq3jwxbs688swk` (`cno`),
  KEY `FKcij6dkfv0wkqv4p6slkq1c1wk` (`tno`),
  CONSTRAINT `FK263y85nt0s6wq3jwxbs688swk` FOREIGN KEY (`cno`) REFERENCES `company` (`cid`),
  CONSTRAINT `FKcij6dkfv0wkqv4p6slkq1c1wk` FOREIGN KEY (`tno`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.task 结构
CREATE TABLE IF NOT EXISTS `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(50) DEFAULT NULL,
  `task_creTime` date DEFAULT NULL,
  `task_endTime` date DEFAULT NULL,
  `real_endTime` date DEFAULT NULL,
  `workdays` int(11) DEFAULT NULL,
  `workratio` int(11) DEFAULT NULL,
  `work_efficiency` int(11) DEFAULT NULL,
  `work_quality` int(11) DEFAULT NULL,
  `work_norm` int(11) DEFAULT NULL,
  `work_score` int(11) DEFAULT NULL,
  `convert_score` int(11) DEFAULT NULL,
  `budget_name` varchar(50) DEFAULT NULL,
  `qm_side` varchar(50) DEFAULT NULL,
  `charge_man` varchar(50) DEFAULT NULL,
  `workType` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 test.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
