package com.jhd.tita.portalbancario.utils;

import com.jhd.tita.portalbancario.entity.BancoEntity;
import com.jhd.tita.portalbancario.entity.DetalleDeudaEntity;
import com.jhd.tita.portalbancario.entity.DeudasUsuarioEntity;
import com.jhd.tita.portalbancario.entity.UsuarioEntity;
import com.jhd.tita.portalbancario.models.DetalleUsuarioResponse;
import com.jhd.tita.portalbancario.repository.DetalleDeudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuilderUtils {

    @Autowired
    private DetalleDeudaRepository detalleDeudaRepository;

    public List<Integer> listToAllSql(String list){
        return GSonUtils.toList(list,Integer.class);
    }

    public DetalleUsuarioResponse MapObjec(UsuarioEntity usuario,List<BancoEntity> bancosAsociados,List<DeudasUsuarioEntity> deudasAsociadas){

        List<DetalleUsuarioResponse.BancoEntities> bancoEntities = new ArrayList<>();

        for(BancoEntity banco:bancosAsociados){

            DeudasUsuarioEntity du = deudasAsociadas.stream().filter(da-> da.getBancoId() == banco.getBancoId()).collect(Collectors.toList()).get(0);

            bancoEntities.add(DetalleUsuarioResponse.BancoEntities.builder()
                            .bancoId(banco.getBancoId())
                            .nombreBanco(banco.getNombreBanco())
                            .deudasUsuario(DetalleUsuarioResponse.DeudasUsuario.builder()
                                    .deudaId(du.getDeudaId())
                                    .valorDeuda(du.getValorDeuda())
                                    .valorPagadoDeuda(du.getValorPagadoDeuda())
                                    .valorRestanteDeuda(du.getValorRestanteDeuda())
                                    .detallesPagos(detalleDeudaRepository.findByBancoIdAndUsuarioId(banco.getBancoId(),usuario.getUsuariosId()))
                                    .build())
                    .build());

        }

        return DetalleUsuarioResponse.builder()
                .usuariosId(Math.toIntExact(usuario.getUsuariosId()))
                .nombreApellido(usuario.getNombreApellido())
                .cedula(usuario.getCedula())
                .telefono(usuario.getTelefono())
                .bancoEntities(bancoEntities)
                .build();
    };

}
