package com.bytesw.prueba.ejercicio3.dao;

import java.util.List;
import java.util.Optional;

import com.bytesw.prueba.ejercicio3.web.model.Empresa;

public interface EmpresaDao {

	Optional<List<Empresa>> getAll();
	Optional<Empresa> getEmpresaById(Integer id);
	Optional<Boolean> insert(Empresa empresa);
	Optional<Boolean> update(Integer id, Empresa empresa);
	Optional<Boolean> delete(Integer id);
}
