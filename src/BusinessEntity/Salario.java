package BusinessEntity;

public class Salario {
    private int id;
    private int empleadoId;
    private double monto;

    public Salario(int id, int empleadoId, double monto) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.monto = monto;
    }

    public int getId() { return id; }
    public int getEmpleadoId() { return empleadoId; }
    public double getMonto() { return monto; }

    public void setId(int id) { this.id = id; }
    public void setEmpleadoId(int empleadoId) { this.empleadoId = empleadoId; }
    public void setMonto(double monto) { this.monto = monto; }
}
