
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$KETjYMSGBd7AbNNp3EXoMeeef2wQg1IMQF/MYgldkZ34OGxJ4RpMu', '', '', '', '', '');
INSERT INTO `user` VALUES ('2', 'user', '$2a$10$BS1hdRz88hYDLuuBUx.Uo.fQ7VVRMbdJr0N6v5M1fY1vAE5rWlhp6', '', '', '', '', '');

INSERT INTO `authority` VALUES ('1', 'admin');
INSERT INTO `authority` VALUES ('2', 'user');

INSERT INTO `user_authority` VALUES ('1', '1');
INSERT INTO `user_authority` VALUES ('1', '2');
INSERT INTO `user_authority` VALUES ('2', '2');

INSERT INTO `receiver_address` VALUES ('1', '1', '四川省 成都市 高新区 环球中心', '\0', '2017-06-13 21:47:33');
INSERT INTO `receiver_address` VALUES ('2', '1', '四川省 成都市 高新区 双流县', '', '2017-06-13 21:47:41');
