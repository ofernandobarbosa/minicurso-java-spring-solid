package br.edu.ifrs.minicurso.springsolidapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.DisciplinaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Disciplina;
import br.edu.ifrs.minicurso.springsolidapi.repository.DisciplinaRepository;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> getAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina getById(int id) throws Exception {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new Exception("Disciplina não encontrada no banco de dados."));
    }

    @Override
    public Disciplina save(DisciplinaDTO disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDto.nome());
        disciplina.setSemestre(disciplinaDto.semestre());
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina update(int id, DisciplinaDTO disciplinaDto) throws Exception {
        Disciplina disciplina = getById(id);
        disciplina.setNome(disciplinaDto.nome());
        disciplina.setSemestre(disciplinaDto.semestre());
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public boolean delete(int id) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}