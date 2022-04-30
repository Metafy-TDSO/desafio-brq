package com.fiap.brq.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpException {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDefault> badRequest(BadRequestException e, HttpServletRequest request) {
	String error = "Solicitação falhou";
	HttpStatus status = HttpStatus.BAD_REQUEST;
	ErrorDefault err = new ErrorDefault(Instant.now(), status.value(), error, e.getMessage(),
		request.getRequestURI());
	return ResponseEntity.status(status).body(err);

    };
}
