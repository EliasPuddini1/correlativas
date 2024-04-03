package com.utndds.correlativas;

import com.utndds.correlativas.igu.MenuPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class CorrelativasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrelativasApplication.class, args);
		System.setProperty("java.awt.headless", "false"); //Disables headless, esto lo saque de StackOverflow lo reconozco. Sino no se ejecuta y es un quilombo

		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.main(args);

	}

}
