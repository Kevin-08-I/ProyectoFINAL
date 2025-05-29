import BusinessEntity.*;
import DAO.*;
import Util.Conexion;
import java.sql.Date;

import java.sql.*;
import java.util.*;

public class MenuConsola {
    public static void main(String[] args) {
        try (Connection conn = Conexion.getConexion()) {
            Scanner sc = new Scanner(System.in);
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(conn);
            HorarioDAO horarioDAO = new HorarioDAO(conn);
            SalarioDAO salarioDAO = new SalarioDAO(conn);
            ProductoVendidoDAO productoDAO = new ProductoVendidoDAO(conn);

            int opcion;
            do {
                System.out.println("\n===== MENu PRINCIPAL =====");
                System.out.println("1. Gestion de Empleados");
                System.out.println("2. Gestion de Horarios");
                System.out.println("3. Gestion de Salarios");
                System.out.println("4. Gestion de Productos Vendidos");
                System.out.println("0. Salir");
                System.out.print("Opcion: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> menuEmpleado(sc, empleadoDAO);
                    case 2 -> menuHorario(sc, horarioDAO);
                    case 3 -> menuSalario(sc, salarioDAO);
                    case 4 -> menuProductoVendido(sc, productoDAO);
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opcion inválida.");
                }

            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }

    // ================== Submenús ==================

    private static void menuEmpleado(Scanner sc, EmpleadoDAO dao) throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- MENU EMPLEADO ---");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    dao.insertar(new Empleado(id, nombre, cargo));
                }
                case 2 -> {
                    for (Empleado e : dao.listar()) {
                        System.out.printf("ID: %d | Nombre: %s | Cargo: %s\n", e.getId(), e.getNombre(), e.getCargo());
                    }
                }
                case 3 -> {
                    System.out.print("ID a actualizar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nuevo cargo: ");
                    String cargo = sc.nextLine();
                    dao.actualizar(new Empleado(id, nombre, cargo));
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminar(id);
                }
                case 0 -> {}
                default -> System.out.println("Opcion inválida.");
            }
        } while (opcion != 0);
    }

    private static void menuHorario(Scanner sc, HorarioDAO dao) throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- MENu HORARIO ---");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Empleado ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    Date fecha = Date.valueOf(sc.nextLine());
                    System.out.print("Hora Entrada (HH:MM:SS): ");
                    Time entrada = Time.valueOf(sc.nextLine());
                    System.out.print("Hora Salida (HH:MM:SS): ");
                    Time salida = Time.valueOf(sc.nextLine());
                    dao.insertar(new Horario(id, empId, fecha, entrada, salida));
                }
                case 2 -> {
                    for (Horario h : dao.listar()) {
                        System.out.printf("ID: %d | Empleado: %d | Fecha: %s | Entrada: %s | Salida: %s\n",
                                h.getId(), h.getEmpleadoId(), h.getFecha(), h.getHoraEntrada(), h.getHoraSalida());
                    }
                }
                case 3 -> {
                    System.out.print("ID a actualizar: ");
                    int id = sc.nextInt();
                    System.out.print("Nuevo Empleado ID: ");
                    int empId = sc.nextInt(); sc.nextLine();
                    System.out.print("Nueva Fecha (YYYY-MM-DD): ");
                    Date fecha = Date.valueOf(sc.nextLine());
                    System.out.print("Nueva Hora Entrada (HH:MM:SS): ");
                    Time entrada = Time.valueOf(sc.nextLine());
                    System.out.print("Nueva Hora Salida (HH:MM:SS): ");
                    Time salida = Time.valueOf(sc.nextLine());
                    dao.actualizar(new Horario(id, empId, fecha, entrada, salida));
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminar(id);
                }
                case 0 -> {}
                default -> System.out.println("Opcion inválida.");
            }
        } while (opcion != 0);
    }

    private static void menuSalario(Scanner sc, SalarioDAO dao) throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- MENu SALARIO ---");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Empleado ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Monto: ");
                    double monto = sc.nextDouble();
                    dao.insertar(new Salario(id, empId, monto));
                }
                case 2 -> {
                    for (Salario s : dao.listar()) {
                        System.out.printf("ID: %d | Empleado: %d | Monto: %.2f\n", s.getId(), s.getEmpleadoId(), s.getMonto());
                    }
                }
                case 3 -> {
                    System.out.print("ID a actualizar: ");
                    int id = sc.nextInt();
                    System.out.print("Nuevo Empleado ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Nuevo Monto: ");
                    double monto = sc.nextDouble();
                    dao.actualizar(new Salario(id, empId, monto));
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminar(id);
                }
                case 0 -> {}
                default -> System.out.println("Opcion inválida.");
            }
        } while (opcion != 0);
    }

    private static void menuProductoVendido(Scanner sc, ProductoVendidoDAO dao) throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- MENu PRODUCTO VENDIDO ---");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("ID Artículo: ");
                    int articuloId = sc.nextInt();
                    System.out.print("Cantidad Vendida: ");
                    int cantidad = sc.nextInt();
                    System.out.print("ID Empleado: ");
                    int empleadoId = sc.nextInt();
                    dao.insertar(new ProductoVendido(id, articuloId, cantidad, empleadoId));
                }
                case 2 -> {
                    for (ProductoVendido p : dao.listar()) {
                        System.out.printf("ID: %d | Artículo: %d | Cantidad: %d | Empleado: %d\n",
                                p.getId(), p.getArticuloId(), p.getCantidadVendida(), p.getEmpleadoId());
                    }
                }
                case 3 -> {
                    System.out.print("ID a actualizar: ");
                    int id = sc.nextInt();
                    System.out.print("Nuevo ID Artículo: ");
                    int articuloId = sc.nextInt();
                    System.out.print("Nueva Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Nuevo ID Empleado: ");
                    int empleadoId = sc.nextInt();
                    dao.actualizar(new ProductoVendido(id, articuloId, cantidad, empleadoId));
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminar(id);
                }
                case 0 -> {}
                default -> System.out.println("Opcion inválida.");
            }
        } while (opcion != 0);
    }
}
