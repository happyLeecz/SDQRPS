CREATE DATABASE SDQRPS;
USE `SDQRPS`;
CREATE TABLE IF NOT EXISTS `users`(
    `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `description` VARCHAR(100) NOT NULL COMMENT '学院名称',
    `user_name` VARCHAR(100) NOT NULL COMMENT '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `level` INT NOT NULL COMMENT '等级权限',
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '用户表（包括学校用户和学院用户）';

CREATE TABLE IF NOT EXISTS `indexes`(
    `index_id` INT NOT NULL AUTO_INCREMENT COMMENT '指标ID',
    `index_description`varchar(100) NOT NULL COMMENT '指标描述',
    PRIMARY KEY (`index_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '指标表';

CREATE TABLE IF NOT EXISTS `quality_control`(
    `quality_control_id` INT NOT NULL AUTO_INCREMENT COMMENT '质控点ID',
    `quality_control_description` VARCHAR(255) NOT NULL COMMENT '质控点描述',
    PRIMARY KEY (`quality_control_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '质控点表';

CREATE TABLE IF NOT EXISTS `projects`(
    `project_id` INT NOT NULL AUTO_INCREMENT COMMENT '项目ID',
    `project_description` VARCHAR(255) NOT NULL COMMENT '项目描述',
    PRIMARY KEY (`project_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '项目表';

CREATE TABLE IF NOT EXISTS `relations_i_and_q`(
    `index_id` INT NOT NULL COMMENT '指标ID',
    `quality_control_id` INT NOT NULL COMMENT '质控点ID',
    PRIMARY KEY (`index_id`,`quality_control_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '指标与质控点关系表';

CREATE TABLE IF NOT EXISTS `relations_q_and_p`(
    `quality_control_id` INT NOT NULL COMMENT '质控点ID',
    `project_id` INT NOT NULL COMMENT '项目ID',
    PRIMARY KEY (`quality_control_id`,`project_id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '质控点与项目关系表';

CREATE TABLE IF NOT EXISTS `ideology_and_ethics`(
    `user_id` INT NOT NULL COMMENT '用户ID',
    `quality_control_id` INT NOT NULL COMMENT '质控点ID',
    `target` INT COMMENT '目标',
    `standard` INT COMMENT '标准',
    `pre_warning_value`INT COMMENT '预警值',
    PRIMARY KEY (`user_id`,`quality_control_id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '思想品德表';

-- 思路是六个大方面每个方面一个表，这里先写了思想品德表的建表语句，后续再添加


