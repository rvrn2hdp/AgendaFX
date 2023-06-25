package com.analistas.agendafx.repository;

import com.analistas.agendafx.model.Contacto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RVRN2
 */
public class ContactoRepository {
    
    List<Contacto> contactos;

    public ContactoRepository() {
        contactos = new ArrayList<>();
        
        contactos.add(
                new Contacto(
                        1, 
                        "Silvi", 
                        "Franco", 
                        "Salta 123", 
                        "3624123123", 
                        LocalDate.parse("1999-07-20"), 
                        "Ninguna", 
                        null));
        
        contactos.add(
                new Contacto(
                        2, 
                        "Ortiz", 
                        "Juan", 
                        "Castelli, 555", 
                        "3624392838", 
                        LocalDate.parse("1993-01-13"), 
                        "Ninguna", 
                        null));
        
        contactos.add(
                new Contacto(
                        3, 
                        "Mendieta", 
                        "Santiago", 
                        "Ameghino, 777", 
                        "3624123122", 
                        LocalDate.parse("2003-03-22"), 
                        "Ninguna", 
                        null));
        
        
        contactos.add(
                new Contacto(
                        4, 
                        "Sanchez", 
                        "Matias", 
                        "La Valle, 132", 
                        "3624321321", 
                        LocalDate.parse("1999-02-10"), 
                        "Ninguna", 
                        null));
    }
    
    public List<Contacto> getContactos() {
        return contactos;
    }
    
}
