create sequence id;

create table if not exists USERS( 
	user_Name varchar(40) primary key,
	name varchar(50) not null,
	mail varchar(80) unique not null,
	passwd varchar(70) not null,
	rol varchar(20) not null
 );

create table if not exists CATEGORIES(
	ID int primary key,
	name varchar(50) unique not null,
	description varchar(400) not null,
	creation_Date Date not null,
	state varchar(10) not null,
	modify_Date Date not null
);