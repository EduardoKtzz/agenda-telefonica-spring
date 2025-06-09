package com.klitzke.Agenda_Telefonica.services;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.repository.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepositorio repositorio;

    //Buscar todos os contatos no sistema
    public List<Contato> encontrarTodosContatos() {
        return repositorio.findAll();
    }

}
