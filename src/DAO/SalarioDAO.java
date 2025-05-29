package DAO;

import BusinessEntity.Salario;
import java.sql.*;
import java.util.*;

public class SalarioDAO {
    private Connection connection;

    public SalarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertar(Salario s) throws SQLException {
        String sql = "INSERT INTO Salario (id, empleadoId, monto) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, s.getId());
            stmt.setInt(2, s.getEmpleadoId());
            stmt.setDouble(3, s.getMonto());
            stmt.executeUpdate();
        }
    }

    public List<Salario> listar() throws SQLException {
        List<Salario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Salario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Salario s = new Salario(
                    rs.getInt("id"),
                    rs.getInt("empleadoId"),
                    rs.getDouble("monto")
                );
                lista.add(s);
            }
        }
        return lista;
    }

    public void actualizar(Salario s) throws SQLException {
        String sql = "UPDATE Salario SET empleadoId = ?, monto = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, s.getEmpleadoId());
            stmt.setDouble(2, s.getMonto());
            stmt.setInt(3, s.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Salario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
