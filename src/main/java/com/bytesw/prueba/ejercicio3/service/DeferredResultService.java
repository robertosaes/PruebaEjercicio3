package com.bytesw.prueba.ejercicio3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class DeferredResultService {

	public <T> DeferredResult<T> createDeferredResult() {
		return new DeferredResult<T>();
	}

}
