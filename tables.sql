create table if not exists USERS( 
	user_name varchar(40) primary key,
	name varchar(50) unique not null,
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
	category varchar(50) references categories(name),
	name varchar(80) references users(name),
	description varchar(400) not null,
	urgency int not null,
	creation_Date Date not null,
	state varchar(10) not null,
	modify_Date Date not null
 );
 
 create sequence id_Offers;
 
 create table if not exists OFFERS( 
	id int primary key,
	category varchar(50) references categories(name),
	name varchar(80) references users(name),
	description varchar(400) not null,
	creation_Date Date not null,
	state varchar(10) not null,
	modify_Date Date not null
 );
 
 create sequence id_Answers_Needs;
 
 create table if not exists answers_needs( 
	id int primary key,
	name varchar(80) references users(name),
	response varchar(400) not null,
	creation_Date Date not null,
	need int references needs(id)
 );
 
 create sequence id_Answers_Offers;

create table if not exists answers_offers( 
	id int primary key,
	name varchar(80) references users(name),
	response varchar(400) not null,
	creation_Date Date not null,
	offer int references offers(id)
 );
 