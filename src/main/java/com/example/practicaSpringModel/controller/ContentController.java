package com.example.practicaSpringModel.controller;


import com.example.practicaSpringModel.entity.Content;
import com.example.practicaSpringModel.entity.Student;
import com.example.practicaSpringModel.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contents")
public class ContentController {

    @Autowired
    ContentRepository contentRepository;

    @GetMapping
    public List<Content> getAllContents() {

        return contentRepository.getAllContents();
    }

    @GetMapping("searchby/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Integer id) throws nonexistentContentException {
        Optional<Content> optionalContent= contentRepository.getContentByID(id);
        if(optionalContent.isEmpty()){
            throw new nonexistentContentException();
        }
        return ResponseEntity.ok(optionalContent.get());
    }

    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content){
        contentRepository.createcontent(content);
        return ResponseEntity.ok(content);
    }

    @DeleteMapping("deleteby/{id}")
    public ResponseEntity<Content> deleteContentException(@PathVariable Integer id) throws nonexistentContentException {
        Optional<Content> optionalContent = contentRepository.getContentByID(id);
        if(optionalContent.isEmpty()){
            throw new nonexistentContentException();
        }
        contentRepository.deleteContent(id);
        return ResponseEntity.ok(optionalContent.get());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Content> updateContentException(@PathVariable Integer id, @RequestBody Content content) throws nonexistentContentException{
        Optional<Content> optionalContent = contentRepository.getContentByID(id);
        if(optionalContent.isEmpty()){
            throw new nonexistentContentException();
        }
        contentRepository.updateContent(content, id);
        return ResponseEntity.ok(optionalContent.get());
    }

}
