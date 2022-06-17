package com.jhd.tita.portalbancario.exceptions;

import com.jhd.tita.portalbancario.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException{

	 private ErrorEnum error;
     private String message;

}

