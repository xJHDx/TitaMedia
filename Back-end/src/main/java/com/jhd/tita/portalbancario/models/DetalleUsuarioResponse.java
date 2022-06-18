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
    private Integer cedula;
    private Long telefono;
    private List<BancoEntities> bancoEntities;

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
        private Integer valorDeuda;
        private Integer valorPagadoDeuda;
        private Integer valorRestanteDeuda;
        private List<DetalleDeudaEntity> detallesPagos;
    }

}
