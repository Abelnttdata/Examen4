package com.example.practicaSpringModel.repository;

import com.example.practicaSpringModel.entity.Proceeding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProceedingRepository {

    @Autowired
    ProceedingRepositoryDAO proceedingRepositoryDAO;

    public List<Proceeding> getProceedings() {
        return (List<Proceeding>) proceedingRepositoryDAO.findAll();
    }

    public Optional<Proceeding> getProceedingByID(Integer id) {
        return proceedingRepositoryDAO.findById(id);
    }

    public void createProceeding(Proceeding proceeding) {
        proceedingRepositoryDAO.save(proceeding);
    }

    public void deleteProceeding(Integer id) {
        proceedingRepositoryDAO.deleteById(id);
    }

    public void updateProceeding(Proceeding proceeding, Integer id) {
        proceedingRepositoryDAO.save(proceeding);
        proceedingRepositoryDAO.deleteById(id);
    }
}
