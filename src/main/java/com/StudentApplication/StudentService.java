package com.StudentApplication;

import exception.BadRequestException;
import exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + "taken"
            );

        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
      if(!studentRepository .existsById(studentId)){
       throw new StudentNotFoundException(
               "student with id " + studentId + " does not exist");
    }
    studentRepository.deleteById(studentId);
    }

}



