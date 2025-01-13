package com.espe.examen.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "examenes")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "El nombre no puede estar vacío") // Valida que no esté vacío
    @Size(max = 100, message = "El nombre no debe tener más de 100 caracteres") // Longitud máxima
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "La matrícula no puede estar vacía") // Valida que no esté vacío
    @Column(nullable = false)
    private String matricula;

    @Min(value = 18, message = "La edad mínima es 18") // Edad mínima
    @Max(value = 99, message = "La edad máxima es 99") // Edad máxima
    @Column(nullable = false)
    private int edad;

    @Temporal(TemporalType.DATE) // Define el formato para fechas
    @Column(nullable = false)
    private Date fechaNacimiento;

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
