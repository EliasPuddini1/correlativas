package com.utndds.correlativas;

import com.utndds.correlativas.modelos.Alumno;
import com.utndds.correlativas.modelos.Inscripcion;
import com.utndds.correlativas.modelos.Materia;
import com.utndds.correlativas.persistencia.AlumnoRepository;
import com.utndds.correlativas.persistencia.InscripcionRepository;
import com.utndds.correlativas.persistencia.MateriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CorrelativasApplicationTests {

	@Autowired
	MateriaRepository materiaRepository;
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	InscripcionRepository inscripcionRepository;

	@Test
	void testInscripcion() {
		// Crear materias y correlativas
		Materia algoritmos = new Materia("Algoritmos",null);
		Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos));
		Materia diseñoSistemas = new Materia("Diseño_de_Sistemas",List.of(paradigmas,algoritmos));

		// Crear inscripción con las materias a verificar
		Inscripcion inscripcion = new Inscripcion(null, List.of(diseñoSistemas));

		// Crear alumno y agregar materias hechas
		Alumno alumno = new Alumno("juan",List.of(algoritmos,paradigmas),List.of(inscripcion));
		inscripcion.setAlumno(alumno);

		Assertions.assertTrue(inscripcion.aprobada());
	}

	@Test
	void testInscribir(){
		// Crear materias y correlativas
		Materia algoritmos = new Materia("Algoritmos",null);
		Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos));
		Materia diseñoSistemas = new Materia("Diseño_de_Sistemas",List.of(paradigmas));

		// Crear inscripción con las materias a verificar
		Inscripcion inscripcion = new Inscripcion(null, List.of(diseñoSistemas));

		// Crear alumno y agregar materias hechas
		Alumno alumno = new Alumno("juan",List.of(algoritmos,paradigmas),List.of(inscripcion));
		inscripcion.setAlumno(alumno);

		Assertions.assertTrue(alumno.inscribir(List.of(diseñoSistemas)));
	}

	@Test
	void testInscripcionConBDD() {

		// Crear materias y correlativas
		Materia materia = materiaRepository.findAll().stream().filter(materia1 -> materia1.getNombre() == "Diseño_de_Sistemas").findFirst().orElse(null);
		Alumno alumno = alumnoRepository.findAll().stream().filter(alumno1 -> alumno1.getLegajo() == 1).findFirst().orElse(null);

		if(alumno != null && materia != null){
			Inscripcion inscripcion = new Inscripcion(alumno, List.of(materia));
			Assertions.assertTrue(inscripcion.aprobada());
		}

	}
}
