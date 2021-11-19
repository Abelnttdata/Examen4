package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepositoryDAO extends CrudRepository<Content, Integer> {
}
