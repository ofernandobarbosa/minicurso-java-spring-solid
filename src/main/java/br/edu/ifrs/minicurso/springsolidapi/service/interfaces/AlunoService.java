package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.AlunoDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Aluno;

@Service
public interface AlunoService extends CrudService<Aluno, AlunoDTO> {
    Aluno save(Aluno aluno);
}
