package com.jhd.tita.portalbancario.business;

import com.jhd.tita.portalbancario.entity.UsuarioEntity;
import com.jhd.tita.portalbancario.enums.ErrorEnum;
import com.jhd.tita.portalbancario.exceptions.ApiException;
import com.jhd.tita.portalbancario.models.AuthRequest;
import com.jhd.tita.portalbancario.servicio.PortalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessManager {

    @Autowired
    PortalServices portalServices;

    public UsuarioEntity authManager(AuthRequest authRequest) {
        if(authRequest.getUserName().isEmpty() || authRequest.getPassword().isEmpty()){
            throw new ApiException(ErrorEnum.ERROR_AUTH,"Error en el Usuario");
        }
        return portalServices.getUsuario(authRequest);
    }

}
