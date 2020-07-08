package com.bytesw.prueba.ejercicio3.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/test")
@Validated
@Component
@RequiredArgsConstructor
public class TestController {
	@NonNull
	private JdbcTemplate jdbcTemplate;
	@RequestMapping(method = RequestMethod.GET, path = "/service",
	             produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String service()
	     throws Exception {
		return "Ejercicio3 REST is online";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/database",
	            produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String database()
	    throws Exception {
	    int result = jdbcTemplate.queryForObject("SELECT 1", int.class);
	    
	    if (result == 1) {
	    	return "Ejercicio3 is conected to database";
	    } else {
	    	return "Ejercicio3 is not conected to database";
	    }
	}
	
}
