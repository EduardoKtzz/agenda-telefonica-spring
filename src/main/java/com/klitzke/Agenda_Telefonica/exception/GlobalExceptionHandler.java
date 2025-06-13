package com.klitzke.Agenda_Telefonica.exception;

import com.klitzke.Agenda_Telefonica.services.exception.ContatoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

        ErrorResponse erro1 = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Parâmetro inválido", mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro1);
    }

    @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<ErrorResponse> parametroInvalido(NoResourceFoundException exception, HttpServletRequest request) {

        String mensagem = exception.getMessage();

        ErrorResponse erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Parâmetro inválido", mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> usuarioRepetido(DataIntegrityViolationException exception, HttpServletRequest request) {

        String menssagem = "Dados repetidos, verifique se esse usuario já existe.";

        ErrorResponse erro = new ErrorResponse(HttpStatus.CONFLICT.value(), "Número de telefone repetido.", menssagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

}
