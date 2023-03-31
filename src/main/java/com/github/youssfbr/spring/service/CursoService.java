package com.github.youssfbr.spring.service;

import com.github.youssfbr.spring.entity.Curso;
import com.github.youssfbr.spring.repository.ICursoRepository;
import com.github.youssfbr.spring.service.interfaces.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @Transactional(readOnly = true)
    public ResponseEntity<Curso>  buscarCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .map(curso -> ResponseEntity.ok(curso))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @Transactional
    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public ResponseEntity<Curso>  atualizarCursoPorId(Long id, Curso curso) {
        return cursoRepository.findById(id)
                .map(cursoToUpdate -> {
                    cursoToUpdate.setNome(curso.getNome());
                    cursoToUpdate.setPreco(curso.getPreco());
                    cursoToUpdate.setPessoaInstrutora(curso.getPessoaInstrutora());

                    Curso cursoUpdated = cursoRepository.save(cursoToUpdate);

                    return ResponseEntity.ok(cursoUpdated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Object> excluirCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .map(cursoToDelete -> {
                    cursoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
        })
                .orElse(ResponseEntity.notFound().build());
    }

}
