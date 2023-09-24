package br.edu.ifrs.minicurso.springsolidapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifrs.minicurso.springsolidapi.dto.TurmaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Disciplina;
import br.edu.ifrs.minicurso.springsolidapi.model.Turma;
import br.edu.ifrs.minicurso.springsolidapi.repository.TurmaRepository;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.TurmaService;

public class TurmaServiceImpl implements TurmaService{

    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private DisciplinaServiceImpl disciplinaServiceImpl;

    @Override
    public List<Turma> getAll() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma getById(int id) throws Exception {
        return turmaRepository.findById(id).orElseThrow(() -> new Exception("Turma não encontrada."));
    }

    @Override
    public Turma save(TurmaDTO turmaDto) throws Exception {
        Turma turma = new Turma();
        Disciplina disciplina = disciplinaServiceImpl.getById(turmaDto.disciplina_id());

        turma.setNome(turmaDto.nome());
        turma.setDisciplina(disciplina);
        
        return turmaRepository.save(turma);
    }

    @Override
    public Turma update(int id, TurmaDTO turmaDto) throws Exception {
        Turma turma = getById(id);
        Disciplina disciplina = disciplinaServiceImpl.getById(turmaDto.disciplina_id());

        turma.setNome(turmaDto.nome());
        turma.setDisciplina(disciplina);
        
        return turmaRepository.save(turma);
    }

    @Override
    public boolean delete(int id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
