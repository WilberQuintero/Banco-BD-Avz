create database Avance1BD;                   -- Wilber Valdez Quintero  247180  -   Jonathan Obieth Astorga Amaya  245791

use Avance1BD;

 -- drop database Avance1BD;


create table Direcciones (
direccion_id int primary key auto_increment,
calle varchar (100) not null,
colonia varchar (100) not null,
numero varchar (100) not null
);


create table Usuarios (
usuario_id int primary key auto_increment,
nombreUsuario varchar (30) not null unique ,
contra varchar (500) not null
);


create table Clientes (
cliente_id int primary key auto_increment,
nombre varchar (100) not null,
apellidoPaterno varchar (100) not null,
apellidoMaterno varchar (100) default "N/D",
fechaNaci date not null,
direccion_id int,
usuario_id int,
foreign key (direccion_id) references Direcciones (direccion_id),
foreign key (usuario_id) references Usuarios (usuario_id)
);


create table Cuentas(
cuenta_id int primary key auto_increment,
numeroCuenta varchar (16) not null unique,
fechaApertura date not null,
saldo decimal (18, 2) not null default 0,
estado enum ("Activa","Cancelada") not null default "Activa",
cliente_id int ,
foreign key (cliente_id) references Clientes (cliente_id)
); 


create table Transferencias (
transaccion_id int primary key auto_increment,
cuentaDestino varchar (100) not null,
monto int not null,
fecha date not null,
cuenta_id int,
foreign key (cuenta_id) references Cuentas (cuenta_id)
);

create table RetirosSinCuenta (
transaccion_id int primary key auto_increment,
folio int not null default 0,
monto int not null,
contra varchar (100) not null,
fecha datetime not null,
fechaFin dateTime not null,
estado enum ("Cobrado","No cobrado") not null default "No cobrado",
cuenta_id int,
foreign key (cuenta_id) references Cuentas (cuenta_id)
);
 


insert into retirossincuenta (monto, cuenta_id) values(100, 1);
 -- drop database avance1bd;

