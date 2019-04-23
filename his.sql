/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.11-log : Database - his
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`his` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `his`;

/*Table structure for table `base_dept` */

DROP TABLE IF EXISTS `base_dept`;

CREATE TABLE `base_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_dept` */

insert  into `base_dept`(`dept_id`,`dept_name`) values 
(1,'内科'),
(2,'外科'),
(3,'儿科'),
(4,'骨科'),
(5,'新生儿科'),
(6,'妇产科'),
(7,'神经内科'),
(8,'医务科'),
(9,'药房'),
(10,'综合科');

/*Table structure for table `base_function` */

DROP TABLE IF EXISTS `base_function`;

CREATE TABLE `base_function` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '功能ID',
  `fname` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '功能名称',
  `mid` int(11) DEFAULT NULL COMMENT '模块ID',
  `url` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'url地址',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_function` */

insert  into `base_function`(`fid`,`fname`,`mid`,`url`) values 
(1,'用户管理',4,'/baseUser/list.action'),
(2,'部门管理',4,'/baseDept/list.action'),
(3,'岗位管理',4,'/baseUser/list.action'),
(4,'模块管理',4,'/baseModule/list.action'),
(5,'功能管理',5,'/baseFunction/list.action'),
(9,'角色管理',4,'/baseRole/list.action'),
(10,'生产厂商',2,'/baseManufacturer/list.action'),
(11,'药品类别',2,'/medicineType/list.action'),
(12,'药品编码',2,'/medicineCode/list.action'),
(13,'公司信息表',6,'/companyinfo/list.action'),
(14,'回访信息表',6,'/telvisit/list.action'),
(15,'需求计划表',3,'/medicineReqPlan/list.action'),
(16,'采购信息表',3,'/medicinePurchaseInfo/list.action'),
(17,'药品入库记录',2,'/medicineInstock/list.action'),
(18,'药品库存',2,'/medicineStockinfo/list.action'),
(19,'编辑功能',NULL,'/load.action'),
(20,'删除功能',NULL,'/delete.action'),
(21,'套餐管理',3,'/doctorMenu/list.action'),
(22,'办理就诊卡',4,'/basePatientInfo/list.action'),
(23,'挂号功能',3,'/patientRegisterRecord/list.action'),
(25,'医生就诊记录',3,'/doctorVisitRecord/list.action'),
(26,'期末考试',6,'/inPatient/list.action');

/*Table structure for table `base_manufacturer` */

DROP TABLE IF EXISTS `base_manufacturer`;

CREATE TABLE `base_manufacturer` (
  `man_Code` int(255) NOT NULL AUTO_INCREMENT COMMENT '生产厂商ID',
  `note` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `py1` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '拼音\r\n',
  `man_chn_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂商名称\r\n',
  `man_eng_desc` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '英文名称\r\n',
  `man_abs_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂商简称\r\n',
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址\r\n',
  `fax_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '传真号\r\n',
  `nation_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '国籍代码\r\n',
  `post_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮编编码\r\n',
  `tel_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话\r\n',
  `website` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '网址\r\n',
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电子邮箱\r\n',
  `state_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '省/直辖市\r\n',
  `city_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '县/市\r\n',
  PRIMARY KEY (`man_Code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `base_manufacturer` */

insert  into `base_manufacturer`(`man_Code`,`note`,`py1`,`man_chn_name`,`man_eng_desc`,`man_abs_name`,`address`,`fax_no`,`nation_code`,`post_code`,`tel_no`,`website`,`email`,`state_code`,`city_code`) values 
(1,'aa',NULL,'周口同和堂药业',NULL,NULL,'周口川汇区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'bb',NULL,'周口开心人大药房',NULL,NULL,'周口市经济开发区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,'cc','xianyangsenzhiyao','西安杨森制药',NULL,NULL,'陕西西安市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'aa','zhongguoyiyaojituan','中国医药集团',NULL,'中国医药','中国',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `base_module` */

DROP TABLE IF EXISTS `base_module`;

CREATE TABLE `base_module` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块ID',
  `mname` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '模块名称',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_module` */

insert  into `base_module`(`mid`,`mname`) values 
(1,'收费管理'),
(2,'药房管理'),
(3,'医生工作站'),
(4,'基础信息'),
(5,'统计分析'),
(6,'考试');

/*Table structure for table `base_patient_info` */

DROP TABLE IF EXISTS `base_patient_info`;

CREATE TABLE `base_patient_info` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_name` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '病人姓名',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  `phonenum` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `personid` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_patient_info` */

insert  into `base_patient_info`(`patient_id`,`patient_name`,`birth`,`sex`,`address`,`phonenum`,`personid`) values 
(1,'李四','2018-12-27','女','待定','110','412326'),
(2,'李四2','2018-12-27','男','待定','120','412327'),
(3,'王银星','2018-12-13','男','待定','110','412326199'),
(4,'牙牙','2018-12-27','男','待定','待定','412326');

/*Table structure for table `base_role` */

DROP TABLE IF EXISTS `base_role`;

CREATE TABLE `base_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `rname` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_role` */

insert  into `base_role`(`rid`,`rname`) values 
(11,'采购主管'),
(12,'超级管理员'),
(13,'药剂师'),
(14,'药房主任'),
(15,'采购员'),
(16,'仓库管理员');

/*Table structure for table `base_role_function` */

DROP TABLE IF EXISTS `base_role_function`;

CREATE TABLE `base_role_function` (
  `rmid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `fid` int(11) DEFAULT NULL COMMENT '功能id',
  PRIMARY KEY (`rmid`)
) ENGINE=InnoDB AUTO_INCREMENT=765 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_role_function` */

insert  into `base_role_function`(`rmid`,`rid`,`fid`) values 
(10,10,9),
(207,3,3),
(208,3,10),
(209,3,11),
(210,3,12),
(212,2,10),
(213,2,11),
(214,2,12),
(222,1,11),
(223,1,12),
(282,4,3),
(283,4,4),
(284,4,10),
(285,4,11),
(286,4,12),
(287,4,13),
(288,4,14),
(382,7,1),
(383,7,2),
(384,7,3),
(385,7,4),
(386,7,5),
(387,7,10),
(388,7,11),
(389,7,12),
(390,7,15),
(391,7,16),
(393,6,2),
(394,6,3),
(395,6,4),
(396,6,5),
(397,6,10),
(398,6,11),
(399,6,12),
(400,6,15),
(402,5,3),
(403,5,4),
(404,5,5),
(405,5,10),
(406,5,11),
(407,5,12),
(408,5,13),
(409,5,16),
(459,14,15),
(460,11,16),
(462,15,16),
(474,13,15),
(493,16,17),
(494,16,18),
(744,12,9),
(745,12,1),
(746,12,2),
(747,12,3),
(748,12,4),
(749,12,5),
(750,12,10),
(751,12,11),
(752,12,12),
(753,12,15),
(754,12,16),
(755,12,17),
(756,12,18),
(757,12,19),
(758,12,20),
(759,12,21),
(760,12,22),
(761,12,23),
(762,12,25),
(763,12,13),
(764,12,26);

/*Table structure for table `base_user` */

DROP TABLE IF EXISTS `base_user`;

CREATE TABLE `base_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `cname` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '中文名字',
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `post_id` int(11) DEFAULT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_user` */

insert  into `base_user`(`user_id`,`user_name`,`password`,`cname`,`sex`,`dept_id`,`post_id`) values 
(2,'xulongxi','E10ADC3949BA59ABBE56E057F20F883E','许龙曦','男',1,NULL),
(3,'admin','E10ADC3949BA59ABBE56E057F20F883E','管理员','女',2,NULL),
(4,'chenqihang','E10ADC3949BA59ABBE56E057F20F883E','陈起航','男',3,NULL),
(7,'chenjuncheng','E10ADC3949BA59ABBE56E057F20F883E','陈俊成','男',4,NULL),
(8,'wansan','E10ADC3949BA59ABBE56E057F20F883E','万三','男',5,NULL),
(9,'wangmu','FCEA920F7412B5DA7BE0CF42B8C93759','王沐','男',6,NULL),
(10,'liumaosheng','E10ADC3949BA59ABBE56E057F20F883E','刘茂盛','男',7,NULL),
(11,'wangdingyu','E10ADC3949BA59ABBE56E057F20F883E','王定宇','男',8,NULL),
(13,'wangyufang','FCEA920F7412B5DA7BE0CF42B8C93759','王玉芳','女',9,NULL),
(14,'zhangyi','92894219EF3E7B6D752F058D31C5166C','张毅','男',1,NULL);

/*Table structure for table `base_user_role` */

DROP TABLE IF EXISTS `base_user_role`;

CREATE TABLE `base_user_role` (
  `urid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`urid`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_user_role` */

insert  into `base_user_role`(`urid`,`uid`,`rid`) values 
(61,8,11),
(62,9,12),
(64,7,15),
(65,4,13),
(66,2,14),
(67,10,13),
(68,11,15),
(70,12,16),
(72,3,15),
(73,13,16);

/*Table structure for table `charge_record` */

DROP TABLE IF EXISTS `charge_record`;

CREATE TABLE `charge_record` (
  `charge_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_id` int(11) NOT NULL COMMENT '病人',
  `doctor_id` int(11) DEFAULT NULL COMMENT '医生',
  `amount` double DEFAULT NULL COMMENT '总金额',
  `charge_date` date DEFAULT NULL COMMENT '收费日期',
  `charge_user` int(11) DEFAULT NULL COMMENT '收费人',
  PRIMARY KEY (`charge_id`,`patient_id`),
  UNIQUE KEY `charge_id` (`charge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `charge_record` */

/*Table structure for table `charge_recordinfo` */

DROP TABLE IF EXISTS `charge_recordinfo`;

CREATE TABLE `charge_recordinfo` (
  `charge_infoid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `charge_id` int(11) DEFAULT NULL COMMENT '收费记录',
  `code_id` int(11) DEFAULT NULL COMMENT '药品',
  `unitprc` double DEFAULT NULL COMMENT '单价',
  `amt` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`charge_infoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `charge_recordinfo` */

/*Table structure for table `companyinfo` */

DROP TABLE IF EXISTS `companyinfo`;

CREATE TABLE `companyinfo` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司编号',
  `compname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名称',
  `ownername` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '法人姓名',
  `ownertel` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '法人电话',
  `compinfo` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '公司简介',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `companyinfo` */

insert  into `companyinfo`(`cid`,`compname`,`ownername`,`ownertel`,`compinfo`) values 
(1,'阿里','马云','13768686868','电子商务'),
(2,'腾讯','马化腾','13669696969','聊天'),
(3,'百度','李彦宏','15859595959','搜索');

/*Table structure for table `doctor_menu` */

DROP TABLE IF EXISTS `doctor_menu`;

CREATE TABLE `doctor_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '套餐ID',
  `menu_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '套餐名称',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '套餐描述',
  `type` int(11) DEFAULT NULL COMMENT '套餐类型',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor_menu` */

insert  into `doctor_menu`(`menu_id`,`menu_name`,`user_id`,`description`,`type`) values 
(1,'感冒套餐1',8,'治疗感冒方案1',1),
(2,'感冒套餐2',9,'治疗感冒方案2',2);

/*Table structure for table `doctor_menu_medicine` */

DROP TABLE IF EXISTS `doctor_menu_medicine`;

CREATE TABLE `doctor_menu_medicine` (
  `md_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT '套餐',
  `code_id` int(11) DEFAULT NULL COMMENT '药品',
  `amt` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`md_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor_menu_medicine` */

insert  into `doctor_menu_medicine`(`md_id`,`menu_id`,`code_id`,`amt`) values 
(25,2,1,10),
(26,2,2,5),
(27,1,2,10),
(28,1,3,15);

/*Table structure for table `doctor_visit_record` */

DROP TABLE IF EXISTS `doctor_visit_record`;

CREATE TABLE `doctor_visit_record` (
  `vr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_id` int(11) DEFAULT NULL COMMENT '病人',
  `doctor_id` int(11) DEFAULT NULL COMMENT '医生',
  `visit_date` date DEFAULT NULL COMMENT '就诊时间',
  `symptom` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '症状',
  `advice` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '医生建议',
  `times` int(11) DEFAULT NULL COMMENT '就诊次数',
  `status` int(11) DEFAULT NULL COMMENT '状态(1:已就诊2:已缴费3:已领药)',
  PRIMARY KEY (`vr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor_visit_record` */

/*Table structure for table `doctor_visit_recordinfo` */

DROP TABLE IF EXISTS `doctor_visit_recordinfo`;

CREATE TABLE `doctor_visit_recordinfo` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vr_id` int(11) DEFAULT NULL COMMENT '就诊记录ID',
  `code_id` int(11) DEFAULT NULL COMMENT '药品',
  `amt` int(11) DEFAULT NULL COMMENT '药品数量',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor_visit_recordinfo` */

/*Table structure for table `in_patient` */

DROP TABLE IF EXISTS `in_patient`;

CREATE TABLE `in_patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_name` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '病人姓名',
  `sex` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `bed_num` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '床号',
  `amount` double DEFAULT NULL COMMENT '消费金额',
  `status` int(11) DEFAULT NULL COMMENT '1:在院2:出院',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `in_patient` */

insert  into `in_patient`(`patient_id`,`patient_name`,`sex`,`birth`,`bed_num`,`amount`,`status`) values 
(1,'宋江','男','2018-10-01','儿科1床',36.8,1),
(2,'卢俊义','男','2018-09-02','儿科5床',123.9,1),
(3,'吴用','女','2018-11-03','儿科8床',48.1,1),
(4,'公孙胜','女','2018-08-01','儿科12床',29.4,1),
(5,'关胜','女','2018-07-01','儿科3床',18.3,2),
(6,'林冲','男','2018-06-01','儿科16床',310.2,2),
(7,'秦明','女','2018-05-01','儿科21床',280.5,2),
(8,'呼延灼','男','2018-04-01','儿科24床',176.3,2),
(9,'花荣','女','2018-03-01','儿科13床',90.1,2),
(10,'柴进','男','2018-02-01','儿科2床',65.1,1),
(11,'李应','男','2018-01-01','儿科6床',420.5,1),
(12,'朱仝','男','2017-10-01','儿科19床',367,2),
(13,'鲁智深','女','2017-09-01','儿科31床',250.1,2),
(14,'武松','女','2018-10-19','儿科28床',210.9,1),
(15,'董平','女','2018-07-08','儿科18床',248.3,1),
(16,'张清','女','2018-06-10','儿科11床',27.9,1),
(17,'杨志','男','2018-05-11','儿科4床',13.8,2),
(18,'徐宁','女','2018-04-12','儿科33床',124.5,2),
(19,'索超','男','2018-09-20','儿科38床',230.8,2),
(20,'戴宗','女','2018-07-23','儿科45床',345.6,1);

/*Table structure for table `medicine_code` */

DROP TABLE IF EXISTS `medicine_code`;

CREATE TABLE `medicine_code` (
  `code_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '药品ID\r\n',
  `MEDICINE_NAME` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '药品名\r\n',
  `alias_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '别名名称\r\n',
  `specification` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '规格\r\n',
  `man_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂商ID\r\n',
  `man_chn_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂商名称\r\n',
  `type_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '药品分类名称(W 西药 C 中成药 G 中草药)\r\n',
  `type_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '药品分类代码\r\n',
  `stock_unit` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '库存单位\r\n',
  `retail_price` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '零售价\r\n',
  `stock_price` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '库存平均价 (加权平均成本)\r\n',
  `drug_notes_patient` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用药注意事项\r\n',
  `drug_note` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '药袋说明\r\n',
  `drug_form` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '药品外形说明\r\n',
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `medicine_code` */

insert  into `medicine_code`(`code_id`,`MEDICINE_NAME`,`alias_name`,`specification`,`man_code`,`man_chn_name`,`type_name`,`type_code`,`stock_unit`,`retail_price`,`stock_price`,`drug_notes_patient`,`drug_note`,`drug_form`) values 
(1,'恩替卡韦分散片',NULL,'0.5mg*7片','3','西安杨森制药','W','1','盒',NULL,NULL,NULL,NULL,NULL),
(2,'叶酸片',NULL,'0.4mg*31片*3板','1','周口同和堂药业','G','3','盒',NULL,NULL,NULL,NULL,NULL),
(3,'1-1-二甲基-4-4-联吡啶阳离子盐','百草枯','10ml*5瓶','3','西安杨森制药','W','1','瓶','0','0','避免进行接触',NULL,NULL);

/*Table structure for table `medicine_instock` */

DROP TABLE IF EXISTS `medicine_instock`;

CREATE TABLE `medicine_instock` (
  `instock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invno` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '发票号',
  `medicine_codeid` int(11) DEFAULT NULL COMMENT '药品',
  `inamt` int(11) DEFAULT NULL COMMENT '入库数量',
  `unitprc` double DEFAULT NULL COMMENT '入库单价',
  `zje` double DEFAULT NULL COMMENT '入库总金额',
  `instock_userid` int(11) DEFAULT NULL COMMENT '入库人',
  `instock_date` date DEFAULT NULL COMMENT '入库日期',
  `man_code` int(11) DEFAULT NULL COMMENT '供应商',
  PRIMARY KEY (`instock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `medicine_instock` */

insert  into `medicine_instock`(`instock_id`,`invno`,`medicine_codeid`,`inamt`,`unitprc`,`zje`,`instock_userid`,`instock_date`,`man_code`) values 
(28,'请输入发票号1',1,600,10,6000,9,'2018-12-19',3),
(29,'请输入发票号2',2,100,10,1000,9,'2018-12-19',2),
(30,'请输入发票号3',2,100,15,1500,9,'2018-12-19',1),
(31,'请输入发票号4',2,100,20,2000,9,'2018-12-19',2),
(32,'1',3,100,20,2000,9,'2018-12-19',1);

/*Table structure for table `medicine_month_balance` */

DROP TABLE IF EXISTS `medicine_month_balance`;

CREATE TABLE `medicine_month_balance` (
  `balance_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `month` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '月份',
  `code_id` int(11) DEFAULT NULL COMMENT '药品',
  `stock_amt` int(11) DEFAULT NULL COMMENT '库存数量',
  `real_amt` int(11) DEFAULT NULL COMMENT '实际数量',
  `result` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '结果',
  `balance_user` int(11) DEFAULT NULL COMMENT '盘点人',
  PRIMARY KEY (`balance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `medicine_month_balance` */

/*Table structure for table `medicine_outstock` */

DROP TABLE IF EXISTS `medicine_outstock`;

CREATE TABLE `medicine_outstock` (
  `outstock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code_id` int(11) DEFAULT NULL COMMENT '药品',
  `outamt` int(11) DEFAULT NULL COMMENT '出库数量',
  `unitprc` double DEFAULT NULL COMMENT '出库单价',
  `zje` double DEFAULT NULL COMMENT '总金额',
  `outstock_user` int(11) DEFAULT NULL COMMENT '出库人',
  `outstock_date` date DEFAULT NULL COMMENT '出库日期',
  `patient_id` int(11) DEFAULT NULL COMMENT '病人',
  `doctor_id` int(11) DEFAULT NULL COMMENT '医生',
  PRIMARY KEY (`outstock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `medicine_outstock` */

/*Table structure for table `medicine_purchase_info` */

DROP TABLE IF EXISTS `medicine_purchase_info`;

CREATE TABLE `medicine_purchase_info` (
  `PCH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购编号',
  `MEDICINE_CODEID` int(11) DEFAULT NULL COMMENT '药品',
  `MAN_CODE` int(11) DEFAULT NULL COMMENT '供应商',
  `PCH_AMT` int(11) DEFAULT NULL COMMENT '采购数量',
  `PCH_PRICE` double DEFAULT NULL COMMENT '采购单价',
  `PCH_TOTAL` double DEFAULT NULL COMMENT '采购总价',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `PCH_USERID` int(11) DEFAULT NULL COMMENT '汇总人',
  `PCH_DATE` date DEFAULT NULL COMMENT '汇总日期',
  `APPRV_USERID` int(11) DEFAULT NULL COMMENT '审批人',
  `APPRV_DATE` date DEFAULT NULL COMMENT '审批日期',
  PRIMARY KEY (`PCH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `medicine_purchase_info` */

insert  into `medicine_purchase_info`(`PCH_ID`,`MEDICINE_CODEID`,`MAN_CODE`,`PCH_AMT`,`PCH_PRICE`,`PCH_TOTAL`,`STATUS`,`PCH_USERID`,`PCH_DATE`,`APPRV_USERID`,`APPRV_DATE`) values 
(30,1,3,600,10,6000,3,7,'2018-12-11',2,'2018-12-10'),
(31,2,2,100,10,1000,3,7,'2018-12-11',2,'2018-12-10'),
(32,2,1,100,15,1500,3,11,'2018-12-11',2,'2018-12-11'),
(33,2,2,100,20,2000,3,9,'2018-12-18',9,'2018-12-18'),
(34,3,1,100,20,2000,3,9,'2018-12-19',9,'2018-12-19');

/*Table structure for table `medicine_req_plan` */

DROP TABLE IF EXISTS `medicine_req_plan`;

CREATE TABLE `medicine_req_plan` (
  `REQPLNNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求计划编号',
  `MEDICINE_CODEID` int(11) DEFAULT NULL COMMENT '药品',
  `REQAMT` int(11) DEFAULT NULL COMMENT '需求数量',
  `APP_USERID` int(11) DEFAULT NULL COMMENT '申请人',
  `APP_DATE` date DEFAULT NULL COMMENT '申请日期',
  `PURPOSE` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用途',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `APPRV_USERID` int(11) DEFAULT NULL COMMENT '审批人',
  `APPRV_DATE` date DEFAULT NULL COMMENT '审批日期',
  PRIMARY KEY (`REQPLNNO`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `medicine_req_plan` */

insert  into `medicine_req_plan`(`REQPLNNO`,`MEDICINE_CODEID`,`REQAMT`,`APP_USERID`,`APP_DATE`,`PURPOSE`,`STATUS`,`APPRV_USERID`,`APPRV_DATE`) values 
(23,1,200,2,'2018-12-10','测试',3,2,'2018-12-10'),
(24,1,200,10,'2018-12-10','测试',3,2,'2018-12-10'),
(25,2,100,10,'2018-12-10','测试',3,2,'2018-12-10'),
(26,1,200,4,'2018-12-10','测试',3,2,'2018-12-11'),
(27,3,2000,4,'2018-12-10','测试',1,NULL,NULL),
(28,2,200,4,'2018-12-11','测试',3,2,'2018-12-11'),
(29,2,100,9,'2018-12-18','测试2',3,9,'2018-12-18'),
(30,3,100,9,'2018-12-19','测试2',3,9,'2018-12-19');

/*Table structure for table `medicine_stockinfo` */

DROP TABLE IF EXISTS `medicine_stockinfo`;

CREATE TABLE `medicine_stockinfo` (
  `stockinfo_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `medicinecode_id` int(11) DEFAULT NULL COMMENT '药品',
  `amt` int(11) DEFAULT NULL COMMENT '库存数量',
  `unitprc` double DEFAULT NULL COMMENT '库存单价',
  `saleunitprc` double DEFAULT NULL COMMENT '销售单价(库存单价*1.5)',
  `zje` double DEFAULT NULL COMMENT '库存总金额(库存单价*数量)',
  PRIMARY KEY (`stockinfo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `medicine_stockinfo` */

insert  into `medicine_stockinfo`(`stockinfo_id`,`medicinecode_id`,`amt`,`unitprc`,`saleunitprc`,`zje`) values 
(14,1,600,10,15,6000),
(15,2,200,17.5,22.5,3500),
(18,3,100,20,30,2000);

/*Table structure for table `medicine_type` */

DROP TABLE IF EXISTS `medicine_type`;

CREATE TABLE `medicine_type` (
  `type_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '生产厂商ID\r\n',
  `type_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '类别名称\r\n',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注\r\n',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `medicine_type` */

insert  into `medicine_type`(`type_id`,`type_name`,`remark`) values 
(1,'W','西药'),
(2,'C','中成药'),
(3,'G','中草药');

/*Table structure for table `netstorage` */

DROP TABLE IF EXISTS `netstorage`;

CREATE TABLE `netstorage` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `fileSize` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `uploadDate` date DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `netstorage` */

/*Table structure for table `patient_register_record` */

DROP TABLE IF EXISTS `patient_register_record`;

CREATE TABLE `patient_register_record` (
  `register_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patient_id` int(11) DEFAULT NULL COMMENT '病人',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门',
  `register_date` date DEFAULT NULL COMMENT '挂号时间',
  `record_user` int(11) DEFAULT NULL COMMENT '挂号人',
  `doctor_id` int(11) DEFAULT NULL COMMENT '医生',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `patient_register_record` */

insert  into `patient_register_record`(`register_id`,`patient_id`,`dept_id`,`register_date`,`record_user`,`doctor_id`,`status`) values 
(2,3,1,'2018-12-28',9,14,1),
(3,4,1,'2018-12-28',9,14,1);

/*Table structure for table `telvisit` */

DROP TABLE IF EXISTS `telvisit`;

CREATE TABLE `telvisit` (
  `tvid` int(11) NOT NULL AUTO_INCREMENT COMMENT '回访编号',
  `telname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '回访人姓名',
  `teltime` date DEFAULT NULL COMMENT '回访时间',
  `visitreason` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '回访分类',
  `visitreturn` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '回访结果',
  `visittype` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '回访方式',
  `cid` int(11) DEFAULT NULL COMMENT '所属公司编号',
  PRIMARY KEY (`tvid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `telvisit` */

insert  into `telvisit`(`tvid`,`telname`,`teltime`,`visitreason`,`visitreturn`,`visittype`,`cid`) values 
(1,'李明','2018-10-01','cc','dd','ee',23),
(2,'梁哲','2018-10-02','售后回访','AAA','电话',1),
(3,'张戈','2018-10-03','销售意向回访','BBB','QQ',1),
(4,'张戈','2018-10-04','销售意向回访','CCC','微信',1),
(5,'庞星辰','2018-10-05','售后回访','DDD','电话',2),
(6,'庞星辰','2018-10-06','售后回访','EEE','QQ',2),
(7,'万俊辉','2018-10-07','满意度回访','FFF','微信',2),
(8,'王梦瑶','2018-10-08','满意度回访','GGG','QQ',2),
(9,'耿俊宇','2018-10-09','售后回访','调查','微信',2),
(10,'徐广慧','2018-10-10','销售意向回访','HHH','电话',2),
(11,'耿俊宇','2018-10-11','销售意向回访','III','微信',2),
(12,'张家豪','2018-10-12','售后回访','不不不','电话',2),
(13,'王旗','2018-10-13','售后回访','玩玩玩','电话',3),
(14,'李志新','2018-10-14','销售意向回访','KKK','QQ',3),
(15,'王文迪','2018-10-15','满意度回访','文文文','QQ',3),
(16,'孙玉峰','2018-12-04','售后回访','UUU','电话',2),
(17,'刘博','2018-12-01','销售意向回访','xxx','QQ',1),
(18,'刘博','2018-12-01','销售意向回访','xxx','QQ',1),
(19,'申宇浩','2018-12-07','满意度回访','yyy','微信',3);

/*Table structure for table `telvisit2` */

DROP TABLE IF EXISTS `telvisit2`;

CREATE TABLE `telvisit2` (
  `tvid` int(11) NOT NULL AUTO_INCREMENT COMMENT '回访编号',
  `telname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '回访人姓名',
  `teltime` date DEFAULT NULL COMMENT '回访时间',
  `visitreason` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '回访分类',
  `visitreturn` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '回访结果',
  `visittype` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '回访方式',
  `cid` int(11) DEFAULT NULL COMMENT '所属公司编号',
  PRIMARY KEY (`tvid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `telvisit2` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pwd` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`,`pwd`) values 
(1,'王沐','123456');

/* Procedure structure for procedure `demo1` */

/*!50003 DROP PROCEDURE IF EXISTS  `demo1` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `demo1`()
BEGIN
	declare i int;
	set i=1;
	set i=i+1;
	select i;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `demo2` */

/*!50003 DROP PROCEDURE IF EXISTS  `demo2` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `demo2`()
BEGIN
	declare i varchar(30);
	set i='张三';
	select i;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `demo3` */

/*!50003 DROP PROCEDURE IF EXISTS  `demo3` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `demo3`(in myvar varchar(50))
BEGIN
	DECLARE i int;
	SELECT COUNT(*) INTO i FROM companyinfo c LEFT JOIN telvisit t ON c.cid=t.cid WHERE c.compname=myvar;
	SELECT i;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `demo4` */

/*!50003 DROP PROCEDURE IF EXISTS  `demo4` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `demo4`(in cid int)
BEGIN
	 declare myvar varchar(50);
	if cid=1
		then SELECT COUNT(*) into myvar FROM companyinfo c LEFT JOIN telvisit t ON c.cid=t.cid;
	elseif cid=2
		then SELECT COUNT(*) into myvar FROM companyinfo c LEFT JOIN telvisit t ON c.cid=t.cid WHERE t.telname LIKE '%张%';
	elseif cid=3
		then SELECT t.telname into myvar FROM companyinfo c LEFT JOIN telvisit t ON c.cid=t.cid GROUP BY t.telname ORDER BY COUNT(*) DESC LIMIT 1;
	else select '错误访问';
	end if;
	select myvar;
	

	END */$$
DELIMITER ;

/* Procedure structure for procedure `demo5` */

/*!50003 DROP PROCEDURE IF EXISTS  `demo5` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `demo5`()
BEGIN

	declare i int default 1;
	declare sum int default 0;
	while(i<=5) do
	
		set sum=sum+i;
		set i=i+1;
		
	end while;
	
	select sum;
	
	
	END */$$
DELIMITER ;

/* Procedure structure for procedure `demo6Copy` */

/*!50003 DROP PROCEDURE IF EXISTS  `demo6Copy` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `demo6Copy`()
BEGIN
	#定义变量
	DECLARE _telname VARCHAR(50);
	DECLARE _visitreason VARCHAR(50);
	#定义游标结束标志
	DECLARE stopflag INT DEFAULT 0;
	#定义游标
	DECLARE telvisitlist CURSOR FOR SELECT t.telname,t.visitreason FROM telvisit t WHERE t.teltime BETWEEN '2018-10-01' AND '2018-10-31';
	
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET stopflag=1;
	#打开游标
	OPEN telvisitlist;
		#从游标中取一条数据
		FETCH telvisitlist INTO _telname,_visitreason;
		WHILE stopflag=0 DO
			BEGIN
				INSERT INTO telvisit2(telname,visitreason) VALUES(_telname,_visitreason);
				#从游标中取一条数据
				FETCH telvisitlist INTO _telname,_visitreason;	
			END;
		END WHILE;
	#关闭游标
	CLOSE telvisitlist;
	
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
