create database transporte;
use transporte;

create table departamento(
    id_departamento int not null,
    departamento_nombre varchar(250) not null,
    primary key(id_departamento)
);

create table provincia(
    id_provincia int not null,
    provincia_nombre varchar(250) not null,
    id_departamento int not null,
    primary key(id_provincia),
    foreign key(id_departamento) references departamento(id_departamento)
);

create table distrito(
    id_distrito int not null,
    distrito_nombre varchar(250) not null,
    id_provincia int not null,
    primary key(id_distrito),
    foreign key(id_provincia) references provincia(id_provincia)
);

create table cliente(
	dni varchar(8) not null,
	nombres varchar(50) not null,
	apellidos varchar(80) not null,
	direccion varchar(100) not null,
	sexo boolean not null,
	estado_civil boolean not null,
	telefono varchar(15),
	correo_electronico varchar(60),
	nacionalidad varchar(20),
	lugar_nacimiento int not null,
	fecha_nacimiento datetime not null,
    primary key(dni),
    foreign key(lugar_nacimiento) references distrito(id_distrito)
);

create table bus(
	id_bus int auto_increment not null,
    placa varchar(8) not null,
    asientos int not null,
    primary key(id_bus)
);

create table rutas(
    id_ruta int auto_increment not null,
    partida int not null,
    destino int not null,
    precio double not null,
    primary key(id_ruta),
    foreign key(destino) references provincia(id_provincia),
    foreign key(partida) references provincia(id_provincia)
);

create table pasajes(
	id_pasaje int auto_increment not null,
    asiento varchar(5) not null,
    id_bus int not null,
    id_ruta int not null,
    fecha_partida datetime not null,
    fecha_llegada datetime not null,
    total double not null,
    divisa varchar(5) not null,
    primary key(id_pasaje),
    foreign key(id_bus) references bus(id_bus),
    foreign key(id_ruta) references rutas(id_ruta)
);
