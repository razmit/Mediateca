package beans;

import java.util.Date;

/**
 *
 * @author Sofía
 */
public class Prestamo {

    private int id;
    private int idUsuario;
    private String idEjemplar;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo() {

    }

    public Prestamo(int id, int idUsuario, String idEjemplar, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEjemplar = idEjemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamos{" + "id=" + id + ", idUsuario=" + idUsuario + ", idEjemplar=" + idEjemplar + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
    }

}
