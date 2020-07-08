package com.bytesw.prueba.ejercicio3.web.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
	
	private Integer id;
	private String nombre;
	private String nit;
	private Date fechaFundacion;
	private String direccion;

}
