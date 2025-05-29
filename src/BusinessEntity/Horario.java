package BusinessEntity;

import java.sql.Time;
import java.sql.Date;

public class Horario {
    private int id;
    private int empleadoId;
    private Date fecha;
    private Time horaEntrada;
    private Time horaSalida;

    public Horario(int id, int empleadoId, Date fecha, Time horaEntrada, Time horaSalida) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public int getId() { return id; }
    public int getEmpleadoId() { return empleadoId; }
    public Date getFecha() { return fecha; }
    public Time getHoraEntrada() { return horaEntrada; }
    public Time getHoraSalida() { return horaSalida; }

    public void setId(int id) { this.id = id; }
    public void setEmpleadoId(int empleadoId) { this.empleadoId = empleadoId; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setHoraEntrada(Time horaEntrada) { this.horaEntrada = horaEntrada; }
    public void setHoraSalida(Time horaSalida) { this.horaSalida = horaSalida; }
}
