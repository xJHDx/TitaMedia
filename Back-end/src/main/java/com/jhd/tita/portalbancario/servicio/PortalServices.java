package com.jhd.tita.portalbancario.servicio;

import com.jhd.tita.portalbancario.entity.UsuarioEntity;
import com.jhd.tita.portalbancario.enums.ErrorEnum;
import com.jhd.tita.portalbancario.exceptions.ApiException;
import com.jhd.tita.portalbancario.models.AuthRequest;
import com.jhd.tita.portalbancario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> getUsuarioAll() {
        return usuarioRepository.findAll();
    }

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

}
