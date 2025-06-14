package com.klitzke.Agenda_Telefonica.config;

import com.klitzke.Agenda_Telefonica.entities.Contato;
import com.klitzke.Agenda_Telefonica.enums.ContatoEnums;
import com.klitzke.Agenda_Telefonica.repository.ContatoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    //Simulando alguns contatos no banco de dados
    @Bean
    CommandLineRunner initDatabase(ContatoRepositorio repositorio) {
        return args -> {
            repositorio.save(new Contato(null, "João Silva", "99999-1234", ContatoEnums.FAVORITO));
            repositorio.save(new Contato(null, "Maria Oliveira", "98888-5678", ContatoEnums.COMUM));
            repositorio.save(new Contato(null, "Carlos Souza", "97777-4321", ContatoEnums.COMUM));
            repositorio.save(new Contato(null, "Suellen Souza", "32323-23232", ContatoEnums.FAVORITO));
            repositorio.save(new Contato(null, "Eduardo Klitke", "4442-332542", ContatoEnums.FAVORITO));
            repositorio.save(new Contato(null, "Pedro Souza", "11145-224344", ContatoEnums.COMUM));
        };
    }

}
