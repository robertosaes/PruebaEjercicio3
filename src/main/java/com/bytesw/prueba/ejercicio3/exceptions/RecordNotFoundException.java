package com.bytesw.prueba.ejercicio3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RecordNotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = -4915826336243487877L;

	public RecordNotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}
