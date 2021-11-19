package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
public class StudentRepository {
    @Autowired
    StudentRepositoryDAO studentRepositoryDAO;

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepositoryDAO.findAll();
    }

    public Optional<Student> getStudentByID(Integer id) {
        return studentRepositoryDAO.findById(id);
    }

    public void createStudent(Student student) {
        studentRepositoryDAO.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepositoryDAO.deleteById(id);
    }

    public void updateStudent(Student student, Integer id) {
        studentRepositoryDAO.save(student);
        deleteStudent(id);
    }
}
