# CREATE DATABASE SDQRPS;
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

# CREATE TABLE IF NOT EXISTS `relations_i_and_q`(
#     `index_id` INT NOT NULL COMMENT '指标ID',
#     `quality_control_id` INT NOT NULL COMMENT '质控点ID',
#     PRIMARY KEY (`index_id`,`quality_control_id`)
# )ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '指标与质控点关系表';

CREATE TABLE IF NOT EXISTS `relations_q_and_p`(
    `quality_control_id` INT NOT NULL COMMENT '质控点ID',
    `project_id` INT NOT NULL COMMENT '项目ID',
    PRIMARY KEY (`quality_control_id`,`project_id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '质控点与项目关系表';

CREATE TABLE IF NOT EXISTS `content`(
     `content_id` INT NOT NULL AUTO_INCREMENT COMMENT '内容ID',
     `content` VARCHAR(50) NOT NULL COMMENT '内容',
      PRIMARY KEY (`content_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '内容表';

CREATE TABLE IF NOT EXISTS `details`(
    `content_id` INT NOT NULL COMMENT '内容ID',
    `user_id` INT NOT NULL COMMENT '用户ID',
    `index_id` INT NOT NULL COMMENT '指标ID',
    `quality_control_id` INT NOT NULL COMMENT '质控点ID',
    `target` INT COMMENT '目标' DEFAULT 0,
    `standard` INT COMMENT '标准' DEFAULT 0 ,
    `pre_warning_value`INT COMMENT '预警值' DEFAULT 0,
    PRIMARY KEY (`content_id`,`user_id`,`index_id`,`quality_control_id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8MB4 COMMENT '学院具体内容表';
#插入内容信息
# insert into content(content) values ('思想品德');
# insert into content(content) values ('行为规范');
# insert into content(content) values ('身心素质');
# insert into content(content) values ('专业技能');
# insert into content(content) values ('职业技能');
# insert into content(content) values ('创新创业');
# 插入指标信息
# insert into indexes(index_description) values ('思想品德');
#
# insert into indexes(index_description) values ('行为规范');
#
# insert into indexes(index_description) values ('心理发展');
# insert into indexes(index_description) values ('身体发展');
# insert into indexes(index_description) values ('身心发展保障');
#
# insert into indexes(index_description) values ('学业奖励');
# insert into indexes(index_description) values ('学习状况');
# insert into indexes(index_description) values ('学业发展保障');
#
# insert into indexes(index_description) values ('职业生涯');
# insert into indexes(index_description) values ('就业状况');
# insert into indexes(index_description) values ('就业保障');
# insert into indexes(index_description) values ('社会实践');
#
# insert into indexes(index_description) values ('创新创业状况');
# insert into indexes(index_description) values ('创新创业保障');

#插入指控点内容
# insert into quality_control(quality_control_description) values ('入党积极分子学生比例');
# insert into quality_control(quality_control_description) values ('学生党员比例');
# insert into quality_control(quality_control_description) values ('学生团员比例');
# insert into quality_control(quality_control_description) values ('学生干部比例');
# insert into quality_control(quality_control_description) values ('文明班级比例');
# insert into quality_control(quality_control_description) values ('文明宿舍比例');
# insert into quality_control(quality_control_description) values ('大学生参军入伍比例');
# insert into quality_control(quality_control_description) values ('学生参加公益活动率');
# insert into quality_control(quality_control_description) values ('早操出勤率');
# insert into quality_control(quality_control_description) values ('晚归率');
# insert into quality_control(quality_control_description) values ('无烟公寓达标率');
# insert into quality_control(quality_control_description) values ('公共场合不文明现象');
# insert into quality_control(quality_control_description) values ('参与心理健康活动学生数占学生数比例');
# insert into quality_control(quality_control_description) values ('修学心理健康课程学生数占学生数比例');
# insert into quality_control(quality_control_description) values ('心理委员人数');
# insert into quality_control(quality_control_description) values ('新生心理健康普查率');
# insert into quality_control(quality_control_description) values ('体质测试合格学生人数所占比例');
# insert into quality_control(quality_control_description) values ('参加运动会学生人数所占比例');
# insert into quality_control(quality_control_description) values ('体育选修课学生数量所占比例');
# insert into quality_control(quality_control_description) values ('辅导员年获省级及以上奖项数量');
# insert into quality_control(quality_control_description) values ('辅导员召开日常班会次数');
# insert into quality_control(quality_control_description) values ('辅导员每学期召开主题班会次数');
# insert into quality_control(quality_control_description) values ('辅导员年外出参加培训人次比例');
# insert into quality_control(quality_control_description) values ('辅导员工作日志');
# insert into quality_control(quality_control_description) values ('班级日志');
# insert into quality_control(quality_control_description) values ('国家奖学金人数');
# insert into quality_control(quality_control_description) values ('国家励志奖学金获奖学生比例');
# insert into quality_control(quality_control_description) values ('行业、企事业单位设立的奖学金获奖人数');
# insert into quality_control(quality_control_description) values ('国家级竞赛获奖数量');
# insert into quality_control(quality_control_description) values ('省级竞赛获奖数量');
# insert into quality_control(quality_control_description) values ('必修课程及格率');
# insert into quality_control(quality_control_description) values ('月人均借书情况');
# insert into quality_control(quality_control_description) values ('到课率');
# insert into quality_control(quality_control_description) values ('受处分学生比例');
# insert into quality_control(quality_control_description) values ('学生班会出勤率');
# insert into quality_control(quality_control_description) values ('年学业指导主题班会数量');
# insert into quality_control(quality_control_description) values ('就业创业课程建设情况');
# insert into quality_control(quality_control_description) values ('学生职业发展规划目标完成情况');
# insert into quality_control(quality_control_description) values ('初次就业率');
# insert into quality_control(quality_control_description) values ('就业专业相关度');
# insert into quality_control(quality_control_description) values ('初就业薪酬待遇（元）');
# insert into quality_control(quality_control_description) values ('工作满意度');
# insert into quality_control(quality_control_description) values ('年大型招聘会次数');
# insert into quality_control(quality_control_description) values ('年招聘用人单位数量');
# insert into quality_control(quality_control_description) values ('年就业指导参与学生率');
# insert into quality_control(quality_control_description) values ('年招聘岗位数量');
# insert into quality_control(quality_control_description) values ('社会实践学生参与次数');
# insert into quality_control(quality_control_description) values ('勤工助学率');
# insert into quality_control(quality_control_description) values ('年学生创业项目数量');
# insert into quality_control(quality_control_description) values ('创业学生人数');
# insert into quality_control(quality_control_description) values ('创业奖项数量');
# insert into quality_control(quality_control_description) values ('学生创业培育数量');
# insert into quality_control(quality_control_description) values ('年组织就业创业培训场次');
# insert into quality_control(quality_control_description) values ('创业经费');
# insert into quality_control(quality_control_description) values ('就业创业信息平台建设');

#插入项目信息
# insert into projects(project_description) values ('动员学生提交入党申请书');
# insert into projects(project_description) values ('入党积极分子发展');
# insert into projects(project_description) values ('参加红色教育活动（具体罗列）');
# insert into projects(project_description) values ('进入重点培养对象');
# insert into projects(project_description) values ('进入预备党员行列');
# insert into projects(project_description) values ('学生提交入团申请书');
# insert into projects(project_description) values ('已具备团员身份');
# insert into projects(project_description) values ('青年大学习次数');
# insert into projects(project_description) values ('担任班级委员');
# insert into projects(project_description) values ('起到模范带头作用程度');
# insert into projects(project_description) values ('班级获得院级文明班级荣誉');
# insert into projects(project_description) values ('班级获得校级文明班级荣誉');
# insert into projects(project_description) values ('班级获得院级先进团支部荣誉');
# insert into projects(project_description) values ('班级获得校级级先进团支部荣誉');
# insert into projects(project_description) values ('班级获得优秀军训连队荣誉');
# insert into projects(project_description) values ('宿舍获得三星级宿舍次数');
# insert into projects(project_description) values ('宿舍获得二星级宿舍次数');
# insert into projects(project_description) values ('宿舍获得一星级宿舍次数');
# insert into projects(project_description) values ('申请报名参军');
# insert into projects(project_description) values ('参军入伍');
# insert into projects(project_description) values ('参加学雷锋日（具体活动名称）');
# insert into projects(project_description) values ('参加每周升国旗');
# insert into projects(project_description) values ('参加晚自习');
# insert into projects(project_description) values ('罗列其他必须参加的活动');
# insert into projects(project_description) values ('公寓查宿未归次数');
# insert into projects(project_description) values ('宿舍获得三星级宿舍次数');
# insert into projects(project_description) values ('公共场合打闹、说脏话、吐痰、吸烟等行为被发现次数');
# insert into projects(project_description) values ('几次心理讲座罗列（参加即满分）');
# insert into projects(project_description) values ('参加心理知识竞赛');
# insert into projects(project_description) values ('获校级知识竞赛一等奖');
# insert into projects(project_description) values ('获校级知识竞赛二等奖');
# insert into projects(project_description) values ('获校级知识竞赛三等奖');
# insert into projects(project_description) values ('出勤次数');
# insert into projects(project_description) values ('成绩');
# insert into projects(project_description) values ('担任心理委员');
# insert into projects(project_description) values ('起到模范带头作用程度（发现同学心理异常报告次数）');
# insert into projects(project_description) values ('未列入心理普查重点关注对象');
# insert into projects(project_description) values ('体质测试合格');
# insert into projects(project_description) values ('体质测试优秀');
# insert into projects(project_description) values ('报名参加运动会');
# insert into projects(project_description) values ('参加运动会');
# insert into projects(project_description) values ('在运动会获奖');
# insert into projects(project_description) values ('选修体育课');
# insert into projects(project_description) values ('参加院内各级体育活动（一一罗列）');
# insert into projects(project_description) values ('参加院内各级体育活动（一一罗列）获奖');
# insert into projects(project_description) values ('获得校级荣誉');
# insert into projects(project_description) values ('获得省级奖励');
# insert into projects(project_description) values ('辅导员召开日常班会次数');
# insert into projects(project_description) values ('辅导员每学期召开主题班会次数');
# insert into projects(project_description) values ('辅导员年外出参加培训次数');
# insert into projects(project_description) values ('有且完整');
# insert into projects(project_description) values ('有且完整');
# insert into projects(project_description) values ('符合报名条件');
# insert into projects(project_description) values ('获得者');
# insert into projects(project_description) values ('符合报名条件');
# insert into projects(project_description) values ('获得者');
# insert into projects(project_description) values ('获得者');
# insert into projects(project_description) values ('参赛者（项目一一罗列）');
# insert into projects(project_description) values ('获奖者（项目一一罗列）');
# insert into projects(project_description) values ('参赛者（项目一一罗列）');
# insert into projects(project_description) values ('获奖者（项目一一罗列）');
# insert into projects(project_description) values ('必修课程及格率');
# insert into projects(project_description) values ('每月借书量');
# insert into projects(project_description) values ('每月买书量');
# insert into projects(project_description) values ('每月网上完全阅读书籍量');
# insert into projects(project_description) values ('每月课堂出勤次数');
# insert into projects(project_description) values ('受处分');
# insert into projects(project_description) values ('出勤次数');
# insert into projects(project_description) values ('参会次数');
# insert into projects(project_description) values ('年度积分');
# insert into projects(project_description) values ('已签协议');
# insert into projects(project_description) values ('就业专业相关度');
# insert into projects(project_description) values ('参加招聘会次数');
# insert into projects(project_description) values ('成功应聘');
# insert into projects(project_description) values ('出勤次数');
# insert into projects(project_description) values ('假期实践作业完成情况');
# insert into projects(project_description) values ('参加学院组织其他实践活动次数（罗列）');
# insert into projects(project_description) values ('参加勤工助学');
# insert into projects(project_description) values ('申请创业，提交可行的策划方案');
# insert into projects(project_description) values ('成功创业，开办公司');
# insert into projects(project_description) values ('参加院级创新创业比赛');
# insert into projects(project_description) values ('获得院级奖励');
# insert into projects(project_description) values ('获得校级奖励');
# insert into projects(project_description) values ('获得省级奖励');
# insert into projects(project_description) values ('参加创新创业培训次数');

#插入detail表
# insert into details values (1,1,1,1,5,4,2);
# insert into details values (1,1,1,2,1,1,1);
# insert into details values (1,1,1,3,80,70,60);
# insert into details values (3,1,3,13,60,55,50);
# insert into details values (3,1,3,14,20,15,15);

insert into relations_q_and_p values (1,1);
insert into relations_q_and_p values (1,2);
insert into relations_q_and_p values (1,3);




　









