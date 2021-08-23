package com.prueba.ejerciciocandoit.servicio;

import com.prueba.ejerciciocandoit.dao.AlumnoDao;
import com.prueba.ejerciciocandoit.dominio.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoDao alumnoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> listaAlumnos() {
        return (List<Alumno>) alumnoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    @Transactional
    public void eliminar(Alumno alumno) {
        alumnoDao.delete(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno encontrarAlumno(Alumno alumno) {
        return (Alumno) alumnoDao.findById(alumno.getIdAlumno()).orElse(null);
    }
}
