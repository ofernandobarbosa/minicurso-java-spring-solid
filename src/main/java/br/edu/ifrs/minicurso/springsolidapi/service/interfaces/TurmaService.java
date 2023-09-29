package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import br.edu.ifrs.minicurso.springsolidapi.dto.TurmaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Turma;

public interface TurmaService extends CrudService<Turma, TurmaDTO> {
    Turma matricular(int turma_id, int aluno_id);

    Turma cancelarMatricula(int turma_id, int aluno_id);
}
