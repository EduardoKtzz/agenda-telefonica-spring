package com.klitzke.Agenda_Telefonica.exception;

import com.klitzke.Agenda_Telefonica.services.exception.ContatoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContatoNotFoundException.class)
    public ResponseEntity<ErrorResponse> tratarContatoNãoEncontrado(ContatoNotFoundException ex, HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Contato não encontrado", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
