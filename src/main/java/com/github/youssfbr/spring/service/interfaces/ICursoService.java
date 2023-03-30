package com.github.youssfbr.spring.service.interfaces;

import com.github.youssfbr.spring.entity.Curso;

import java.util.List;

public interface ICursoService {

    List<Curso> listarTodosCursos();
    Curso criarCurso(Curso curso);

}
