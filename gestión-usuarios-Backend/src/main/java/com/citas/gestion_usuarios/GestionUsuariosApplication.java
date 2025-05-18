package com.citas.gestion_usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.citas.gestion_usuarios")
public class GestionUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionUsuariosApplication.class, args);
	}

}
