package com.example.practicaSpringModel.controller;

import com.example.practicaSpringModel.entity.Student;
import com.example.practicaSpringModel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
    @GetMapping("searchby/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws nonexistentStudentException {
        Optional<Student> optionalStudent= studentRepository.getStudentByID(id);
        if(optionalStudent.isEmpty()){
            throw new nonexistentStudentException();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentRepository.createStudent(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("deleteby/{id}")
    public ResponseEntity<Student> deleteStudentException(@PathVariable Integer id) throws nonexistentStudentException {
        Optional<Student> optionalStudent = studentRepository.getStudentByID(id);
        if(optionalStudent.isEmpty()){
            throw new nonexistentStudentException();
        }
        studentRepository.deleteStudent(id);
        return ResponseEntity.ok(optionalStudent.get());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateCustomerException(@PathVariable Integer id, @RequestBody Student student) throws nonexistentStudentException{
        Optional<Student> optionalStudent = studentRepository.getStudentByID(id);
        if(optionalStudent.isEmpty()){
            throw new nonexistentStudentException();
        }
        studentRepository.updateStudent(student, id);
        return ResponseEntity.ok(optionalStudent.get());
    }
}
