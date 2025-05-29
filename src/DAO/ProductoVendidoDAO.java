package DAO;

import BusinessEntity.ProductoVendido;
import java.sql.*;
import java.util.*;

public class ProductoVendidoDAO {
    private Connection connection;

    public ProductoVendidoDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertar(ProductoVendido pv) throws SQLException {
        String sql = "INSERT INTO ProductoVendido (id, articuloId, cantidadVendida, empleadoId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pv.getId());
            stmt.setInt(2, pv.getArticuloId());
            stmt.setInt(3, pv.getCantidadVendida());
            stmt.setInt(4, pv.getEmpleadoId());
            stmt.executeUpdate();
        }
    }

    public List<ProductoVendido> listar() throws SQLException {
        List<ProductoVendido> lista = new ArrayList<>();
        String sql = "SELECT * FROM ProductoVendido";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ProductoVendido pv = new ProductoVendido(
                    rs.getInt("id"),
                    rs.getInt("articuloId"),
                    rs.getInt("cantidadVendida"),
                    rs.getInt("empleadoId")
                );
                lista.add(pv);
            }
        }
        return lista;
    }

    public void actualizar(ProductoVendido pv) throws SQLException {
        String sql = "UPDATE ProductoVendido SET articuloId = ?, cantidadVendida = ?, empleadoId = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pv.getArticuloId());
            stmt.setInt(2, pv.getCantidadVendida());
            stmt.setInt(3, pv.getEmpleadoId());
            stmt.setInt(4, pv.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM ProductoVendido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
