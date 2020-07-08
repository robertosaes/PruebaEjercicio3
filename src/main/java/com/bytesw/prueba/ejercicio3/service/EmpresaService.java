package com.bytesw.prueba.ejercicio3.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.bytesw.prueba.ejercicio3.web.model.Empresa;

public interface EmpresaService {

	List<Empresa> getAll() throws NoSuchElementException;
	Empresa getEmpresaById(Integer id) throws NoSuchElementException;
	Boolean insert(@Valid Empresa empresa) throws NoSuchElementException;
	Boolean update(Integer id, @Valid Empresa empresa) throws NoSuchElementException;
	Boolean delete(Integer id) throws NoSuchElementException;
}
