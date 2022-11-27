DROP TABLE IF EXISTS `casbin_rule`;
CREATE TABLE `t_casbin_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ptype` varchar(100) NOT NULL,
  `v0` varchar(100) DEFAULT NULL,
  `v1` varchar(100) DEFAULT NULL,
  `v2` varchar(100) DEFAULT NULL,
  `v3` varchar(100) DEFAULT NULL,
  `v4` varchar(100) DEFAULT NULL,
  `v5` varchar(100) DEFAULT NULL,
  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `node` int NOT NULL,
  `parent_node` int DEFAULT NULL,
  `parent_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `path_string` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_role_name` (`name`),
  KEY `ix_role_path_string` (`path_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Role';

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='User';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'Root', '1', null, null, '1', '1', '0', 'admin', '1658902386540', null, null);
INSERT INTO `t_role` VALUES ('2', 'Client', '2', '1', 'Root', '1_2', '1', '0', 'admin', '1658902386540', null, null);
INSERT INTO `t_role` VALUES ('3', 'Appt. Mgr.', '3', '1', 'Root', '1_3', '1', '0', 'admin', '1658902386540', null, null);
INSERT INTO `t_role` VALUES ('4', 'Warehouse Mgr.', '4', '1', 'Root', '1_4', '1', '0', 'admin', '1658902386540', null, null);
INSERT INTO `t_role` VALUES ('5', 'Appt_Internal', '5', '3', 'Appt. Mgr.', '1_3_5', '1', '0', 'admin', '1658902386540', null, null);
INSERT INTO `t_role` VALUES ('6', 'Warehouse_Internal', '6', '4', 'Warehouse Mgr.', '1_4_6', '1', '0', 'admin', '1658902386540', null, null);
INSERT INTO `t_role` VALUES ('7', 'Visitor', '7', '2', 'Client', '1_2_7', '1', '0', 'admin', '1658902386540', null, null);