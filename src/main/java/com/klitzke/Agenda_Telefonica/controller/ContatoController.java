package com.klitzke.Agenda_Telefonica.controller;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/contatos")  ////http://localhost:8080/controller
public class ContatoController {

    //Associações
    @Autowired
    private ContatoService service;

    //GET para pegar todos os contatos
    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        List<Contato> contatos = service.encontrarTodosContatos();
        return ResponseEntity.ok().body(contatos);
    }
}
