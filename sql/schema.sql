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
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NULL,
  `display_name` varchar(20) NULL,
  `phone` varchar(20) NULL,
  `email` varchar(20) NOT NULL,
  `address` varchar(100) NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_user_username` (`username`),
  UNIQUE KEY `ix_user_email` (`email`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='User';



DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `app_id` int NOT NULL,
  `app_name` varchar(50) NOT NULL,
  `type_id` int NOT NULL COMMENT '3rd party / local / Nas Or Other',
  `type_name` varchar(20) NOT NULL COMMENT 'name',
  `avatar` varchar(200) DEFAULT NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Account';

DROP TABLE IF EXISTS `t_trd_party`;
CREATE TABLE `t_trd_party` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_id` bigint NOT NULL,
  `trd_party_id` varchar(20) NOT NULL,
  `trd_party_name` varchar(20) NOT NULL,
  `type_id` int NOT NULL,
  `type_name` varchar(20) NOT NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='3rd-Party';


DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_id` bigint NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL COMMENT 'S: subject orgs R: Resource orgs ... ',

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_organization_name` (`name`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Organization';

DROP TABLE IF EXISTS `t_organization_role`;
CREATE TABLE `t_organization_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `organization_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_organization_name` (`name`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Organization Role';


DROP TABLE IF EXISTS `t_application`;
CREATE TABLE `t_application` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Application Info';

DROP TABLE IF EXISTS `t_application`;
CREATE TABLE `t_application` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,

  `status` tinyint DEFAULT '1' COMMENT '1: active 0: Inactive',
  `deleted` tinyint NOT NULL DEFAULT '0',
  `in_user` varchar(200) NOT NULL,
  `in_date` bigint NOT NULL,
  `last_edit_user` varchar(200) DEFAULT NULL,
  `last_edit_date` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Application Info';



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