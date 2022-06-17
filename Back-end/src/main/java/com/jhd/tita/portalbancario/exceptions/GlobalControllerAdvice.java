package com.jhd.tita.portalbancario.exceptions;

import com.jhd.tita.portalbancario.enums.ErrorEnum;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(Throwable.class) 
    public ResponseEntity<ApiException> problem(final Throwable e) {
    	String message = "Ocurrio un error procesando su solicitud, contacte al administrador del sistema. Error causado por: "+e.getMessage()+" -> ";
    	if(e.getCause() != null) {
    		message += e.getCause().getMessage()+" -> ";
    	}
    	if(e.getStackTrace() != null && e.getStackTrace().length > 0) {
    		
    		for(StackTraceElement element : e.getStackTrace()) {
    			message += element +":"+ element+ " -> ";	
    		}
    	}
    	List<GeneralErrorResponse> r = new ArrayList<>();		
		r.add(new GeneralErrorResponse(String.valueOf(ErrorEnum.TECHNICAL.getCode()), message));

		return new ResponseEntity(r, ErrorEnum.TECHNICAL.getHttpCode());
    }
    
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiException> handleApiException(ApiException ex) {
		String message = ex.getMessage();
		
		List<GeneralErrorResponse> r = new ArrayList<>();		
		r.add(new GeneralErrorResponse(ex.getError().getCode(), ex.getError().getDescription()));

		return new ResponseEntity(r, ex.getError().getHttpCode());
    }
   
}

