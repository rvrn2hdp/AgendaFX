package com.analistas.agendafx.repository;

import com.analistas.agendafx.model.Ciudad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RVRN2
 */
public class CiudadRepository {

    ProvinciaRepository provinciaRepo = new ProvinciaRepository();

    List<Ciudad> ciudades;

    public CiudadRepository() {
        ciudades = new ArrayList<>();

        ciudades.add(new Ciudad(
                1,
                "Resistencia",
                "3500",
                provinciaRepo.getProvincias().get(0)));

        ciudades.add(new Ciudad(
                2,
                "Corrientes",
                "3700",
                provinciaRepo.getProvincias().get(1)));

        ciudades.add(new Ciudad(
                3,
                "Formosa",
                "3600",
                provinciaRepo.getProvincias().get(2)));

        ciudades.add(new Ciudad(
                4,
                "Castelli",
                "3705",
                provinciaRepo.getProvincias().get(0)));

        ciudades.add(new Ciudad(
                5,
                "Barranqueras",
                "3505",
                provinciaRepo.getProvincias().get(0)));

        ciudades.add(new Ciudad(
                6,
                "Posadas",
                "3900",
                provinciaRepo.getProvincias().get(3)));
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

}
