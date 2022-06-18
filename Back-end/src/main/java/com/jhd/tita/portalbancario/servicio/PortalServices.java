package com.jhd.tita.portalbancario.servicio;

import com.jhd.tita.portalbancario.entity.BancoEntity;
import com.jhd.tita.portalbancario.entity.DetalleDeudaEntity;
import com.jhd.tita.portalbancario.entity.DeudasUsuarioEntity;
import com.jhd.tita.portalbancario.entity.UsuarioEntity;
import com.jhd.tita.portalbancario.enums.ErrorEnum;
import com.jhd.tita.portalbancario.exceptions.ApiException;
import com.jhd.tita.portalbancario.models.AuthRequest;
import com.jhd.tita.portalbancario.models.DetalleUsuarioResponse;
import com.jhd.tita.portalbancario.repository.BancoRepository;
import com.jhd.tita.portalbancario.repository.DetalleDeudaRepository;
import com.jhd.tita.portalbancario.repository.DeudasUsuarioRepository;
import com.jhd.tita.portalbancario.repository.UsuarioRepository;
import com.jhd.tita.portalbancario.utils.BuilderUtils;
import com.jhd.tita.portalbancario.utils.GSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortalServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private DetalleDeudaRepository detalleDeudaRepository;

    @Autowired
    DeudasUsuarioRepository deudasUsuarioRepository;

    @Autowired
    BuilderUtils builderUtils;

    public UsuarioEntity getUsuario(AuthRequest authRequest){
        UsuarioEntity usuario = usuarioRepository.findByUserName(authRequest.getUserName());
        if(usuario == null){
            throw new ApiException(ErrorEnum.ERROR_USUARIO,"las Contraseñas no son iguales");
        }
        if(!usuario.getPassword().equals(authRequest.getPassword())){
           throw new ApiException(ErrorEnum.ERROR_PASSWORD,"las Contraseñas no son iguales");
        }
        return usuario;
    }

    public DetalleUsuarioResponse getDetalleUsuario(String usuarioId){

        UsuarioEntity usuario = usuarioRepository.findByUsuariosId(Long.valueOf(usuarioId));

        List<BancoEntity> bancosAsociados = bancoRepository.findAllBancoIdIn(builderUtils.listToAllSql(usuario.getBancos()));

        List<DeudasUsuarioEntity> deudasAsociadas = deudasUsuarioRepository.findByUsuarioId(Math.toIntExact(usuario.getUsuariosId()));

        List<List<DetalleDeudaEntity>> detallePagos = new ArrayList<>();

        for(DeudasUsuarioEntity deudasUsuario:deudasAsociadas){
            detallePagos.add(detalleDeudaRepository.findByBancoId(deudasUsuario.getBancoId()));
        }
        return builderUtils.MapObjec(usuario,bancosAsociados,deudasAsociadas,detallePagos);
    }


}
