package com.jhd.tita.portalbancario.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long usuariosId;
    private String userName;
    private String password;
    private String nombreApellido;
    private Integer cedula;
    private Long telefono;
    private String bancos;

}
