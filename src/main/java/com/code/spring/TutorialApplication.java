package com.code.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {

		SpringApplication.run(TutorialApplication.class, args);
		System.out.println("Application is running");
	}

}
