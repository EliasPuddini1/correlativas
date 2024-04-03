package com.utndds.correlativas.modelos;

import java.util.List;

public class Alumno {

    private Double legajo;
    private String nombre;
    private List<Materia> materiasHechas;
    private List<Inscripcion> inscripciones;


    public Alumno(String nombre, List<Materia> materiasHechas, List<Inscripcion> inscripciones) {

        this.nombre = nombre;
        this.materiasHechas = materiasHechas;
        this.inscripciones = inscripciones;
    }

    public void inscribir(List<Materia> materias){

    }

    //getters y setters

    public Double getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMateriasHechas() {
        return materiasHechas;
    }

    public void setMateriasHechas(List<Materia> materiasHechas) {
        this.materiasHechas = materiasHechas;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
