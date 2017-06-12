DROP  DATABASE IF EXISTS seckill;
CREATE DATABASE seckill DEFAULT CHARACTER SET UTF8;

USE seckill;

drop table if exists goods;

drop table if exists seckill;

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
DROP TABLE IF EXISTS `goods`;
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
create table seckill
(
   id                   int not null auto_increment comment '主键',
   goods_id             int comment '商品id',
   start_time           datetime comment '秒杀开始时间',
   end_time             datetime comment '秒杀结束时间',
   stock                int comment '库存',
   primary key (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

alter table seckill comment '秒杀活动';