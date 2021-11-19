package com.example.practicaSpringModel.controller;

import com.example.practicaSpringModel.entity.Proceeding;
import com.example.practicaSpringModel.entity.Student;
import com.example.practicaSpringModel.repository.ProceedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("proceedings")
public class ProceedingController {
    @Autowired
    ProceedingRepository proceedingRepository;

    @GetMapping
    public List<Proceeding> getAllProceedings() {

        return proceedingRepository.getProceedings();
    }

    @GetMapping("searchby/{id}")
    public ResponseEntity<Proceeding> getProceedingsByID(@PathVariable Integer id) throws nonexistentProceedingException {
        Optional<Proceeding> optionalProceeding= proceedingRepository.getProceedingByID(id);
        if(optionalProceeding.isEmpty()){
            throw new nonexistentProceedingException();
        }
        return ResponseEntity.ok(optionalProceeding.get());
    }

    @PostMapping
    public ResponseEntity<Proceeding> createProceeding(@RequestBody Proceeding proceeding){
        proceedingRepository.createProceeding(proceeding);
        return ResponseEntity.ok(proceeding);
    }

    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<Proceeding> deleteProceedingException(@PathVariable Integer id) throws nonexistentProceedingException {
        Optional<Proceeding> optionalProceeding = proceedingRepository.getProceedingByID(id);
        if(optionalProceeding.isEmpty()){
            throw new nonexistentProceedingException();
        }
        proceedingRepository.deleteProceeding(id);
        return ResponseEntity.ok(optionalProceeding.get());
    }

    @PutMapping("updatebyid/{id}")
    public ResponseEntity<Proceeding> updateProceedingException(@PathVariable Integer id, @RequestBody Proceeding proceeding) throws nonexistentProceedingException{
        Optional<Proceeding> optionalProceeding = proceedingRepository.getProceedingByID(id);
        if(optionalProceeding.isEmpty()){
            throw new nonexistentProceedingException();
        }
        proceedingRepository.updateProceeding(proceeding, id);
        return ResponseEntity.ok(optionalProceeding.get());
    }


}
