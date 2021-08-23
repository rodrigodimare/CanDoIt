package com.prueba.ejerciciocandoit.dao;

import com.prueba.ejerciciocandoit.dominio.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends CrudRepository<Curso, Long> {

}
