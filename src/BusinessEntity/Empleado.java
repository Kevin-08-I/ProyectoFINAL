package BusinessEntity;

public class Empleado {
    private int id;
    private String nombre;
    private String cargo;

    public Empleado(int id, String nombre, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCargo() { return cargo; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
