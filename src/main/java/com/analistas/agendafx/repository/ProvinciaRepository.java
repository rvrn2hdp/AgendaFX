package com.analistas.agendafx.repository;

import com.analistas.agendafx.model.Provincia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RVRN2
 */
public class ProvinciaRepository {
    
    List<Provincia> provincias;

    public ProvinciaRepository() {
        provincias = new ArrayList<>();
        
        provincias.add(new Provincia(1, "Chaco"));
        provincias.add(new Provincia(2, "Corrientes"));
        provincias.add(new Provincia(3, "Formosa"));
        provincias.add(new Provincia(4, "Misiones"));
        
    }
    
    public List<Provincia> getProvincias() {
        return provincias;
    }
    
}
