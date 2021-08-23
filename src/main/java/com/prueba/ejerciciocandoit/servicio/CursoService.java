package com.prueba.ejerciciocandoit.servicio;

import com.prueba.ejerciciocandoit.dominio.Alumno;
import com.prueba.ejerciciocandoit.dominio.Curso;


import java.util.List;

public interface CursoService {

    List<Curso> listarCursos();
    void guardar(Curso curso);
    void eliminar(Curso curso);
    Curso encontrarCurso(Long idCurso);
    Curso asociarAlumnoACurso(Long idCurso, Long idAlumno);
    Curso desasociarAlumnoACurso(Long idCurso, Long idAlumno);
    List<Alumno> obtenerAlumnosDeUnCurso(Long idCurso);

}
