package DAO;

import BusinessEntity.Articulo;
import java.sql.*;
import java.util.ArrayList;

public class ArticuloDAO {
    private Connection conn;

    public ArticuloDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Articulo a) {
        String sql = "INSERT INTO Articulo (nombre, cantidad, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, a.getNombre());
            stmt.setInt(2, a.getCantidad());
            stmt.setDouble(3, a.getPrecio());
            stmt.executeUpdate();
            System.out.println("Articulo insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar artículo: " + e.getMessage());
        }
    }

    public ArrayList<Articulo> listar() {
        ArrayList<Articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Articulo";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Articulo a = new Articulo(
                    rs.getInt("id"),
                    rs.getInt("nombre"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar articulos: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Articulo a) {
        String sql = "UPDATE Articulo SET nombre=?, cantidad=?, precio=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, a.getNombre());
            stmt.setInt(2, a.getCantidad());
            stmt.setDouble(3, a.getPrecio());
            stmt.setInt(4, a.getId());
            stmt.executeUpdate();
            System.out.println("ArtIculo actualizado.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar articulo: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Articulo WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("ArtIculo eliminado.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar artIculo: " + e.getMessage());
        }
    }
}
