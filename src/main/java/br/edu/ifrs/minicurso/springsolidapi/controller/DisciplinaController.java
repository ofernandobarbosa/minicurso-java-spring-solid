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
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.minicurso.springsolidapi.dto.DisciplinaDTO;
import br.edu.ifrs.minicurso.springsolidapi.model.Disciplina;
import br.edu.ifrs.minicurso.springsolidapi.service.interfaces.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    
    @Autowired
    private DisciplinaService disciplinaService;
    
    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll() {
        List<Disciplina> disciplinas = disciplinaService.getAll();
        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getById(@PathVariable int id) {
        Disciplina disciplina = disciplinaService.getById(id);
        return ResponseEntity.ok().body(disciplina);
    }

    @PostMapping
    public ResponseEntity<Disciplina> save(@RequestBody DisciplinaDTO disciplinaDto) {
        Disciplina disciplina = disciplinaService.save(disciplinaDto);
        return ResponseEntity.ok().body(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDto) {
        Disciplina disciplina = disciplinaService.update(id, disciplinaDto);
        return ResponseEntity.ok().body(disciplina);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean deletado = disciplinaService.delete(id);        
        if (deletado) {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.NOT_FOUND);
        }
    }
    
}
