package DAO;

import BusinessEntity.Empleado;
import java.sql.*;
import java.util.*;

public class EmpleadoDAO {
    private Connection connection;

    public EmpleadoDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertar(Empleado e) throws SQLException {
        String sql = "INSERT INTO Empleado (id, nombre, cargo) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getNombre());
            stmt.setString(3, e.getCargo());
            stmt.executeUpdate();
        }
    }

    public List<Empleado> listar() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empleado e = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("cargo")
                );
                lista.add(e);
            }
        }
        return lista;
    }

    public void actualizar(Empleado e) throws SQLException {
        String sql = "UPDATE Empleado SET nombre = ?, cargo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getCargo());
            stmt.setInt(3, e.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Empleado WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
