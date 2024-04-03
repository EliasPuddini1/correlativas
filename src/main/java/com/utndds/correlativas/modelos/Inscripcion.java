package com.utndds.correlativas.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Materia> materias;
    @ManyToOne(fetch = FetchType.EAGER)
    private Alumno alumno;

    //constructor
    public Inscripcion(){}
    public Inscripcion(Alumno alumno,List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }
    //metodos varios
    public boolean aprobada(){

        for(Materia materia: materias){

            if(!materia.esCorrelativaAprobada(alumno)){
                return false;
            }

        }
        return true;
        //afirmo el hecho por Elias Puddini
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    //toString


    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", materias=" + materias +
                ", alumno=" + alumno +
                '}';
    }
}
