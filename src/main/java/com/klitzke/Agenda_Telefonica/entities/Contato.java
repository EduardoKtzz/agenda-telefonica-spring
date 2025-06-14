package com.klitzke.Agenda_Telefonica.entities;

import com.klitzke.Agenda_Telefonica.enums.ContatoEnums;
import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_nome")
public class Contato implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    //Definindo que a coluna não aceita números repetidos
    @Column(unique = true)
    private String numero;

    //Associações
    @Enumerated(EnumType.STRING)
    private ContatoEnums contatoTipo;

}