package com.espe.examen.repositories;

import com.espe.examen.model.entities.Examen;
import org.springframework.data.repository.CrudRepository;

public interface ExamenRepository extends CrudRepository<Examen, Long> {
}
