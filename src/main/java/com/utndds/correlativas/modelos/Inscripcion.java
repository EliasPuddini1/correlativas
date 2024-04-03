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
    @OneToMany
    private List<Materia> materias;
    @ManyToOne
    private Alumno alumno;

    //constructor
    public Inscripcion(Alumno alumno,List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }
    //metodos varios
    public boolean aprobada(){

        return materias.stream().anyMatch(materia -> materia.getCorrelativas().stream().anyMatch(materiaC -> !alumno.getMateriasHechas().contains(materiaC)));
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
}
