package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bancos")
public class BancoEntity {

    @Id
    private Integer bancoId;
    private String nombreBanco;
    private double nit;

}
