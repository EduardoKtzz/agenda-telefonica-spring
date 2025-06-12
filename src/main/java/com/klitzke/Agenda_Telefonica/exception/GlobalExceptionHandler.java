package com.klitzke.Agenda_Telefonica.exception;

import com.klitzke.Agenda_Telefonica.services.exception.ContatoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContatoNotFoundException.class)
    public ResponseEntity<ErrorResponse> tratarContatoNãoEncontrado(ContatoNotFoundException ex, HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Contato não encontrado", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> requisicaoInvalida (MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
        String campo = exception.getName(); // nome do parâmetro (tipo)
        String valor = exception.getValue().toString(); // valor que o usuário passou

        String mensagem = String.format("Valor inválido '%s' para o parâmetro '%s'. Os valores aceitos são: FAVORITO, COMUM.", valor, campo);

        ErrorResponse erro1 = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Requição invalida, tente novamente!", exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro1);
    }
}
