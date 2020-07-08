package com.bytesw.prueba.ejercicio3.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.bytesw.prueba.ejercicio3.dao.EmpresaDao;
import com.bytesw.prueba.ejercicio3.service.EmpresaService;
import com.bytesw.prueba.ejercicio3.web.model.Empresa;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpresaServicesImpl implements EmpresaService {

	@NonNull
	private EmpresaDao empresaDao;
	
	@Override
	public List<Empresa> getAll() throws NoSuchElementException {
		return empresaDao.getAll().get();
	}

	@Override
	public Empresa getEmpresaById(Integer id) throws NoSuchElementException {
		return empresaDao.getEmpresaById(id).get();
	}

	@Override
	public Boolean insert(Empresa empresa) throws NoSuchElementException {
		return empresaDao.insert(empresa).get();
	}

	@Override
	public Boolean update(Integer id, Empresa empresa) throws NoSuchElementException {
		return empresaDao.update(id, empresa).get();
	}

	@Override
	public Boolean delete(Integer id) throws NoSuchElementException {
		return empresaDao.delete(id).get();
	}

}
