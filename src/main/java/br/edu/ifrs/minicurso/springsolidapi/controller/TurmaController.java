package br.edu.ifrs.minicurso.springsolidapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.minicurso.springsolidapi.dto.TurmaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Turma;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;
    
    @GetMapping
    public ResponseEntity<List<Turma>> getAll() {
        List<Turma> turmas = turmaService.getAll();
        return ResponseEntity.ok().body(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable int id) {
        Turma turma = turmaService.getById(id);
        return ResponseEntity.ok().body(turma);
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody TurmaDTO turmaDto) {
        Turma turma = turmaService.save(turmaDto);
        return ResponseEntity.ok().body(turma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable int id, @RequestBody TurmaDTO turmaDto) {
        Turma turma = turmaService.update(id, turmaDto);
        return ResponseEntity.ok().body(turma);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean deletado = turmaService.delete(id);        
        if (deletado) {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/{turma_id}/matricular")
    public ResponseEntity<Turma> matricular(@PathVariable int turma_id, @RequestParam int aluno_id) {
        Turma turma = turmaService.matricular(turma_id, aluno_id);
        return ResponseEntity.ok().body(turma);
    }

    @DeleteMapping("/{turma_id}/cancelar-matricula")
    public ResponseEntity<Turma> cancelarMatricula(@PathVariable int turma_id, @RequestParam int aluno_id) {
        Turma turma = turmaService.cancelarMatricula(turma_id, aluno_id);
        return ResponseEntity.ok().body(turma);
    }
    
}
