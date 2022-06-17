package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "usuariosId")
    private Long usuariosId;
    private String userName;
    private String password;
    private String nombreApellido;
    private double cedula;
    private double telefono;
    private String bancos;
}
