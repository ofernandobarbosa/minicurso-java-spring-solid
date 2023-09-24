package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import java.util.List;

import br.edu.ifrs.minicurso.springsolidapi.dto.TurmaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Turma;

public interface TurmaService {
    List<Turma> getAll();

    Turma getById(int id) throws Exception;

    Turma save(TurmaDTO turmaDto) throws Exception;

    Turma update(int id, TurmaDTO turmaDto) throws Exception;

    boolean delete(int id);
}
