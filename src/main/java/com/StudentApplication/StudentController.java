// Package declaration for the StudentApplication
package com.StudentApplication;

// Importing required classes and annotations
import lombok.AllArgsConstructor; // Lombok annotation for generating a constructor with all arguments
import lombok.extern.slf4j.Slf4j; // Lombok annotation for logging
import org.springframework.http.ResponseEntity; // Class for representing HTTP responses
import org.springframework.web.bind.annotation.*; // Importing Spring MVC annotations for RESTful web services

import javax.validation.Valid; // Annotation for validating request body
import java.util.Arrays; // Importing utility classes (not used in the code)
import java.util.List; // Importing List interface for handling collections of Students

// Annotation to mark this class as a REST controller
@RestController
// Annotation to define the base path for all endpoints in this controller
@RequestMapping(path = "api/v1/students")
// Lombok annotation to generate a constructor that takes all fields as parameters
@AllArgsConstructor
public class StudentController {

    // Declaring a private final instance of StudentService to handle business logic
    private final StudentService studentService;

    // Endpoint to get students by their grade
    @GetMapping(path = "{grade}") // Mapping GET requests for the specified grade
    public List<Student> findStudentByGrade(@PathVariable("grade") String grade) {
        // Calling the service method to find students by grade
        return studentService.findStudentByGrade(grade);
    }

    // Endpoint to add a new student
    @PostMapping // Mapping POST requests to add a new student
    public void addStudent(@Valid @RequestBody Student student) {
        // Calling the service method to add the student
        // @Valid ensures that the student object meets validation criteria
        studentService.addStudent(student);
    }

    // Endpoint to delete a student by their ID
    @DeleteMapping(path = "{studentId}") // Mapping DELETE requests with a student ID
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        // Calling the service method to delete the student by ID
        studentService.deleteStudent(studentId);
    }

    // Endpoint to get a list of all students
    @GetMapping // Mapping GET requests to retrieve all students
    public List<Student> getAllStudents() {
        // Calling the service method to get all students
        return studentService.getAllStudents();
    }

}



