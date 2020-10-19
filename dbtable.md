database
CREATE TABLE `blood_donation` (
	`bd_id` VARCHAR(20) NOT NULL COMMENT '현혈증ID' COLLATE 'utf8_general_ci',
	`bdi_id` VARCHAR(20) NULL DEFAULT NULL COMMENT '혈액원ID' COLLATE 'utf8_general_ci',
	`bd_type` VARCHAR(10) NULL DEFAULT NULL COMMENT '헌혈종류' COLLATE 'utf8_general_ci',
	`bd_amount` INT(10) NULL DEFAULT NULL COMMENT '헌혈용량',
	`bd_date` DATETIME NULL DEFAULT NULL COMMENT '헌혈시간',
	`bd_institute` VARCHAR(10) NULL DEFAULT NULL COMMENT '혈액원명' COLLATE 'utf8_general_ci',
	`user_id` VARCHAR(20) NULL DEFAULT NULL COMMENT '회원ID' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`bd_id`) USING BTREE,
	INDEX `bd_u_id` (`user_id`) USING BTREE,
	INDEX `bd_bdi_id` (`bdi_id`) USING BTREE,
	CONSTRAINT `bd_bdi_id` FOREIGN KEY (`bdi_id`) REFERENCES `ktmihs`.`blood_institution` (`bdi_id`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `bd_u_id` FOREIGN KEY (`user_id`) REFERENCES `ktmihs`.`user` (`user_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `blood_institution` (
	`bdi_id` VARCHAR(20) NOT NULL COMMENT '혈액원ID' COLLATE 'utf8_general_ci',
	`bdi_name` VARCHAR(15) NULL DEFAULT NULL COMMENT '혈액원명' COLLATE 'utf8_general_ci',
	`bdi_phone` VARCHAR(11) NULL DEFAULT NULL COMMENT '전화번호' COLLATE 'utf8_general_ci',
	`bdi_add` VARCHAR(70) NULL DEFAULT NULL COMMENT '주소' COLLATE 'utf8_general_ci',
	`bdi_inputdate` DATETIME NULL DEFAULT NULL COMMENT '최종수정시간',
	PRIMARY KEY (`bdi_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `donate` (
	`req_id` VARCHAR(20) NOT NULL COMMENT '요청내역ID' COLLATE 'utf8_general_ci',
	`user_id` VARCHAR(20) NOT NULL COMMENT '회원ID' COLLATE 'utf8_general_ci',
	`donate_date` DATETIME NULL DEFAULT NULL COMMENT '기부 시간',
	`donate_amount` INT(10) NULL DEFAULT NULL COMMENT '수량',
	`donate_cancel` DATETIME NULL DEFAULT NULL COMMENT '취소 시간',
	PRIMARY KEY (`user_id`, `req_id`) USING BTREE,
	INDEX `donate_req_id` (`req_id`, `user_id`) USING BTREE,
	CONSTRAINT `donate_req_id` FOREIGN KEY (`req_id`) REFERENCES `ktmihs`.`request` (`req_id`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `donate_u_id` FOREIGN KEY (`user_id`) REFERENCES `ktmihs`.`user` (`user_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `group` (
	`g_id` VARCHAR(20) NOT NULL COMMENT '그룹ID' COLLATE 'utf8_general_ci',
	`g_name` VARCHAR(15) NULL DEFAULT NULL COMMENT '그룹명' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`g_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `group_detail` (
	`gc_id` VARCHAR(20) NOT NULL COMMENT '그룹코드ID' COLLATE 'utf8_general_ci',
	`gc_name` VARCHAR(15) NULL DEFAULT NULL COMMENT '그룹코드명' COLLATE 'utf8_general_ci',
	`g_id` VARCHAR(20) NULL DEFAULT NULL COMMENT '그룹ID' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`gc_id`) USING BTREE,
	INDEX `gc_g_id` (`g_id`) USING BTREE,
	CONSTRAINT `gc_g_id` FOREIGN KEY (`g_id`) REFERENCES `ktmihs`.`group` (`g_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `request` (
	`req_id` VARCHAR(20) NOT NULL COMMENT '요청내역ID' COLLATE 'utf8_general_ci',
	`req_date` DATETIME NULL DEFAULT NULL COMMENT '요청시간',
	`req_deadline` DATETIME NULL DEFAULT NULL COMMENT '마감시간',
	`req_amount` INT(10) NULL DEFAULT NULL COMMENT '요청량',
	`req_reason` TEXT(65535) NULL DEFAULT NULL COMMENT '요청사유' COLLATE 'utf8_general_ci',
	`req_title` VARCHAR(50) NULL DEFAULT NULL COMMENT '요청제목' COLLATE 'utf8_general_ci',
	`user_id` VARCHAR(20) NULL DEFAULT NULL COMMENT '회원ID' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`req_id`) USING BTREE,
	INDEX `req_u_id` (`user_id`) USING BTREE,
	CONSTRAINT `req_u_id` FOREIGN KEY (`user_id`) REFERENCES `ktmihs`.`user` (`user_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `user` (
	`user_id` VARCHAR(20) NOT NULL COMMENT '사용자 ID' COLLATE 'utf8_general_ci',
	`user_name` VARCHAR(10) NULL DEFAULT NULL COMMENT '사용자 이름' COLLATE 'utf8_general_ci',
	`user_password` VARCHAR(20) NULL DEFAULT NULL COMMENT '비밀번호' COLLATE 'utf8_general_ci',
	`user_birth` INT(8) NULL DEFAULT NULL COMMENT '생년월일',
	`user_gender` BINARY(1) NULL DEFAULT NULL COMMENT '성별',
	`user_phone` VARCHAR(11) NULL DEFAULT NULL COMMENT '전화번호' COLLATE 'utf8_general_ci',
	`user_address` VARCHAR(25) NULL DEFAULT NULL COMMENT '주소' COLLATE 'utf8_general_ci',
	`user_email` VARCHAR(30) NULL DEFAULT NULL COMMENT '이메일' COLLATE 'utf8_general_ci',
	`user_inputdate` VARCHAR(50) NULL DEFAULT NULL COMMENT '최종수정시간' COLLATE 'utf8_general_ci',
	`g_id` VARCHAR(20) NULL DEFAULT NULL COMMENT '그룹ID' COLLATE 'utf8_general_ci',
	PRIMARY KEY (`user_id`) USING BTREE,
	INDEX `u_g_id` (`g_id`) USING BTREE,
	CONSTRAINT `u_g_id` FOREIGN KEY (`g_id`) REFERENCES `ktmihs`.`group` (`g_id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
