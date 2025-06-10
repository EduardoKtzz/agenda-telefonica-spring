package com.klitzke.Agenda_Telefonica.repository;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.enums.ContatoEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long> {

    List<Contato> findByContatoTipo(ContatoEnums contatoTipo);

}
