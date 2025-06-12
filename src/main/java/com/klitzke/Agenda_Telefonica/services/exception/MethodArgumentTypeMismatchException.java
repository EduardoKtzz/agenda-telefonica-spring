package com.klitzke.Agenda_Telefonica.services.exception;

public class MethodArgumentTypeMismatchException extends RuntimeException {
    public MethodArgumentTypeMismatchException() {
        super("Requisição errada, tente novamente!");
    }
}
