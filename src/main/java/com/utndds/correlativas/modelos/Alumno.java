package com.utndds.correlativas.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        this.inscripciones = new ArrayList<>(inscripciones);
    }

    //metodos varios
    public void inscribir(List<Materia> materias){

        Inscripcion inscripcion = new Inscripcion(this,materias);

        if(inscripcion.aprobada()){

            addInscripcion(inscripcion);
            System.out.println(" inscripción realizada. ");
        }else{

            List<Materia> materiasF = inscripcion.getMaterias().stream().filter(materia -> this.getMateriasHechas().containsAll(materia.getCorrelativas())).collect(Collectors.toList());

            System.out.println(" Inscripción fallida. El alumno no cuenta con las correlativas necesarias para las materias:");
            
            for(Materia materia:materiasF){
                System.out.println("materia = " + materia);
            }
        }

    }
    //metodos varios
    public void addInscripcion(Inscripcion inscripcion){

        inscripciones.add(inscripcion);
    }

    public void addMateriaHecha(Materia materia){
        materiasHechas.add(materia);
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
