package com.openbootcamp.demosprintrest.services;

import com.openbootcamp.demosprintrest.models.Bootcamper;
import org.jvnet.hk2.annotations.Service;
import java.util.ArrayList;
import java.util.List;

//se encarga de la conexión, es el que manipula el modelo
@Service
public class BootcamperService {

    private final List<Bootcamper> bootcampers = new ArrayList<>();

    public List<Bootcamper> getAll(){ return bootcampers; }

    public void add(Bootcamper bootcamper){
        bootcampers.add(bootcamper);
    }

    public Bootcamper get(String nombre) {
        for (Bootcamper bootcamper : bootcampers) {
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)) {
                return bootcamper;
            }
        }

        return null;
    }
}
