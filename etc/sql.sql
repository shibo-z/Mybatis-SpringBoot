create database users CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use users;

create table tb_users(
`id` BIGINT primary key AUTO_INCREMENT,
`user_name` varchar(50) not NULL,
`gender` varchar(1) not null COMMENT '男：1 ; 女：0',
`age` int(3) not null,
`phone` varchar(11) not null default '',
`created_by` varchar(32)     NOT NULL DEFAULT '' COMMENT '创建人',
`created_at` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_by` varchar(32)     NOT NULL DEFAULT '' COMMENT '更新人',
`updated_at` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);

insert into tb_users values
(default,'张三','1',18,'13193594444','admin',NOW(),'admin',NOW()),
(default,'李四','1',18,'15946482456','admin',NOW(),'admin',NOW()),
(default,'王舞','0',250,'13939359666','admin',NOW(),'admin',NOW());

insert into tb_users values(default,'王富贵',1,20,'13193594444','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'王权',1,20,'13193594444','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'闫雪婷',0,20,'13194563454','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'王富贵',1,18,'13196349444','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'王琳',0,29,'13193852644','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'东方月初',1,20,'13193594526','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'孙悟空',1,20,'13193597586','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'阿卡丽',0,20,'13193591486','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'猪八戒',1,20,'13193594715','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'唐僧',1,20,'13193591652','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'如来',1,20,'13936578681','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'薛仁贵',1,20,'13193591358','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'观音',0,20,'13193591655','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'白骨精',0,20,'13193598415','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'青钢影',0,20,'13193168245','admin',NOW(),'admin',NOW());
insert into tb_users values(default,'赤红之瞳',0,20,'1319359375','admin',NOW(),'admin',NOW());
