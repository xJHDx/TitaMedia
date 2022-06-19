package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bancos")
public class BancoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bancoId;
    private String nombreBanco;
    private double nit;

}
