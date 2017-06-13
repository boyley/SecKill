Create Database If Not Exists seckill Character Set UTF8;
USE seckill;

DROP TABLE IF EXISTS `receiver_address`;

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