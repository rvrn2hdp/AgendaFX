/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.analistas.agendafx.model;

import java.time.LocalDate;

/**
 *
 * @author RVRN2
 */
public class Contacto {

    private int id;
    private String apellido;
    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String observaciones;
    private Ciudad ciudad;

    public Contacto() {
    }

    public Contacto(int id, String apellido, String nombre, String direccion, String telefono, LocalDate fechaNacimiento, String observaciones, Ciudad ciudad) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.observaciones = observaciones;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(apellido).append(", ").append(nombre);
        
        return sb.toString();
    }

}
