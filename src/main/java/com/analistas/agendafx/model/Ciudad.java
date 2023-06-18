package com.analistas.agendafx.model;

/**
 *
 * @author RVRN2
 */
public class Ciudad {

    private int id;
    private String nombre;
    private String cpa;
    private Provincia provincia;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, String cpa, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.cpa = cpa;
        this.provincia = provincia;
    }

    public String getCpa() {
        return cpa;
    }

    public void setCpa(String cpa) {
        this.cpa = cpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return cpa + " - " + nombre + "/" + provincia.getNombre();
    }

}
