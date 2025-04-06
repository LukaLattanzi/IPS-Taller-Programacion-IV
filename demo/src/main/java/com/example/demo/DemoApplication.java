package com.example.demo;

// Importa las clases necesarias para iniciar una aplicación Spring Boot.
import org.springframework.boot.SpringApplication; // Clase que permite iniciar la aplicación Spring.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Anotación que marca esta clase como punto de inicio de una aplicación Spring Boot, habilita la configuración automática y escaneo de componentes.

@SpringBootApplication // Marca la clase como la principal de una aplicación Spring Boot, combinando
						// @Configuration, @EnableAutoConfiguration y @ComponentScan.
public class DemoApplication {

	// Método principal que sirve como punto de entrada de la aplicación.
	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot, levantando el contexto de Spring y
		// embebiendo el servidor web (por ejemplo, Tomcat).
		SpringApplication.run(DemoApplication.class, args);
	}
}