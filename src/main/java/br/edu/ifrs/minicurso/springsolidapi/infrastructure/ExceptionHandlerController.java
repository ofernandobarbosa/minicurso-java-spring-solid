package br.edu.ifrs.minicurso.springsolidapi.infrastructure;

import br.edu.ifrs.minicurso.springsolidapi.dto.ExceptionDTO;

import org.springframework.dao.DataIntegrityViolationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> threatDuplicateEntry(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDto = new ExceptionDTO("Valor já inserido no banco de dados.", "400");
        return ResponseEntity.badRequest().body(exceptionDto);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> threatNotFound404(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> threatNotFound404(Exception exception) {
        ExceptionDTO exceptionDto = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDto);
    }
    
}