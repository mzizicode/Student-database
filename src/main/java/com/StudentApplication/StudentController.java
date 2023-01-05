package com.StudentApplication;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public List<Student>getAllStudents(){

  return studentService.getAllStudents();
    }
   @PostMapping
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
   }
//    @PutMapping(path = "{studentId}")
//    public void updateStudent(@PathVariable("studentId") UUID studentId,
//                              @RequestBody Student student) {
//        studentService.updateStudent(studentId, student);
//    }
    @DeleteMapping(path = "{studentId}")
      public void deleteStudent(
              @PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }

}
