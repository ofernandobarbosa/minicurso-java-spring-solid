package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.DisciplinaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Disciplina;

@Service
public interface DisciplinaService {
    List<Disciplina> getAll();

    Disciplina getById(int id) throws Exception;

    Disciplina save(DisciplinaDTO disciplinaDto);

    Disciplina update(int id, DisciplinaDTO disciplinaDto) throws Exception;

    boolean delete(int id);
}
