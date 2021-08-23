package com.prueba.ejerciciocandoit.dominio;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="curso")
public class Curso implements Serializable {

    private static final long serialVersionIUD = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idCurso;
    private String nombreCurso;
    private String profesorAsignado;

    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos = new ArrayList<>();

    public Curso(){}

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesorAsignado() {
        return profesorAsignado;
    }

    public void setProfesorAsignado(String profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregarAlumno (Alumno alumno){
        alumnos.add(alumno);
        alumno.getCursos().add(this);
    }

    public void eliminarAlumno (Alumno alumno){
        alumnos.remove(alumno);
        alumno.getCursos().remove(this);
    }

}
