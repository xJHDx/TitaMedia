package com.jhd.tita.portalbancario.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "detalle_deuda")
public class DetalleDeudaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facturaId;
    private int BancoId;
    private int usuarioId;
    private Integer valorPagado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
    private Date fechaPago;


}
