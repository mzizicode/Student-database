// Package declaration for the StudentApplication
package com.StudentApplication;

// Importing custom exception classes for handling errors
import exception.BadRequestException; // Exception for bad requests, e.g., duplicate lineId
import exception.StudentNotFoundException; // Exception for when a student is not found

// Importing Lombok annotations for boilerplate code reduction
import lombok.AllArgsConstructor; // Annotation to generate a constructor with all class fields
import org.springframework.beans.factory.annotation.Autowired; // Import for dependency injection (not used here)
import org.springframework.stereotype.Service; // Annotation to mark this class as a service

import java.util.List; // Importing List interface for handling collections of Student entities

// Annotation to indicate that this class is a Spring Service component
@AllArgsConstructor // Automatically generates a constructor for all fields in the class
@Service
public class StudentService {
    // Injecting the StudentRepository dependency to interact with the database
    private final StudentRepository studentRepository;

    // Method to find students by their grade
    public List<Student> findStudentByGrade(String grade) {
        // Delegates the call to the repository to fetch students with the given grade
        return studentRepository.findStudentByGrade(grade);
    }

    // Method to add a new student
    public void addStudent(Student student) {
        // Check if a student with the same lineId already exists in the database
        Boolean existslineId = studentRepository.selectExistslineId(student.getLineId());
        // If the lineId is taken, throw a BadRequestException
        if (existslineId) {
            throw new BadRequestException(
                    "line " + student.getLineId() + " taken" // Custom message indicating the lineId is already in use
            );
        }
        // Save the new student to the database
        studentRepository.save(student);
    }

    // Method to delete a student by their ID
    public void deleteStudent(Long studentId) {
        // Check if the student exists in the database
        if (!studentRepository.existsById(studentId)) {
            // If not found, throw a StudentNotFoundException
            throw new StudentNotFoundException(
                    "student with id " + studentId + " does not exist" // Custom message indicating the student was not found
            );
        }
        // Delete the student from the database using their ID
        studentRepository.deleteById(studentId);
    }

    // Method to retrieve all students from the database
    public List<Student> getAllStudents() {
        // Return a list of all students using the repository
        return studentRepository.findAll();
    }
}
