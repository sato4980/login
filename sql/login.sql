drop database if exists login;
create database login;
use login;
create table users(
	username varchar(255),
	password varchar(255)
);

insert into users values("taro","123");
insert into users values("jiro","456");
insert into users values("hanako","789");
