package com.github.youssfbr.spring.service.interfaces;

import com.github.youssfbr.spring.entity.Curso;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICursoService {

    List<Curso> listarTodosCursos();
    ResponseEntity<Curso> buscarCursoPorId(Long id);
    Curso criarCurso(Curso curso);
    ResponseEntity<Curso> atualizarCursoPorId(Long id, Curso curso);
    ResponseEntity<Object> excluirCursoPorId(Long id);

}
