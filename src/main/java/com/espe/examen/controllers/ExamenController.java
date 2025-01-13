package com.espe.examen.controllers;

import com.espe.examen.model.entities.Examen;
import com.espe.examen.services.ExamenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {
    @Autowired
    private ExamenService service;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Examen examen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examen));
    }

    @GetMapping
    public List<Examen> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> getById(@PathVariable Long id) {
        Optional<Examen> examenOptional = service.findById(id);
        if (examenOptional.isPresent()) {
            return ResponseEntity.ok(examenOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody Examen examen) {
        Optional<Examen> examenOptional = service.findById(id);
        if (examenOptional.isPresent()) {
            Examen examenDB = examenOptional.get();
            examenDB.setNombre(examen.getNombre());
            examenDB.setMatricula(examen.getMatricula());
            examenDB.setEdad(examen.getEdad());
            examenDB.setFechaNacimiento(examen.getFechaNacimiento());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Examen> examenOptional = service.findById(id);
        if (examenOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
