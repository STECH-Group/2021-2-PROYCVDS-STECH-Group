create table if not exists USERS( 
	user_name varchar(40) primary key,
	name varchar(50) not null,
	mail varchar(80) unique not null,
	passwd varchar(70) not null,
	rol varchar(20) not null
 );
 
 create sequence id_Categories;

create table if not exists CATEGORIES(
	ID int primary key,
	name varchar(50) unique not null,
	description varchar(400) not null,
	creation_date Date not null,
	state varchar(10) not null,
	modify_date Date not null
);

create sequence id_Needs;

create table if not exists NEEDS( 
	id int primary key,
	category varchar(50) references categories(name) not null,
	name varchar(80) not null,
	description varchar(400) not null,
	urgency int not null,
	creation_date Date not null,
	state varchar(10) not null,
	modify_date Date not null
 );