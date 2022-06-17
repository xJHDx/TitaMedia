package com.jhd.tita.portalbancario.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthRequest {

    private String userName;
    private String password;
}
