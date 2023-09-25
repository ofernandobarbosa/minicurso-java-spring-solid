package br.edu.ifrs.minicurso.springsolidapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.minicurso.springsolidapi.dto.AlunoDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Aluno;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.AlunoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        List<Aluno> alunos = alunoService.getAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable int id) throws Exception {
        Aluno aluno = alunoService.getById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody AlunoDTO alunoDto) {
        Aluno aluno = alunoService.save(alunoDto);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable int id, @RequestBody AlunoDTO alunoDto) throws Exception {
        Aluno aluno = alunoService.update(id, alunoDto);
        return ResponseEntity.ok().body(aluno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean deletado = alunoService.delete(id);        
        if (deletado) {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.NOT_FOUND);
        }
    }
}