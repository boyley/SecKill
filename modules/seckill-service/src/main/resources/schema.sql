DROP  DATABASE IF EXISTS seckill;
CREATE DATABASE seckill DEFAULT CHARACTER SET UTF8;

USE seckill;

DROP TABLE IF EXISTS `goods`;

DROP TABLE IF EXISTS `seckill`;

DROP TABLE IF EXISTS `receiver_address`;

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(20) DEFAULT NULL COMMENT '商品标题',
  `name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `summary` varchar(50) DEFAULT NULL COMMENT '商品摘要',
  `putaway` bit(1) DEFAULT NULL COMMENT '是否上架',
  `seckill` bit(1) DEFAULT b'0' COMMENT '是否参与秒杀活动',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';

/*==============================================================*/
/* Table: seckill                                               */
/*==============================================================*/
CREATE TABLE `seckill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `start_time` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '秒杀结束时间',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='秒杀活动';


-- ----------------------------
-- Table structure for seckill
-- ----------------------------
CREATE TABLE `receiver_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `use` bit(1) DEFAULT b'0' COMMENT '是否是常用地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='收货地址';