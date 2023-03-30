package com.github.youssfbr.spring.rest.controller;

import com.github.youssfbr.spring.entity.Curso;
import com.github.youssfbr.spring.service.interfaces.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final ICursoService cursoService;

    @GetMapping
    public List<Curso> listarTodosCursos() {
        return cursoService.listarTodosCursos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso criarCurso (@RequestBody Curso curso) {
        return cursoService.criarCurso(curso);
    }

}
