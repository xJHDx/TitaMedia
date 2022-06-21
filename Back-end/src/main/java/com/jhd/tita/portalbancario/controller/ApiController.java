package com.jhd.tita.portalbancario.controller;

import com.jhd.tita.portalbancario.business.BusinessManager;
import com.jhd.tita.portalbancario.entity.DetalleDeudaEntity;
import com.jhd.tita.portalbancario.models.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ApiController {

    @Autowired
    BusinessManager businessManager;

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("/version")
    public ResponseEntity<?> version(){
        return new ResponseEntity<>(version, HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<?> authManger(@RequestBody AuthRequest authRequest){
        return new ResponseEntity<>(businessManager.authManager(authRequest),HttpStatus.OK);
    }

    @GetMapping("/detalleUsuario")
    public ResponseEntity<?> ListaBancosUsuario(@RequestParam String id){
        return new ResponseEntity<>(businessManager.detalleBancoUsuario(id),HttpStatus.OK);
    }

    @PostMapping("/RealizarPago")
    public ResponseEntity<?> RealizarPagoDeuda(@RequestBody DetalleDeudaEntity detalleDeudaEntity){
        return new ResponseEntity<>(businessManager.efectuarPago(detalleDeudaEntity),HttpStatus.OK);
    }

}
