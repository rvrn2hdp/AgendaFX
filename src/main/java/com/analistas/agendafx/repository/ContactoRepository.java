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

    CiudadRepository ciudadRepo = new CiudadRepository();

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
                        ciudadRepo.getCiudades().get(1)));

        contactos.add(
                new Contacto(
                        2,
                        "Ortiz",
                        "Juan",
                        "Castelli, 555",
                        "3624392838",
                        LocalDate.parse("1993-01-13"),
                        "Ninguna",
                        ciudadRepo.getCiudades().get(2)));

        contactos.add(
                new Contacto(
                        3,
                        "Mendieta",
                        "Santiago",
                        "Ameghino, 777",
                        "3624123122",
                        LocalDate.parse("2003-03-22"),
                        "Ninguna",
                        ciudadRepo.getCiudades().get(4)));

        contactos.add(
                new Contacto(
                        4,
                        "Sanchez",
                        "Matias",
                        "La Valle, 132",
                        "3624321321",
                        LocalDate.parse("1999-02-10"),
                        "Ninguna",
                        ciudadRepo.getCiudades().get(3)));
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public List<Contacto> getContactos(String criterio) {

        List<Contacto> encontrados = new ArrayList<>();

        for (Contacto con : contactos) {
            if (con.getApellido().toLowerCase().contains(criterio.toLowerCase())
                    || con.getNombre().toLowerCase().contains(criterio.toLowerCase())) {
                encontrados.add(con);
            }
        }

        return encontrados;
    }

    public void addContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void editContacto(Contacto contacto) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getId() == contacto.getId()) {
                contactos.set(i, contacto);
                break;
            }
        }
    }
}
