package com.utndds.correlativas.modelos;

import java.util.List;

public class Materia {

    private double id;
    private String nombre;
    private List<Materia> correlativas;

    //getters y setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}
