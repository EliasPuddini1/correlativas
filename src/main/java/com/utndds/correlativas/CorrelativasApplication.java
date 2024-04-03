package com.utndds.correlativas;

import com.utndds.correlativas.modelos.Alumno;
import com.utndds.correlativas.modelos.Inscripcion;
import com.utndds.correlativas.modelos.Materia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CorrelativasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrelativasApplication.class, args);

		// Crear materias y correlativas
		Materia algoritmos = new Materia("Algoritmos",null);
		Materia paradigmas = new Materia("Paradigmas",List.of(algoritmos));
		Materia diseñoSistemas = new Materia("Diseño de Sistemas",List.of(paradigmas));

		// Crear inscripción con las materias a verificar
		Inscripcion inscripcion = new Inscripcion(null, List.of(diseñoSistemas));

		// Crear alumno y agregar materias hechas
		Alumno alumno = new Alumno("juan",List.of(algoritmos,paradigmas),List.of(inscripcion));
		inscripcion.setAlumno(alumno);


		// Verificar si la inscripción está aprobada
		if (inscripcion.aprobada()) {
			System.out.println("La inscripción está aprobada");
		} else {
			System.out.println("La inscripción no está aprobada");
		}

		alumno.inscribir(List.of(diseñoSistemas));

	}



}
