DROP DATABASE IF EXISTS InventarioDB;
CREATE DATABASE InventarioDB;
USE InventarioDB;

CREATE TABLE Empleado (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL
);
select * from Empleado;
CREATE TABLE Horario (
    id INT PRIMARY KEY,
    empleadoId INT NOT NULL,
    fecha DATE NOT NULL,
    horaEntrada TIME NOT NULL,
    horaSalida TIME NOT NULL,
    FOREIGN KEY (empleadoId) REFERENCES Empleado(id)
);
select * from Horario;
CREATE TABLE Salario (
    id INT PRIMARY KEY,
    empleadoId INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (empleadoId) REFERENCES Empleado(id)
);
SELECT * FROM Salario;

USE inventariodb;

CREATE TABLE Articulo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);
DROP DATABASE IF EXISTS Articulo;
CREATE TABLE IF NOT EXISTS ProductoVendido (
    id INT PRIMARY KEY,
    articuloId INT NOT NULL,
    cantidadVendida INT NOT NULL,
    empleadoId INT NOT NULL,
    FOREIGN KEY (articuloId) REFERENCES Articulo(id),
    FOREIGN KEY (empleadoId) REFERENCES Empleado(id)
);

SHOW TABLES;
SELECT * FROM Articulo;
select * from Empleado;
select * from Horario;
SELECT * FROM Salario;
Select * from ProductoVendido;