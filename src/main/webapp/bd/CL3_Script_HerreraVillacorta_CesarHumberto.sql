drop database if exists BD_HerreraVillacorta_CesarHumberto_CL3;
create database BD_HerreraVillacorta_CesarHumberto_CL3;
use BD_HerreraVillacorta_CesarHumberto_CL3;

drop table if exists tb_universidad;
create table tb_universidad(
cod_universidad 	int primary key auto_increment,
nom_universidad 	varchar(25)
);

insert into tb_universidad values (1, 'PUCP');
insert into tb_universidad values (2, 'UNMSM');
insert into tb_universidad values (3, 'UPC');
insert into tb_universidad values (4, 'UTP');
insert into tb_universidad values (5, 'Cibertec');
insert into tb_universidad values (6, 'UNI');
insert into tb_universidad values (7, 'UPN');

drop table if exists tb_especialidad;
create table tb_especialidad(
cod_especialidad 	int primary key auto_increment,
nom_especialidad 	varchar(20)
);

insert into tb_especialidad values (1, 'Ing. De Sistemas');
insert into tb_especialidad values (2, 'Ing. De Software');
insert into tb_especialidad values (3, 'Ing. Alimentaria');
insert into tb_especialidad values (4, 'Ing. Industrial');
insert into tb_especialidad values (5, 'Ing. De Minas');


drop table if exists tb_ingeniero;
create table tb_ingeniero(
cod_ingeniero	     int primary key auto_increment,
nom_ingeniero 	     varchar(25),
ape_ingeniero 	     varchar(25),
-- dni_ingeniero 	     int,
/*****************************************************************
 *	en el modelo del examen se indica que el dni es de tipo INT
 *	sin embargo preferimos que sea de tipo char(8)
 *****************************************************************/
dni_ingeniero 	     char(8),
sueldo               double,
cod_universidad	     int references tb_universidad,
cod_especialidad	 int references tb_especialidad
);

insert into tb_ingeniero values (1, 'Cesar Humberto', 'Herrera Villacorta', '46656049', 5600, 1, 1);
insert into tb_ingeniero values (2, 'Mark', 'Zuckerberg', '12345678', 10000, 5, 1);
insert into tb_ingeniero values (3, 'Steve', 'Jobs', '11223344',12000, 1, 1);
insert into tb_ingeniero values (4, 'Vanessa Lisett', 'Herrera Villacorta', '98674533', 2300, 2, 3);
insert into tb_ingeniero values (5, 'Lionel', 'Messi', '09876543', 7400, 6, 4);
