package edu.ic4302.model;


public class Producto {
    private long id;
    private String nombre;
    private String medida;
    private long id_tipo;

    public Producto() {

    }

    public Producto(String nombre, String medida, long id_tipo) {
        this.nombre = nombre;
        this.medida = medida;
        this.id_tipo = id_tipo;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }
}