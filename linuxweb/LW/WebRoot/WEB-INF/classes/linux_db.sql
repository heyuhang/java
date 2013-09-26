create database xiyou_linux_db;

use xiyou_linux_db;


create table user(
    id          bigint          primary key auto_increment,
    name        varchar(20)     not null,
    username    varchar(20)      not null,
    password    varchar(20)      not null,
    email       varchar(50)      not null,
    interest    varchar(20)      not null,
    introduct   varchar(50)      not null,
    headpath    varchar(200)     default '/head/linux.jpg',
    state       integer           not null
)type=innodb default charset utf8; 

create table attention(
	id         bigint          primary key auto_increment,
	fromid     bigint          not null,
	toid       bigint          not null,
	ationtime  varchar(20)     not null,
	isnew	   int             not null, 
	index       from_id(fromid), 
	foreign key (fromid) references user(id) on delete cascade 
)type=innodb default charset utf8; 

create table  files(
   id          bigint          primary key auto_increment,
   userid      bigint          not null,
   title       varchar(50)      not null,
   label       varchar(50)      not null,
   introduct   varchar(400)     not null,
   uploadtime  varchar(20)      not null,
   filepath    varchar(300)     not null,
   approve     bigint          not null,
   commentno   bigint          not null, 
   toptime     varchar(20)     null,
   index       user_id(userid),  
   foreign key (userid) references user(id) on delete cascade 
)type=innodb default charset utf8; 

create table  qa(
   id          bigint          primary key auto_increment,
   userid      bigint          not null,
   label       varchar(50)      not null,
   question   varchar(400)     not null,
   uploadtime  varchar(20)      not null,
   approve     bigint          not null,
   anserno   bigint          not null, 
   toptime     varchar(20)     null,
   index       user_id(userid),  
   foreign key (userid) references user(id) on delete cascade 
)type=innodb default charset utf8; 

create table answer(
   id          bigint          primary key auto_increment,
   qaid      bigint          not null, 
   fromid      bigint          not null,
   answer     varchar(400)     not null,
   answertime  varchar(20)      not null,
   approve      bigint          not null,
   index       qa_id(qaid), 
   foreign key (qaid) references qa(id) on delete cascade 
)type=innodb default charset utf8;

create table comment(
   id          bigint          primary key auto_increment,
   fileid      bigint          not null, 
   fromid      bigint          not null,
   toid        bigint          not null,
   content     varchar(100)     not null,
   commentime  varchar(20)      not null,
   index       file_id(fileid), 
   foreign key (fileid) references files(id) on delete cascade 
)type=innodb default charset utf8;

create table replay(
   id          bigint          primary key auto_increment,
   fileid      bigint          not null, 
   fromid      bigint          not null,
   toid        bigint          not null,
   content     varchar(100)    not null,
   index       file_id(fileid), 
   foreign key (fileid) references files(id) on delete cascade 
)type=innodb default charset utf8;  
 
create table labels(
   id          bigint          primary key auto_increment,
   number      bigint          not null,
   title       varchar(50)      not null	
)type=innodb default charset utf8; 

/*
*attention关注表
*comment评论表
*replay回复表
*qa 问答表
*answer 回答字段表
*files为讲座字段表
*/