package com.jhd.tita.portalbancario.models;

import com.jhd.tita.portalbancario.entity.DetalleDeudaEntity;
import com.jhd.tita.portalbancario.entity.DeudasUsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalleUsuarioResponse {

    private Integer usuariosId;
    private String nombreApellido;
    private double cedula;
    private BancoEntities bancoEntities;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BancoEntities{
        private Integer bancoId;
        private String nombreBanco;
        private DeudasUsuario deudasUsuario;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeudasUsuario{
        private Integer deudaId;
        private double valorDeuda;
        private double valorPagadoDeuda;
        private double valorRestanteDeuda;
        private List<DetalleDeudaEntity> detallesPagos;
    }

}
