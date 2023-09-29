package br.edu.ifrs.minicurso.springsolidapi.service;

public class ServiceException extends RuntimeException  {
    
    public ServiceException(String message) {
        super(message);
    }
    
}
