package BusinessEntity;

public class ProductoVendido {
    private int id;
    private int articuloId;
    private int cantidadVendida;
    private int empleadoId;

    public ProductoVendido(int id, int articuloId, int cantidadVendida, int empleadoId) {
        this.id = id;
        this.articuloId = articuloId;
        this.cantidadVendida = cantidadVendida;
        this.empleadoId = empleadoId;
    }

    public ProductoVendido(int id, String articuloP, int cantidad, int empleadoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() { return id; }
    public int getArticuloId() { return articuloId; }
    public int getCantidadVendida() { return cantidadVendida; }
    public int getEmpleadoId() { return empleadoId; }

    public void setId(int id) { this.id = id; }
    public void setArticuloId(int articuloId) { this.articuloId = articuloId; }
    public void setCantidadVendida(int cantidadVendida) { this.cantidadVendida = cantidadVendida; }
    public void setEmpleadoId(int empleadoId) { this.empleadoId = empleadoId; }
}
