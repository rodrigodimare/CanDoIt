package com.prueba.ejerciciocandoit.controlador;

import com.prueba.ejerciciocandoit.dominio.Alumno;
import com.prueba.ejerciciocandoit.dominio.Curso;
import com.prueba.ejerciciocandoit.servicio.AlumnoService;
import com.prueba.ejerciciocandoit.servicio.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class ControladorCursos {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    public ControladorCursos(AlumnoService alumnoService, CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String inicioCursos(Model model){
        var cursos = cursoService.listarCursos();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }

    @GetMapping("/asociarAlumnos")
    public String getCurso(@RequestParam Long idCurso, Model model){
        model.addAttribute("curso", cursoService.encontrarCurso(idCurso));
        model.addAttribute("alumnos", alumnoService.listaAlumnos());
        return "asociarAlumno";
    }

    @GetMapping("/asociarAlumno")
    public String asociarAlumnoACurso (@RequestParam Long idCurso,@RequestParam Long idAlumno, Model model){
        Curso curso = cursoService.asociarAlumnoACurso(idCurso, idAlumno);
        model.addAttribute("curso", curso);
        return "redirect:obtenerAlumnosDeCurso/" + curso.getIdCurso();
    }

    @GetMapping("/desasociarAlumno")
    public String desasociarAlumnoACurso(@RequestParam Long idCurso, @RequestParam Long idAlumno, Model model){
        cursoService.desasociarAlumnoACurso(idCurso, idAlumno);
        var cursos = cursoService.listarCursos();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }

    @GetMapping("/agregarCurso")
    public String agregar(Curso curso){
        return "editarCurso";
    }


    @GetMapping("/editarCurso/{id}")
    public String editarCurso(@PathVariable("id") Long idCurso, Model model){
        Curso curso = cursoService.encontrarCurso(idCurso);
        model.addAttribute("curso", curso);
        return "editarCurso";
    }

    @PostMapping("/guardarCurso")
    public String guardar(Curso curso){
        cursoService.guardar(curso);
        return "redirect:/cursos";
    }


    @GetMapping("/eliminarCurso")
    public String eliminar(Curso curso){
        cursoService.eliminar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/obtenerAlumnosDeCurso/{id}")
    public String obtenerAlumnosDeCurso (@PathVariable("id") Long idCurso, Model model){
        model.addAttribute("alumnos", cursoService.obtenerAlumnosDeUnCurso(idCurso));
        model.addAttribute("cursos", cursoService.encontrarCurso(idCurso));
        return "obtenerAlumnosDeCurso";
    }

}
