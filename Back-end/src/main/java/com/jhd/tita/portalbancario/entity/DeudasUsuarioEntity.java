package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deudas_usuario")
public class DeudasUsuarioEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer deudaId;
    private Integer usuarioId;
    private Integer bancoId;
    private Integer valorDeuda;
    private Integer valorPagadoDeuda;
    private Integer valorRestanteDeuda;

}
