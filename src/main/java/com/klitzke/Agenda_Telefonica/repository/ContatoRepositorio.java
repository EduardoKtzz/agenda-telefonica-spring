package com.klitzke.Agenda_Telefonica.repository;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long> {
}
