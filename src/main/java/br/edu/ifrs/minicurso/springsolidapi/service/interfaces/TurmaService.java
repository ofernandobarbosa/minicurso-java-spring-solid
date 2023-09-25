package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.TurmaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Turma;

@Service
public interface TurmaService {
    List<Turma> getAll();

    Turma getById(int id) throws Exception;

    Turma save(TurmaDTO turmaDto) throws Exception;

    Turma addAluno(int turma_id, int aluno_id) throws Exception;

    Turma removeAluno(int turma_id, int aluno_id) throws Exception;

    Turma update(int id, TurmaDTO turmaDto) throws Exception;

    boolean delete(int id);

}
