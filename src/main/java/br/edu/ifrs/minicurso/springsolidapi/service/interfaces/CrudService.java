package br.edu.ifrs.minicurso.springsolidapi.service.interfaces;

import java.util.List;

public interface CrudService<T, S> {
    List<T> getAll();

    T getById(int id) throws Exception;

    T save(S dto);

    T update(int id, S dto) throws Exception;

    boolean delete(int id);
}
