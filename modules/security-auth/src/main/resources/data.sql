INSERT INTO `user` VALUES ('1', 'admin', 'admin', '', '', '', '', '');
INSERT INTO `user` VALUES ('2', 'user', 'user', '', '', '', '', '');

INSERT INTO `authority` VALUES ('1', 'admin');
INSERT INTO `authority` VALUES ('2', 'user');

INSERT INTO `user_authority` VALUES ('1', '1');
INSERT INTO `user_authority` VALUES ('1', '2');
INSERT INTO `user_authority` VALUES ('2', '2');