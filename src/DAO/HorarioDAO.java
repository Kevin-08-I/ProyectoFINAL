package DAO;

import BusinessEntity.Horario;
import java.sql.*;
import java.util.*;

public class HorarioDAO {
    private Connection connection;

    public HorarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertar(Horario h) throws SQLException {
        String sql = "INSERT INTO Horario (id, empleadoId, fecha, horaEntrada, horaSalida) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, h.getId());
            stmt.setInt(2, h.getEmpleadoId());
            stmt.setDate(3, h.getFecha());
            stmt.setTime(4, h.getHoraEntrada());
            stmt.setTime(5, h.getHoraSalida());
            stmt.executeUpdate();
        }
    }

    public List<Horario> listar() throws SQLException {
        List<Horario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Horario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Horario h = new Horario(
                    rs.getInt("id"),
                    rs.getInt("empleadoId"),
                    rs.getDate("fecha"),
                    rs.getTime("horaEntrada"),
                    rs.getTime("horaSalida")
                );
                lista.add(h);
            }
        }
        return lista;
    }

    public void actualizar(Horario h) throws SQLException {
        String sql = "UPDATE Horario SET empleadoId = ?, fecha = ?, horaEntrada = ?, horaSalida = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, h.getEmpleadoId());
            stmt.setDate(2, h.getFecha());
            stmt.setTime(3, h.getHoraEntrada());
            stmt.setTime(4, h.getHoraSalida());
            stmt.setInt(5, h.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Horario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
