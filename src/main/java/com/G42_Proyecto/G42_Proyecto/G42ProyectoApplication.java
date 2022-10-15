package com.G42_Proyecto.G42_Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class G42ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(G42ProyectoApplication.class, args);
	}

}
