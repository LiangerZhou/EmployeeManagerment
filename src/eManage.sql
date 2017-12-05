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

-- 正在导出表  test.company 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`cid`, `cname`, `cdesc`, `contract_name`, `contract_code`) VALUES
	(1, '中科云数', '深圳市中科云数科技有限公司', '2017-2018维护类测试技术支持服务框架合同（深圳市中科云数科技有限公司）', 'SZYYGL-SBY-201611-265'),
	(2, '东方国信', '北京东方国信科技股份有限公司', '2017-2018项目类开发技术支持服务框架合同（北京东方国信科技股份有限公司）', 'SZYYGL-SBY-201611-235'),
	(3, '爱立信', '爱立信（中国）通信有限公司', '2017-2018维护类开发技术支持服务框架合同（爱立信（中国）通信有限公司）', 'SZYYGL-SBY-201611-253');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

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
  PRIMARY KEY (`eid`),
  KEY `FK263y85nt0s6wq3jwxbs688swk` (`cno`),
  KEY `FKcij6dkfv0wkqv4p6slkq1c1wk` (`tno`),
  CONSTRAINT `FK263y85nt0s6wq3jwxbs688swk` FOREIGN KEY (`cno`) REFERENCES `company` (`cid`),
  CONSTRAINT `FKcij6dkfv0wkqv4p6slkq1c1wk` FOREIGN KEY (`tno`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  test.employee 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`eid`, `ename`, `sex`, `joinDate`, `leftDate`, `e_level`, `on_off_duty`, `idCard`, `workplace`, `Net_account`, `Net_role`, `Price`, `cno`, `tno`) VALUES
	(1, '徐剑', '男', '2017-01-01', NULL, '高级', '否', '', '', '', '', 1000, 2, 2),
	(2, '邓永清', '男', '2017-01-01', NULL, '高级', '否', '', '', '', '', 1000, 2, 3),
	(3, '何倩', '女', '2017-01-01', NULL, '高级', '否', '', '', '', '', 900, 1, 4),
	(4, '张磊', '男', '2017-01-01', NULL, '中级', '否', '', '', '', '', 800, 1, 5),
	(5, '叶钊', '男', '2017-01-01', NULL, '中级', '否', '', '', '', '', 800, 1, NULL),
	(6, '丁鹏', '男', '2017-01-01', NULL, '中级', '否', '', '', '', '', 800, 1, 8),
	(7, '谢弦旻', '男', '2017-01-01', NULL, '高级', '否', '', '', '', '', 900, 1, 7),
	(8, '邓鹏', '男', '2017-01-01', NULL, '中级', '否', '', '', '', '', 636, 3, 1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

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

-- 正在导出表  test.task 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`task_id`, `task_name`, `task_creTime`, `task_endTime`, `real_endTime`, `workdays`, `workratio`, `work_efficiency`, `work_quality`, `work_norm`, `work_score`, `convert_score`, `budget_name`, `qm_side`, `charge_man`, `workType`, `remark`) VALUES
	(1, '测试综合管理平台过渡系统功能', '2017-11-21', '2017-12-20', '2017-12-20', 22, NULL, 30, 40, 30, 100, NULL, '测试综合管理平台一期', '测评业务线', '张恺', '维护类开发', '维护类开发'),
	(2, '模板管理模块功能优化和改造', '2017-11-21', '2017-12-20', '2017-12-20', 22, NULL, 30, 40, 30, 100, NULL, '质量展示平台', '测评业务线', '张帆', '维护类开发', '维护类开发'),
	(3, '测试综合管理平台过渡系统个人工作台功能模块开发', '2017-11-21', '2017-12-20', '2017-11-20', 22, NULL, 30, 40, 30, 100, NULL, '测试综合管理平台一期', '测评业务线', '张恺', '维护类开发', '维护类开发'),
	(4, '登录模块优化&我的工作台、调研模板、调研任务三大模块的前台功能开发和页面优化', '2017-11-21', '2017-12-20', '2017-11-20', 22, NULL, 30, 40, 30, 100, NULL, '质量展示平台', '测评业务线', '张帆', '维护类开发', '维护类开发'),
	(5, '调研任务和调研分析模块功能优化及4A接口开发', '2017-11-21', '2017-12-20', '2017-12-20', 22, NULL, 30, 40, 30, 100, NULL, '质量展示平台', '测评业务线', '张帆', '维护类开发', '维护类开发'),
	(6, '测试综合管理平台过渡系统专项管理功能开发', '2017-11-21', '2017-12-20', '2017-12-20', 22, NULL, 30, 40, 30, 100, NULL, '测试综合管理平台一期', '测评业务线', '张恺', '维护类开发', '维护类开发'),
	(7, '测试综合管理平台过渡系统框架搭建及系统管理模块开发', '2017-11-21', '2017-12-20', '2017-12-20', 22, NULL, 30, 40, 30, 100, NULL, '测试综合管理平台一期', '测评业务线', '张恺', '维护类开发', '维护类开发'),
	(8, '测试综合管理平台过渡系统专项管理功能开发', '2017-11-21', '2017-12-20', '2017-12-20', 22, NULL, 30, 40, 30, 100, NULL, '测试综合管理平台一期', '测评业务线', '张恺', '维护类开发', '维护类开发');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;

-- 导出  表 test.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 正在导出表  test.user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`) VALUES
	(1, 'root', 'root'),
	(30, 'admin', 'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
