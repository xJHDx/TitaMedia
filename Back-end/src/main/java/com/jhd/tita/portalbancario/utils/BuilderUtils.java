package com.jhd.tita.portalbancario.utils;

import com.jhd.tita.portalbancario.entity.BancoEntity;
import com.jhd.tita.portalbancario.entity.DetalleDeudaEntity;
import com.jhd.tita.portalbancario.entity.DeudasUsuarioEntity;
import com.jhd.tita.portalbancario.entity.UsuarioEntity;
import com.jhd.tita.portalbancario.models.DetalleUsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuilderUtils {

    public List<Integer> listToAllSql(String list){
        return GSonUtils.toList(list,Integer.class);
    }

    public DetalleUsuarioResponse MapObjec(UsuarioEntity usuario,List<BancoEntity> bancosAsociados,List<DeudasUsuarioEntity> deudasAsociadas,List<List<DetalleDeudaEntity>> detallePagos){

        DetalleUsuarioResponse.DeudasUsuario deudasUsuario = new DetalleUsuarioResponse.DeudasUsuario();

        DetalleUsuarioResponse.BancoEntities bancoEntities;
        for (List<DetalleDeudaEntity> detalleDeudaEntities: detallePagos){
            deudasUsuario =
                    DetalleUsuarioResponse.DeudasUsuario.builder()
                            .detallesPagos(detalleDeudaEntities)
                            .build();
        }
            bancoEntities = DetalleUsuarioResponse.BancoEntities.builder()
                    .nombreBanco("nombre")
                    .deudasUsuario(deudasUsuario)
                    .build();

        return DetalleUsuarioResponse.builder()
                .usuariosId(Math.toIntExact(usuario.getUsuariosId()))
                .nombreApellido(usuario.getNombreApellido())
                .cedula(usuario.getCedula())
                .bancoEntities(bancoEntities)
                .build();
    };

}
