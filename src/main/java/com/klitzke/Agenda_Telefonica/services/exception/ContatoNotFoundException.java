package com.klitzke.Agenda_Telefonica.services.exception;

public class ContatoNotFoundException extends RuntimeException {
    public ContatoNotFoundException(Long id) {
        super("Contato com ID " + id + " não encontrado.");
    }
}

