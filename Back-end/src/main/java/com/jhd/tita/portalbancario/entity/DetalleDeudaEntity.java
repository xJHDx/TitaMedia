package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "detalle_deuda")
public class DetalleDeudaEntity {

    @Id
    private Integer facturaId;
    private int BancoId;
    private int usuarioId;
    private Integer valorPagado;
    private Date fechaPago;


}
