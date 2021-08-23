package com.prueba.ejerciciocandoit.dao;

import com.prueba.ejerciciocandoit.dominio.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDao extends CrudRepository<Alumno, Long> {

}
