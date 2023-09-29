package br.edu.ifrs.minicurso.springsolidapi.repository;

import br.edu.ifrs.minicurso.springsolidapi.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
