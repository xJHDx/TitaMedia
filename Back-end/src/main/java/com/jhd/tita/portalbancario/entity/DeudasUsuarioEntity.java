package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "deudas_usuario")
public class DeudasUsuarioEntity {

    @Id
    private Integer deudaId;
    private Integer usuarioId;
    private Integer bancoId;
    private Integer valorDeuda;
    private Integer valorPagadoDeuda;
    private Integer valorRestanteDeuda;

}
