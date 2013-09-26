create database base;

use base;


create table resource(
	id int primary key auto_increment,
	rescode int,
	resname varchar(50),
	redescription varchar(100),
	ctime varchar(20),
	state int
)engine=InnoDB;

create table section(
	id int primary key auto_increment,
	sename varchar(50),
	seleader varchar(30),
	sedescription varchar(200),
	state int	
)engine=InnoDB;

create table goodssort(
	id int primary key auto_increment,
	sortname varchar(20),
	sortgrade int,
	sortfather varchar(20),
	state int	
)engine=InnoDB default charset=utf8;

create table goodsbrand(
	id int primary key auto_increment,
	brname varchar(50),
	brdescription varchar(200)
)engine=InnoDB;

create table goods(
	id int primary key auto_increment,
	gname varchar(50),
	gcode varchar(100),
	sortid 	int,
	sort    varchar(20),
	brandid int,
	brand   varchar(50),
	marker varchar(50),
	limitvalue int,
	gdescription varchar(200),
	ctime varchar(20),
	state int,
	index       sort_id(sortid), 
	index       brand_id(brandid),
	foreign key (sortid) references goodssort(id) on delete cascade,
	foreign key (brandid) references goodsbrand(id) on delete cascade 
)engine=InnoDB;

create table supplier(
	id int primary key auto_increment,
	suname varchar(50),
	sucity varchar(30),
	saddress varchar(200),
	spost varchar(10),
	sphone varchar(20),
	slpeople varchar(20),
	state int	
)engine=InnoDB;
 
create table client(
	id int primary key auto_increment,
	cname varchar(100),
	ccity varchar(30),
	caddress varchar(200),
	cpost varchar(10),
	cphone varchar(20),
	clpeople varchar(20),
	state int	
)engine=InnoDB;

create table shelf(
	id int primary key auto_increment,
	shname varchar(50),
	shdescription varchar(200),
	state int
)engine=InnoDB;

create table buser(
	id int primary key auto_increment,
	username varchar(20),
	password varchar(20),
	usertype varchar(20),
	sectionid int,
	sectionname varchar(50),
	email varchar(100),
	ctime varchar(30),
	otime varchar(30),
	state int,
	power varchar(15),
	index       section_id(sectionid),
	foreign key (sectionid) references section(id) on delete cascade
)engine=InnoDB;

create table stockin(
	id int primary key auto_increment,
	num           varchar(100) not null,
	stockindate varchar(20) not null,
	stockintype varchar(20) not null,
	batchno     int not null,
	createby    varchar(20) not null,
	createtime  varchar(20) not null,
	vendor      varchar(50) not null,
	state       int not null,
	goods       varchar(50) not null,
	shelf       varchar(50) not null,
	number      int not null,
	remark      varchar(100)
)engine=InnoDB;

create table stockout(
	id int   primary key auto_increment,
	num          varchar(100) not null,
	stockouttype varchar(20) not null,
	createby    varchar(20) not null,
	createtime  varchar(20) not null,
	stockoutdate varchar(20) not null,
	vendor      varchar(50) not null,
	remark      varchar(100) not null,
	state      int not null,
	goods       varchar(50) not null,
	shelf       varchar(50) not null,
	number      int not null,
	outnum      int not null
)engine=InnoDB; 

create table deliver(
	id int  primary key auto_increment,
	num           varchar(100) not null,
	createby    varchar(20) not null,
	city        varchar(20) not null,
	deliverdate varchar(20) not null,
	createtime  varchar(20) not null,
	state       int not null,
	remark      varchar(100) not null,
	outid       varchar(100) not null,
	number      varchar(100) not null,
	vendor      varchar(50)  not null
)engine=InnoDB;

create table checks(
	id int primary key auto_increment,
	num           varchar(100) not null,
	createby    varchar(20) not null,
	shelfname       varchar(50) not null,
	checkdate   varchar(20) not null,
	createtime  varchar(20) not null,
	state       int not null,
	remark      varchar(100) not null,
	goods       varchar(500) not null,
	number      int not null,
	realnum     int not null
)engine=InnoDB;