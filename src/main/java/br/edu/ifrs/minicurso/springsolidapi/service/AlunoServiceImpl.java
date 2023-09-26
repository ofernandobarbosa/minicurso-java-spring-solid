package br.edu.ifrs.minicurso.springsolidapi.service;

import java.time.Year;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.AlunoDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Aluno;
import br.edu.ifrs.minicurso.springsolidapi.repository.AlunoRepository;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getById(int id) throws Exception {
        return alunoRepository.findById(id).orElseThrow(() -> new Exception("Aluno não encontrado."));
    }

    @Override
    public Aluno save(AlunoDTO alunoDto) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDto.nome());
        aluno.setSobrenome(alunoDto.sobrenome());

        String matricula = generateMatricula();
        while (alunoRepository.existsByMatricula(matricula)) {
            matricula = generateMatricula();
        }

        aluno.setMatricula(matricula);
        aluno.setEmail(generateEmail(alunoDto.nome(), alunoDto.sobrenome()));
        return alunoRepository.save(aluno);
    }

    // Sobrecarga do método de salvar aluno.
    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno update(int id, AlunoDTO alunoDto) throws Exception {
        Aluno aluno = getById(id);
        aluno.setNome(alunoDto.nome());
        aluno.setSobrenome(alunoDto.sobrenome());
        aluno.setEmail(generateEmail(alunoDto.nome(), alunoDto.sobrenome()));
        return alunoRepository.save(aluno);
    }

    @Override
    public boolean delete(int id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private String generateMatricula() {
        Random random = new Random();
        return String.format("%d%06d", Year.now().getValue(), random.nextInt(1000000));
    }

    private String generateEmail(String nome, String sobrenome) {
        return String.format("%s.%s@aluno.riogrande.ifrs.edu.br", nome.toLowerCase(), sobrenome.toLowerCase());
    }
}
