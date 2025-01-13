package com.espe.examen.services;

import com.espe.examen.model.entities.Examen;
import com.espe.examen.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImp implements ExamenService {

    @Autowired
    private ExamenRepository repository;

    @Override
    public List<Examen> findAll() {
        return (List<Examen>) repository.findAll();
    }

    @Override
    public Optional<Examen> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Examen save(Examen examen) {
        return repository.save(examen);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
