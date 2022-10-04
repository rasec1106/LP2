use cibertec_t4nj;

drop table if exists tb_proveedor;
create table tb_proveedor(
	codigo int primary key auto_increment NOT NULL,
    razonSocial varchar(100) NOT NULL,
    ruc char(11) NOT NULL,
    direccion varchar(200) NOT NULL,
    dni char(8) NOT NULL,
    nombre varchar(50) NOT NULL,
    celular char(9) NOT NULL,
    fecNacimiento date NOT NULL   
);

insert into tb_proveedor values(1,'Lima Service SAC','12345678901','Av. Garcia Marquez 444','46735299','Jose Martinez Camacho','930674433','1988-05-13');
insert into tb_proveedor values(2,'Supermercado La Tiendita','09879067532','Calle Tupac Amaru 56','98007352','Cesar Herrera Villacorta','978553022','1990-11-23');
insert into tb_proveedor values(3,'TrueServices L.A.','99362845637','Av. Turing 980','24536780','Liliana Moya Garcia','980336722','1994-01-19');

select * from tb_proveedor;