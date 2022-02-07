package com.api.vendas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data // criar getters e setters
@Entity
@Builder
@NoArgsConstructor // criar construtor sem parametros
@AllArgsConstructor // criar construtor com parametros
@Table(name = "Tb_Cadastro_Thomas")
public class Produto implements Serializable {
    public static final Long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double idade;
    //private BigDecimal quantidade;


}
