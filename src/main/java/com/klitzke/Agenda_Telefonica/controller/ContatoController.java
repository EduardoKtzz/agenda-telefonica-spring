package com.klitzke.Agenda_Telefonica.controller;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //GET para encontrar pelo "id"
    @GetMapping(value = "/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Long id) {
        Contato contato = service.encontrarPorId(id);
        return ResponseEntity.ok().body(contato);
    }

    //POST para inserir contatos
    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
        contato = service.inserir(contato);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(contato);

    }

    //DELETE para deletar usuarios
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //PUT para atualizar usuarios
    @PutMapping(value = "/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
        contato = service.atualizar(id, contato);
        return ResponseEntity.ok().body(contato);
    }
}
