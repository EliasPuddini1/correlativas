package com.utndds.correlativas;

import com.utndds.correlativas.modelos.Alumno;
import com.utndds.correlativas.modelos.Inscripcion;
import com.utndds.correlativas.modelos.Materia;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CorrelativasApplicationTests {

	@Test
	void testInscripcion() {

		// Crear materias y correlativas
		Materia algoritmos = new Materia("Algoritmos",null);
		Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos));
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
	}

	@Test
	void testInscribir(){
		// Crear materias y correlativas
		Materia algoritmos = new Materia("Algoritmos",null);
		Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos));
		Materia diseñoSistemas = new Materia("Diseño de Sistemas",List.of(paradigmas));

		// Crear inscripción con las materias a verificar
		Inscripcion inscripcion = new Inscripcion(null, List.of(diseñoSistemas));

		// Crear alumno y agregar materias hechas
		Alumno alumno = new Alumno("juan",List.of(algoritmos,paradigmas),List.of(inscripcion));
		inscripcion.setAlumno(alumno);

		alumno.inscribir(List.of(diseñoSistemas));
	}


}
