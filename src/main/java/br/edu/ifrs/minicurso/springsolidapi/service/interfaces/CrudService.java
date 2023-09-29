package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import java.util.List;

public interface CrudService<T, DTO> {
    List<T> getAll();

    T getById(int id);

    T save(DTO dto);

    T update(int id, DTO dto);

    boolean delete(int id);
}
