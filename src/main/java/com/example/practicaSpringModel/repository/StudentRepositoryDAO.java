package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositoryDAO extends CrudRepository<Student, Integer> {

}
