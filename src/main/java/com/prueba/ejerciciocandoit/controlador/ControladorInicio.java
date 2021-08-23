package com.prueba.ejerciciocandoit.controlador;

import com.prueba.ejerciciocandoit.servicio.AlumnoService;
import com.prueba.ejerciciocandoit.servicio.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ControladorInicio {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    public ControladorInicio(AlumnoService alumnoService, CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    @GetMapping("/")
    public String inicio(){
        return "inicio";
    }



}
