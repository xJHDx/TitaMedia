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

import java.util.List;
import java.util.Objects;

@Service
public class PortalServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    DeudasUsuarioRepository deudasUsuarioRepository;

    @Autowired
    private DetalleDeudaRepository detalleDeudaRepository;

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

        return builderUtils.MapObjec(usuario,bancosAsociados,deudasAsociadas);
    }


    public String LogicPago(DetalleDeudaEntity detalleDeudaEntity){

        System.out.println(detalleDeudaEntity);
        DeudasUsuarioEntity deudasUsuario = new DeudasUsuarioEntity();


        try {
            deudasUsuario = deudasUsuarioRepository.findByBancoIdAndUsuarioId(detalleDeudaEntity.getBancoId(),detalleDeudaEntity.getUsuarioId());
            System.out.println(deudasUsuario);
            if( deudasUsuario.getValorRestanteDeuda()  < detalleDeudaEntity.getValorPagado() ){
                throw new ApiException(ErrorEnum.ERROR_PAGO,"Valor a pagar es mayor al valor que debe");
            }
            Integer nuevoValorPagado = deudasUsuario.getValorPagadoDeuda() + detalleDeudaEntity.getValorPagado();
            deudasUsuario.setValorPagadoDeuda(nuevoValorPagado);

            Integer nuevoValorRestante = deudasUsuario.getValorRestanteDeuda() - detalleDeudaEntity.getValorPagado();
            deudasUsuario.setValorRestanteDeuda(nuevoValorRestante);

            deudasUsuarioRepository.save(deudasUsuario);
            detalleDeudaRepository.save(detalleDeudaEntity);

        }catch (Exception e){
            throw new ApiException(ErrorEnum.ERROR_PAGO,"Valor a pagar es mayor al valor que debe");
        }
        return "Pago Exitoso";
    }

    public List<UsuarioEntity> getUsuarios(){
        return usuarioRepository.findAll();
    }

}
