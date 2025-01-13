package com.espe.examen.services;

import com.espe.examen.model.entities.Examen;

import java.util.List;
import java.util.Optional;

public interface ExamenService {
    List<Examen> findAll();
    Optional<Examen> findById(Long id);
    Examen save(Examen curso);
    void deleteById(Long id);
}
