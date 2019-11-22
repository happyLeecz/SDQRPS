USE `SDQRPS`;
CREATE TABLE IF NOT EXISTS `users`(
    `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `description` VARCHAR(100) NOT NULL COMMENT '学院名称',
    `user_name` VARCHAR(100) NOT NULL COMMENT '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `level` INT NOT NULL COMMENT '等级权限',
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;

CREATE TABLE IF NOT EXISTS `indexes`(
    `index_id` INT NOT NULL AUTO_INCREMENT,
    `index_description`varchar(100) NOT NULL,
    PRIMARY KEY (`index_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;

CREATE TABLE IF NOT EXISTS `quality_control`(
    `quality_control_id` INT NOT NULL AUTO_INCREMENT,
    `quality_control_description` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`quality_control_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;

CREATE TABLE IF NOT EXISTS `projects`(
    `project_id` INT NOT NULL AUTO_INCREMENT,
    `project_description` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`project_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;

CREATE TABLE IF NOT EXISTS `relations_i_and_q`(
    `index_id` INT NOT NULL ,
    `quality_control_id` INT NOT NULL ,
    PRIMARY KEY (`index_id`,`quality_control_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;

CREATE TABLE IF NOT EXISTS `relations_q_and_p`(
    `quality_control_id` INT NOT NULL,
    `project_id` INT NOT NULL,
    PRIMARY KEY (`quality_control_id`,`project_id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;

CREATE TABLE IF NOT EXISTS `ideology_and_ethics`(
    `user_id` INT NOT NULL,
    `quality_control_id` INT NOT NULL,
    `target` INT,
    `standard` INT,
    `pre_warning_value`INT,
    PRIMARY KEY (`user_id`,`quality_control_id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4;



