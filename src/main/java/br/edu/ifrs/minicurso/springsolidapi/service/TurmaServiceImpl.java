package br.edu.ifrs.minicurso.springsolidapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.TurmaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Aluno;
import br.edu.ifrs.minicurso.springsolidapi.model.Disciplina;
import br.edu.ifrs.minicurso.springsolidapi.model.Turma;
import br.edu.ifrs.minicurso.springsolidapi.repository.TurmaRepository;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.AlunoService;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.DisciplinaService;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private AlunoService alunoService;

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
        Disciplina disciplina = disciplinaService.getById(turmaDto.disciplina_id());

        turma.setNome(turmaDto.nome());
        turma.setDisciplina(disciplina);

        return turmaRepository.save(turma);
    }

    @Override
    public Turma update(int id, TurmaDTO turmaDto) throws Exception {
        Turma turma = getById(id);
        Disciplina disciplina = disciplinaService.getById(turmaDto.disciplina_id());

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

    public Turma addAluno(int turma_id, int aluno_id) throws Exception {
        Aluno aluno = alunoService.getById(aluno_id);
        Turma turma = getById(turma_id);

        if (turma.getAlunos().contains(aluno)) {
            throw new IllegalArgumentException("Aluno já está inserido na turma.");
        }

        turma.getAlunos().add(aluno);
        aluno.getTurmas().add(turma);
        turmaRepository.save(turma);
        alunoService.save(aluno);
        return turma;
    }

    public Turma removeAluno(int turma_id, int aluno_id) throws Exception {
        Aluno aluno = alunoService.getById(aluno_id);
        Turma turma = getById(turma_id);

        if (!turma.getAlunos().contains(aluno)) {
            throw new IllegalArgumentException("Aluno não pertenca a turma.");
        }

        turma.getAlunos().remove(aluno);
        aluno.getTurmas().remove(turma);
        turmaRepository.save(turma);
        alunoService.save(aluno);
        return turma;
    }

}
