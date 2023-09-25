package br.edu.ifrs.minicurso.springsolidapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.minicurso.springsolidapi.dto.AlunoDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Aluno;
import br.edu.ifrs.minicurso.springsolidapi.repository.AlunoRepository;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

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
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno update(int id, AlunoDTO alunoDto) throws Exception {
        Aluno aluno = getById(id);
        aluno.setNome(alunoDto.nome());
        aluno.setSobrenome(alunoDto.sobrenome());
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

}
