package com.github.youssfbr.spring.service;

import com.github.youssfbr.spring.entity.Curso;
import com.github.youssfbr.spring.repository.ICursoRepository;
import com.github.youssfbr.spring.service.interfaces.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService implements ICursoService {

    private final ICursoRepository cursoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    @Transactional
    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

}
