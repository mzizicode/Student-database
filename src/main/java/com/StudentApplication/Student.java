// Package declaration for the StudentApplication
package com.StudentApplication;

// Importing necessary libraries for the application
import lombok.*; // Lombok annotations for generating boilerplate code
import javax.persistence.*; // JPA annotations for entity and database mapping
import javax.validation.constraints.NotNull; // Validation annotation to ensure fields are not null

// Lombok annotations to generate constructors, toString, getter, setter, and equals/hashcode methods
@Builder // Enables builder pattern for object creation
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor // Generates a no-argument constructor
@ToString // Generates a toString method for the class
@Getter // Generates getter methods for all fields
@Setter // Generates setter methods for all fields
@Table // Specifies the name of the database table
@Entity // Marks this class as a JPA entity (a table in the database)
@EqualsAndHashCode // Generates equals and hashCode methods for the class
public class Student {

    // Annotation to define the primary key for this entity
    @Id
    @SequenceGenerator(
            name = "student_sequence", // Name of the sequence generator
            sequenceName = "student_sequence" // Name of the database sequence
    )
    @GeneratedValue(
            generator = "student_sequence", // Specifies the generator to use
            strategy = GenerationType.SEQUENCE // Uses the sequence generation strategy
    )
    private Long id; // Unique identifier for each student

    // Field for the student's name, must not be null
    @NotNull // Validation annotation to ensure this field is not null
    @Column(nullable = false) // Specifies that this column cannot be null in the database
    private String name; // Student's name

    // Field for the student's nickname, must not be null
    @NotNull // Validation to ensure this field is not null
    private String nickName; // Student's nickname

    // Field for the student's LINE ID, must be unique and not null
    @Column(nullable = false, unique = true) // Specifies this column cannot be null and must be unique
    private String lineId; // Unique identifier for student communication

    // Field for the student's gender, must not be null
    @NotNull // Validation to ensure this field is not null
    @Column(nullable = false) // Specifies that this column cannot be null in the database
    private String gender; // Student's gender

    // Field for the student's grade, must not be null
    @NotNull // Validation to ensure this field is not null
    private String grade; // Student's grade/class

    // Field for the student's number, must not be null
    @NotNull // Validation to ensure this field is not null
    private Integer number; // Student's phone number or other contact number
}
