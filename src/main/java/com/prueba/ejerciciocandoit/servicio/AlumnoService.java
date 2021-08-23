package com.prueba.ejerciciocandoit.servicio;

import com.prueba.ejerciciocandoit.dominio.Alumno;

import java.util.List;

public interface AlumnoService {

    public List<Alumno> listaAlumnos();
    public void guardar (Alumno alumno);
    public void eliminar (Alumno alumno);
    public Alumno encontrarAlumno (Alumno alumno);

}
