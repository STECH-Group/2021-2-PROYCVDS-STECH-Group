create table if not exists USERS( 
	user_Name varchar(100) primary key,
	name varchar(200) not null,
	mail varchar(150) unique not null,
	passwd varchar(100) not null,
	rol varchar(50) not null
 );

create table if not exists CATEGORIES(
	ID int primary key auto_increment,
	name varchar(50) unique not null,
	description varchar(400) not null,
	creation_Date Date not null,
	state boolean not null,
	modify_Date Date not null
);