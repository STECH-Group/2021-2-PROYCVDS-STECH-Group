create table if not exists USERS( 
	userName varchar(100) primary key,
	name varchar(200) not null,
	mail varchar(150) not null,
	passwd varchar(100) not null,
	rol varchar(50) not null
 );

create table if not exists CATEGORIES(
	ID int primary key,
	name varchar(50) unique not null,
	description varchar(400) not null,
	creationDate Date not null,
	state boolean not null,
	modifyDate Date not null
);