create database BD_HerreraVillacorta_CesarHumberto;
use BD_HerreraVillacorta_CesarHumberto;

create table tb_marca(
cod_mar int primary key auto_increment,
nom_mar varchar(20),
cat_mar varchar(50)
);

insert into tb_marca values (1, 'Samsung', 'Tecnologia');
insert into tb_marca values (2, 'HP', 'Tecnologia');
insert into tb_marca values (3, 'Sony', 'Tecnologia');

create table tb_pais(
cod_pais int primary key auto_increment,
nom_pais varchar(20),
cont_pais varchar(15)
);

insert into tb_pais values (1, 'Corea', 'Asia');
insert into tb_pais values (2, 'USA', 'Norte America');
insert into tb_pais values (3, 'Japon', 'Asia');

create table tb_producto(
cod_pro int primary key auto_increment,
des_pro varchar(30),
pre_pro float,
stock_pro int,
cod_mar int references tb_marca,
cod_pais int references tb_pais
);

insert into tb_producto values (1, 'Televisor UHD 49', 2000, 20, 1, 1);
insert into tb_producto values (2, 'Impresora F4180', 700, 40, 2, 2);
insert into tb_producto values (3, 'Equipo de Sonido 500W', 500, 50, 3, 3);
insert into tb_producto values (4, 'Monitor Gaming', 2500, 30, 3, 3);

select * from tb_marca;
select * from tb_pais;
select * from tb_producto;

select p.cod_pro, p.des_pro, p.pre_pro, p.stock_pro, m.nom_mar, pa.nom_pais
from tb_producto p
inner join tb_marca m on p.cod_mar = m.cod_mar
inner join tb_pais pa on p.cod_pais = pa.cod_pais;