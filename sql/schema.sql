-- abac_sample.`role` definition

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `node` int NOT NULL,
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
