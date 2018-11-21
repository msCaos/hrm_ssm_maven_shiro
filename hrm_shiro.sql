/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.22-community-nt : Database - hrm_db3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hrm_db3` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hrm_db3`;

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) default NULL COMMENT '访问url地址',
  `percode` varchar(128) default NULL COMMENT '权限代码字符串',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`name`,`type`,`url`,`percode`) values (11,'商品管理','permission','/item/queryItem.action','item:all'),(12,'商品新增','permission','/item/add.action','item:create'),(13,'商品修改','permission','/item/editItem.action','item:update'),(14,'商品删除','permission','','item:delete'),(15,'商品查询','permission','/item/queryItem.action','item:query'),(21,'用户管理','permission','/user/query.action','user:query'),(22,'用户新增','permission','','user:create'),(23,'用户修改','permission','','user:update'),(24,'用户删除','permission','','user:delete'),(25,'部门删除','permission','/department/delete','dept:delete'),(26,'部门查询','permission','/department/query','dept:query');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(128) NOT NULL,
  `available` char(1) default NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`available`) values ('90eec7e5-c7de-1036-9929-4e82a2a75ddd','部门管理员','1'),('ebc8a441-c6f9-11e4-b137-0adc305c3f28','超级管理员','1'),('ebc9d647-c6f9-11e4-b137-0adc305c3f28','用户管理员','1');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `id` varchar(36) NOT NULL,
  `sys_role_id` varchar(48) NOT NULL default '' COMMENT '角色id',
  `sys_permission_id` varchar(32) NOT NULL COMMENT '权限id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`id`,`sys_role_id`,`sys_permission_id`) values ('90eec7e5-c7de-1036-9929-4e82a2a75123','90eec7e5-c7de-1036-9929-4e82a2a75ddd','25'),('90eec7e5-c7de-1036-9929-4e82a2a75aaa','90eec7e5-c7de-1036-9929-4e82a2a75ddd','26'),('90eec7e5-c7de-1036-9929-4e82a2a75xxx','90eec7e5-c7de-1036-9929-4e82a2a75ddd','12'),('ebc8a441-c6f9-11e4-b137-0adc305c3f21','ebc8a441-c6f9-11e4-b137-0adc305c3f28','12 '),('ebc8a441-c6f9-11e4-b137-0adc305c3f22','ebc8a441-c6f9-11e4-b137-0adc305c','11'),('ebc8a441-c6f9-11e4-b137-0adc305c3f24','ebc9d647-c6f9-11e4-b137-0adc305c','21'),('ebc8a441-c6f9-11e4-b137-0adc305c3f25','ebc8a441-c6f9-11e4-b137-0adc305c','15'),('ebc9d647-c6f9-11e4-b137-0adc305c3f23','ebc9d647-c6f9-11e4-b137-0adc305c','22'),('ebc9d647-c6f9-11e4-b137-0adc305c3f26','ebc8a441-c6f9-11e4-b137-0adc305c','13');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `sys_user_id` varchar(32) NOT NULL,
  `sys_role_id` varchar(64) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`sys_user_id`,`sys_role_id`) values ('1','1','ebc8a441-c6f9-11e4-b137-0adc305c3f28'),('2','2','ebc9d647-c6f9-11e4-b137-0adc305c3f28'),('3','6','90eec7e5-c7de-1036-9929-4e82a2a75ddd');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
