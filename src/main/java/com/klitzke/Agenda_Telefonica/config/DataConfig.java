package com.klitzke.Agenda_Telefonica.config;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.repository.ContatoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner initDatabase(ContatoRepositorio repositorio) {
        return args -> {
            repositorio.save(new Contato(null, "João Silva", "99999-1234"));
            repositorio.save(new Contato(null, "Maria Oliveira", "98888-5678"));
            repositorio.save(new Contato(null, "Carlos Souza", "97777-4321"));
        };
    }


}
