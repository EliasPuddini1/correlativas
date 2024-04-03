package com.utndds.correlativas;

import com.utndds.correlativas.persistencia.AlumnoRepository;
import com.utndds.correlativas.persistencia.InscripcionRepository;
import com.utndds.correlativas.persistencia.MateriaRepository;
import com.utndds.correlativas.utils.MenuPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CorrelativasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrelativasApplication.class, args);
	}

	//@Bean
	public CommandLineRunner init(AlumnoRepository alumnoRepository, InscripcionRepository inscripcionRepository, MateriaRepository materiaRepository){
		return args -> {
			MenuPrincipal menu = new MenuPrincipal();
			menu.menu(alumnoRepository,inscripcionRepository,materiaRepository);
		};
	}

}
