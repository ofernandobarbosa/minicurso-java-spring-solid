package br.edu.ifrs.minicurso.springsolidapi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Disciplina {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer semestre;

    @OneToMany(mappedBy = "disciplina")
    private List<Turma> turmas;

}
