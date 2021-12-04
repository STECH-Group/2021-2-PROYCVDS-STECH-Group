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
	category varchar(50) references categories(name) on delete set null on update cascade,
	name varchar(80) references users(name) on delete set null on update cascade,
	description varchar(400) not null,
	urgency int not null,
	creation_Date Date not null,
	state varchar(10) not null,
	modify_Date Date not null
 );
 
 create sequence id_Offers;
 
create table if not exists OFFERS( 
	id int primary key,
	category varchar(50) references categories(name) on delete set null on update cascade,
	name varchar(80) references users(name) on delete set null on update cascade,
	description varchar(400) not null,
	creation_Date Date not null,
	state varchar(10) not null,
	modify_Date Date not null
 );
 
 create sequence id_Answers_Needs;
 
create table if not exists answers_needs( 
	id int primary key,
	name varchar(80) references users(name) on delete set null on update cascade,
	response varchar(400) not null,
	creation_Date Date not null,
	need int references needs(id) on delete set null on update cascade
 );
 
 create sequence id_Answers_Offers;

create table if not exists answers_offers( 
	id int primary key,
	name varchar(80) references users(name) on delete set null on update cascade,
	response varchar(400) not null,
	creation_Date Date not null,
	offer int references offers(id) on delete set null on update cascade
 );
 
insert into users(user_name, name, mail, passwd, rol) values ('jose', 'José Gamboa', 'administrador@hotmail.com', 'b20b0f63ce2ed361e8845d6bf2e59811aaa06ec96bcdb92f9bc0c5a25e83c9a6', 'Administrador');
insert into users(user_name, name, mail, passwd, rol) values ('zuly', 'Zuly Vargas', 'profesor@hotmail.com', '48a8d9ca65d4ffed5d24d09cde13ef76320e7d4ebf468bcfcb5c4a17f87785a9', 'Profesor');
insert into users(user_name, name, mail, passwd, rol) values ('camilo', 'Camilo Pichimata', 'estudiante@hotmail.com', 'b45513fe304c65eb8a8fede7855c766223895d895457f1d5c3080f1cfea517b2', 'Estudiante');
insert into users(user_name, name, mail, passwd, rol) values ('cristian', 'Cristian Forero', 'egresado@hotmail.com', '021ba6da08ba4219338399dc758cdbb4d871cadb91bf46dc78dfbece449e90f8', 'Egresado');
insert into users(user_name, name, mail, passwd, rol) values ('oscar', 'Oscar Ospina', 'administrativo@hotmail.com', '5be08197828915431445b8dbab6181b751dc3aab4b9f50fea0bd604187665bef', 'Administrativo');

insert into categories(id, name, description, creation_date, state, modify_date) values (nextval('id_Categories'), 'Laboratorios', 'Implementos de seguridad para practicas de laboratorio', current_date, 'Activo', current_date);
insert into categories(id, name, description, creation_date, state, modify_date) values (nextval('id_Categories'), 'Electronica', 'Implmentos de electronica', current_date, 'Activo', current_date);
insert into categories(id, name, description, creation_date, state, modify_date) values (nextval('id_Categories'), 'Textos', 'Libros, guias, manuales, etc. para clases teoricas', current_date, 'Inactivo', current_date);
insert into categories(id, name, description, creation_date, state, modify_date) values (nextval('id_Categories'), 'Deportes', 'Equipo de practica para los integrantes de los equipos de la Escuela', current_date, 'Activo', current_date);
insert into categories(id, name, description, creation_date, state, modify_date) values (nextval('id_Categories'), 'Expresión Gráfica', 'Instrumentos de dibujo para EGR', current_date, 'Inactivo', current_date);

insert into needs(id, category, name, description, urgency, creation_date, state, modify_date) values (nextval('id_Needs'), 'Textos', 'Camilo Pichimata', 'Necesito texto para la clase de precalculo', 4, current_date, 'Activo', current_date);
insert into needs(id, category, name, description, urgency, creation_date, state, modify_date) values (nextval('id_Needs'), 'Deportes', 'Zuly Vargas', 'Necesito raqueta de segunda en buen estado', 2, current_date, 'Activo', current_date);
insert into needs(id, category, name, description, urgency, creation_date, state, modify_date) values (nextval('id_Needs'), 'Expresión Gráfica', 'José Gamboa', 'Necesito tabla de dibujo para la clase', 5, current_date, 'Activo', current_date);
insert into needs(id, category, name, description, urgency, creation_date, state, modify_date) values (nextval('id_Needs'), 'Expresión Gráfica', 'Cristian Forero', 'Necesito escuadra de 45 grados', 1, current_date, 'Inactivo', current_date);
insert into needs(id, category, name, description, urgency, creation_date, state, modify_date) values (nextval('id_Needs'), 'Textos', 'Zuly Vargas', 'Necesito libro de física mecánica', 4, current_date, 'Inactivo', current_date);
insert into needs(id, category, name, description, urgency, creation_date, state, modify_date) values (nextval('id_Needs'), 'Textos', 'José Gamboa', 'Necesito texto de álgebra', 2, current_date, 'En proceso', current_date);

insert into offers(id, category, name, description, creation_date, state, modify_date) values (nextval('id_Offers'), 'Textos', 'Zuly Vargas', 'Ofrezco libro de álgebra lineal', current_date, 'Activo', current_date);
insert into offers(id, category, name, description, creation_date, state, modify_date) values (nextval('id_Offers'), 'Deportes', 'José Gamboa', 'Ofrezco balón de futbol barato', current_date, 'Inactivo', current_date);
insert into offers(id, category, name, description, creation_date, state, modify_date) values (nextval('id_Offers'), 'Deportes', 'Cristian Forero', 'Ofrezco esferos ¡Buen precio!', current_date, 'Activo', current_date);
insert into offers(id, category, name, description, creation_date, state, modify_date) values (nextval('id_Offers'), 'Deportes', 'Zuly Vargas', 'Facilito la adquisición de Brownies Veganos', current_date, 'Inactivo', current_date);
insert into offers(id, category, name, description, creation_date, state, modify_date) values (nextval('id_Offers'), 'Expresión Gráfica', 'Camilo Pichimata', 'Ofrezco tabla de expreción gráfica', current_date, 'En proceso', current_date);
insert into offers(id, category, name, description, creation_date, state, modify_date) values (nextval('id_Offers'), 'Textos', 'Camilo Pichimata', 'Ofrezco texto de Aprendiendo a proframar desde 0', current_date, 'Inactivo', current_date);