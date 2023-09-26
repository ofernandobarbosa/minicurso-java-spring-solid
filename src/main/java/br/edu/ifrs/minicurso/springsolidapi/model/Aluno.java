package br.edu.ifrs.minicurso.springsolidapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "aluno")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Aluno {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String sobrenome;

    @Column(length = 10, unique = true)
    private String matricula;

    @Column(length = 255, unique = true)
    private String email;
    
    @ManyToMany(mappedBy = "alunos")
    @JsonIgnoreProperties("alunos")
    private List<Turma> turmas;
    
}
