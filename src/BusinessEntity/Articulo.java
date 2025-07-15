package BusinessEntity;

public class Articulo {
    private int id;
    private int nombre;
    private int cantidad;
    private double precio;

    public Articulo() {}

    public Articulo(int id, int nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNombre() { return nombre; }
    public void setNombre(int nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}

