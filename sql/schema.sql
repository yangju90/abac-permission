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



INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('root',1,'1',1,0,'admin',1658902386540,NULL,NULL);
INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('Client',2,'1_2',1,0,'admin',1658902386540,NULL,NULL);
INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('Appt. Mgr.',3,'1_3',1,0,'admin',1658902386540,NULL,NULL);
INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('Warehouse Mgr.',4,'1_4',1,0,'admin',1658902386540,NULL,NULL);
INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('Appt_Internal',5,'1_3_5',1,0,'admin',1658902386540,NULL,NULL);
INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('Warehouse_Internal',6,'1_4_6',1,0,'admin',1658902386540,NULL,NULL);
INSERT INTO `role` (name,node,path_string,status,deleted,in_user,in_date,last_edit_user,last_edit_date) VALUES ('Visitor',7,'1_2_7',1,0,'admin',1658902386540,NULL,NULL);
