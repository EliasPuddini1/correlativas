package com.utndds.correlativas.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long legajo;
    private String nombre;
    @OneToMany
    private List<Materia> materiasHechas;
    @OneToMany
    private List<Inscripcion> inscripciones;

    //constructor
    public Alumno(String nombre, List<Materia> materiasHechas, List<Inscripcion> inscripciones) {

        this.nombre = nombre;
        this.materiasHechas = materiasHechas;
        this.inscripciones = inscripciones;
    }

    //metodos varios
    public void inscribir(List<Materia> materias){

        Inscripcion inscripcion = new Inscripcion(this,materias);



    }

    //getters y setters
    public Long getLegajo() {
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
