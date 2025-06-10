package com.klitzke.Agenda_Telefonica.services;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.enums.ContatoEnums;
import com.klitzke.Agenda_Telefonica.repository.ContatoRepositorio;
import com.klitzke.Agenda_Telefonica.services.exception.ContatoNotFoundException;
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

    //Buscar por "ID"
    public Contato encontrarPorId(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    //Buscar pelo tipo de contato - favoritos
    public List<Contato> findByContatoTipo() {
        return repositorio.findByContatoTipo(ContatoEnums.FAVORITO);
    }

    //Criar contato
    public Contato inserir(Contato contato) {
        return repositorio.save(contato);
    }

    //Deletar usuarios
    public void deletar(Long id) {
        if (!repositorio.existsById(id)) throw new ContatoNotFoundException(id);
        repositorio.deleteById(id);
    }

    //Atualizar usuarios
    public Contato atualizar(Long id, Contato contato) {
        Contato entidade = repositorio.findById(id).orElseThrow(() -> new ContatoNotFoundException(id));

        entidade.setNome(contato.getNome());
        entidade.setNumero(contato.getNumero());
        entidade.setContatoTipo(contato.getContatoTipo());

        return repositorio.save(entidade);
    }
}

