package com.kirin.personnel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Микросервис для работы с персоналом
 */
@SpringBootApplication
public class PersonnelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonnelServiceApplication.class, args);
	}

}
