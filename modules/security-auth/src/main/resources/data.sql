INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$ZlvT7SzhZ6pQ1Tqk/WwngOk/9imkYP66la4zwLV3eIkBzaT9MBzoK', '', '', '', '', '');
INSERT INTO `user` VALUES ('2', 'user', '$2a$10$Se63aHJbOg97uYT4l93Aku6UCufTe7WnyUcbjfX6083Oy9CAiiN6S', '', '', '', '', '');

INSERT INTO `authority` VALUES ('1', 'admin');
INSERT INTO `authority` VALUES ('2', 'user');

INSERT INTO `user_authority` VALUES ('1', '1');
INSERT INTO `user_authority` VALUES ('1', '2');
INSERT INTO `user_authority` VALUES ('2', '2');