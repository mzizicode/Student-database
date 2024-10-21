// Package declaration for the StudentApplication
package com.StudentApplication;

// Importing necessary classes and annotations from Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository; // Interface for basic CRUD operations
import org.springframework.data.jpa.repository.Query; // Annotation for defining custom queries
import org.springframework.data.repository.query.Param; // Annotation for named parameters in queries
import org.springframework.stereotype.Repository; // Annotation to indicate that this is a Spring Repository

import java.util.List; // Importing List interface for handling collections of Students

// Annotation to mark this interface as a Spring Repository
@Repository
// Declaring the StudentRepository interface, extending JpaRepository for Student entities
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query to check if a student with a given lineId exists
    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " + // Check if count of students with the lineId is greater than 0
            "TRUE ELSE FALSE END " + // Return TRUE if exists, otherwise FALSE
            "FROM Student s " + // From the Student entity
            "WHERE s.lineId = ?1" // Where the lineId matches the given parameter
    )
    Boolean selectExistslineId(String lineId); // Method to return a Boolean indicating existence of lineId

    // Method to find a list of students by their grade
    List<Student> findStudentByGrade(String grade); // Method to retrieve students based on their grade
}
