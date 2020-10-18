package edu.ic4302.model;


public class Proveedor {


    private long id;
    private String nombre;
    private String direccion;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(String nombre, String direccion, String telefono) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
    }
}
