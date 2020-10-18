package edu.ic4302.model;
import java.util.Date;
public class Compra {

    private long id;
    Date fecha;
    private long id_proveedor;

    public Compra() {
    }

    public Compra(Date fecha, long id_proveedor) {
        this.fecha = fecha;
        this.id_proveedor = id_proveedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}
