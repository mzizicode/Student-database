// Package declaration for the StudentApplication
package com.StudentApplication;

// Importing necessary classes from Spring Boot framework
import org.springframework.boot.SpringApplication; // Class to bootstrap a Spring application
import org.springframework.boot.autoconfigure.SpringBootApplication; // Annotation for Spring Boot application configuration

// Annotation to indicate that this is a Spring Boot application
@SpringBootApplication
public class StudentApplication {

	// The main method is the entry point of the application
	public static void main(String[] args) {
		// This line runs the Spring application
		// It sets up the Spring context and starts the application
		SpringApplication.run(StudentApplication.class, args);
	}

}
