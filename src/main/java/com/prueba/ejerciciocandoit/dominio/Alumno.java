package com.prueba.ejerciciocandoit.dominio;

import com.prueba.ejerciciocandoit.dominio.Curso;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="alumno")
public class Alumno implements Serializable {

    private static final long serialVersionIUD = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idAlumno;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name="alumno_curso",
            joinColumns = {@JoinColumn(name="idAlumno",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name="idCurso",nullable = false)}
    )
    private List<Curso> cursos = new ArrayList<>();

    public Alumno(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }



}
