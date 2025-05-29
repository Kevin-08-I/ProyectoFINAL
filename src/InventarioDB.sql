CREATE DATABASE IF NOT EXISTS InventarioDB;
USE InventarioDB;

CREATE TABLE IF NOT EXISTS Empleado (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Horario (
    id INT PRIMARY KEY,
    empleadoId INT NOT NULL,
    fecha DATE NOT NULL,
    horaEntrada TIME NOT NULL,
    horaSalida TIME NOT NULL,
    FOREIGN KEY (empleadoId) REFERENCES Empleado(id)
);

CREATE TABLE IF NOT EXISTS Salario (
    id INT PRIMARY KEY,
    empleadoId INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (empleadoId) REFERENCES Empleado(id)
);

CREATE TABLE IF NOT EXISTS Articulo (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS ProductoVendido (
    id INT PRIMARY KEY,
    articuloId INT NOT NULL,
    cantidadVendida INT NOT NULL,
    empleadoId INT NOT NULL,
    FOREIGN KEY (articuloId) REFERENCES Articulo(id),
    FOREIGN KEY (empleadoId) REFERENCES Empleado(id)
);
