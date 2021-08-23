package com.prueba.ejerciciocandoit.controlador;

import com.prueba.ejerciciocandoit.dominio.Alumno;
import com.prueba.ejerciciocandoit.servicio.AlumnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class ControladorAlumnos {

    private final AlumnoService alumnoService;


    public ControladorAlumnos(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String inicioAlumnos(Model model){
        var personas = alumnoService.listaAlumnos();
        model.addAttribute("alumnos", personas);
        return "alumnos";
    }

    @GetMapping("/agregar")
    public String agregar(Alumno alumno){
        return "modificarAlumno";
    }

    @PostMapping("/guardar")
    public String guardar(Alumno alumno){
        alumnoService.guardar(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{idAlumno}")
    public String editar(Alumno alumno, Model model){
        alumno = alumnoService.encontrarAlumno(alumno);
        model.addAttribute("alumno", alumno);
        return "modificarAlumno";
    }

    @GetMapping("/eliminar")
    public String eliminar(Alumno alumno){
        alumnoService.eliminar(alumno);
        return "redirect:/alumnos";
    }

}
