package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContentRepository {

    @Autowired
    ContentRepositoryDAO contentRepositoryDAO;

    public List<Content> getAllContents() {
        return (List<Content>) contentRepositoryDAO.findAll();
    }

    public Optional<Content> getContentByID(Integer id) {
        return  contentRepositoryDAO.findById(id);
    }

    public void createcontent(Content content) {
        contentRepositoryDAO.save(content);
    }

    public void deleteContent(Integer id) {
        contentRepositoryDAO.deleteById(id);
    }

    public void updateContent(Content content, Integer id) {
        contentRepositoryDAO.save(content);
        contentRepositoryDAO.deleteById(id);;
    }
}
