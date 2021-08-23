package com.prueba.ejerciciocandoit.servicio;

import com.prueba.ejerciciocandoit.dao.AlumnoDao;
import com.prueba.ejerciciocandoit.dao.CursoDao;
import com.prueba.ejerciciocandoit.dominio.Alumno;
import com.prueba.ejerciciocandoit.dominio.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoServiceImp implements CursoService{

    private final CursoDao cursoDao;
    private final AlumnoDao alumnoDao;

    public CursoServiceImp(CursoDao cursoDao, AlumnoDao alumnoDao) {
        this.cursoDao = cursoDao;
        this.alumnoDao = alumnoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listarCursos(){
        return (List<Curso>) cursoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Curso curso){
        cursoDao.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(Curso curso){
        cursoDao.delete(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso encontrarCurso(Long idCurso){
        return (Curso) cursoDao.findById(idCurso).orElse(null);
    }

    @Override
    @Transactional
    public Curso asociarAlumnoACurso(Long idCurso, Long idAlumno){

        Curso curso = (Curso) cursoDao.findById(idCurso).orElse(null);
        Alumno alumno = (Alumno) alumnoDao.findById(idAlumno).orElse(null);

        if(curso != null && alumno!= null)
            curso.agregarAlumno(alumno);

        return curso;
    }

    @Override
    @Transactional
    public Curso desasociarAlumnoACurso(Long idCurso, Long idAlumno){
        Curso curso = (Curso) cursoDao.findById(idCurso).orElse(null);
        Alumno alumno = (Alumno) alumnoDao.findById(idAlumno).orElse(null);

        if(curso != null && alumno!= null)
            curso.eliminarAlumno(alumno);

        return curso;
    }

    @Override
    @Transactional
    public List<Alumno> obtenerAlumnosDeUnCurso(Long idCurso){
        Curso curso = (Curso) cursoDao.findById(idCurso).orElse(null);
        List<Alumno> alumnos = new ArrayList<Alumno>();
        if(curso != null)
           alumnos = curso.getAlumnos();

        return alumnos;
    }
}
