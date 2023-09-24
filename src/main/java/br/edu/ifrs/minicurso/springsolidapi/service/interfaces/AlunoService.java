package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.AlunoDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Aluno;

@Service
public interface AlunoService {

    List<Aluno> getAll();

    Aluno getById(int id) throws Exception;

    Aluno save(AlunoDTO alunoDto);

    Aluno update(int id, AlunoDTO alunoDto) throws Exception;

    boolean delete(int id);
}
