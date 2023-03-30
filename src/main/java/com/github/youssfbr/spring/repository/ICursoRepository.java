package com.github.youssfbr.spring.repository;

import com.github.youssfbr.spring.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
