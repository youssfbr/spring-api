package com.github.youssfbr.spring.rest.controller;

import com.github.youssfbr.spring.entity.Curso;
import com.github.youssfbr.spring.service.interfaces.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarCursoPorId(@PathVariable Long id) {
        return cursoService.buscarCursoPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso criarCurso (@RequestBody Curso curso) {
        return cursoService.criarCurso(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> batualizarCursoPorId(
            @PathVariable Long id,
            @RequestBody Curso curso) {
        return cursoService.atualizarCursoPorId(id, curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCursoPorId(@PathVariable Long id) {
        return cursoService.excluirCursoPorId(id);
    }

}
