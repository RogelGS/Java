--CREATE DATABASE Personal;
--USE Personal;

CREATE TABLE Usuario(
	Usuario varchar(20) PRIMARY KEY,
	Contrasena varchar(50),
	Foto image,
	Estado char(1)
);

CREATE TABLE Cliente(
	ClienteID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	Nombre varchar(250) NOT NULL,
	RFC varchar(13),
	Telefono varchar(10),
	Correo varchar(600)
);

CREATE TABLE Piso(
	PisoID varchar(50) PRIMARY KEY NOT NULL
);

CREATE TABLE Categoria(
	CategoriaID varchar(75) PRIMARY KEY NOT NULL
);

CREATE TABLE Habitacion(
	HabitacionID varchar(200) PRIMARY KEY NOT NULL,
	PisoID varchar(50) NOT NULL,
	CategoriaID varchar(75) NOT NULL,
	PrecioHora money,
	PrecioDia money,
	Caracteristicas text,
	Estado char(1),
	FOREIGN KEY (PisoID) REFERENCES Piso(PisoID),
	FOREIGN KEY (CategoriaID) REFERENCES Categoria(CategoriaID)
);

CREATE TABLE Reservacion(
	ReservacionID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	HabitacionID varchar(200) NOT NULL,
	ClienteID varchar(250) NOT NULL,
	FechaIngreso date NOT NULL,
	FechaSalida date NOT NULL,
	Estado char(1) NOT NULL,
	FOREIGN KEY (HabitacionID) REFERENCES Habitacion(HabitacionID)
);
--INSERT INTO Prueba(Fecha) VALUES('2020/05/23');

CREATE TABLE Cobro(
	ReservacionID int,

);