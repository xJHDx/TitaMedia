package com.jhd.tita.portalbancario.enums;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    TECHNICAL("001","Ocurri� un error inesperado",HttpStatus.INTERNAL_SERVER_ERROR),
	ERROR_AUTH("002", "Valide el UserName o Password valores NULL",HttpStatus.NOT_ACCEPTABLE),
	ERROR_USUARIO("003", "Usuario No Encontrado",HttpStatus.NOT_ACCEPTABLE),
	ERROR_PASSWORD("004", "Password no Valido",HttpStatus.NOT_ACCEPTABLE),
	ERROR_PAGO("005", "El Pago no se Effectual Revisar validation de datos",HttpStatus.NOT_ACCEPTABLE)
	;
	
	private String code;
	private String description;
	private HttpStatus httpCode;
	
	private ErrorEnum(String code, String description,HttpStatus httpCode) {
		this.code=code;
		this.description = description;
		this.httpCode = httpCode;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpCode() {
		return httpCode;
	}
	

}

