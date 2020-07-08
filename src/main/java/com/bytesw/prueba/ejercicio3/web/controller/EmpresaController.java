package com.bytesw.prueba.ejercicio3.web.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.bytesw.prueba.ejercicio3.service.DeferredResultService;
import com.bytesw.prueba.ejercicio3.service.EmpresaService;
import com.bytesw.prueba.ejercicio3.web.model.Empresa;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequiredArgsConstructor

public class EmpresaController {

	@NonNull
	private ExecutorService requestExecutorService;
	
	@NonNull
	private DeferredResultService deferredResultService;
	
	@NonNull
	private EmpresaService empresaService;

	@GetMapping
	@ResponseBody
	public DeferredResult<List<Empresa>> getAll() {
		
		DeferredResult<List<Empresa>> result = deferredResultService.createDeferredResult();
		
		requestExecutorService.submit(() -> {
			try {								
				result.setResult(empresaService.getAll());											
			} catch (Exception e) {
				result.setErrorResult(new ResponseEntity<>("Error al obtener las empresas", HttpStatus.BAD_REQUEST));
				e.printStackTrace();
			}
		});
		return result;
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public DeferredResult<Empresa> getEmpresaById(@PathVariable("id") Integer id) {
		DeferredResult<Empresa> result = deferredResultService.createDeferredResult();
		requestExecutorService.submit(() -> {
			try {
				result.setResult(empresaService.getEmpresaById(id));
			} catch (Exception e) {
				result.setErrorResult(new ResponseEntity<>("Error al obtener la empresa", HttpStatus.BAD_REQUEST));
				e.printStackTrace();
			}
		});
		return result;
	}
	
	@PostMapping
	@ResponseBody
	public DeferredResult<Boolean> create(@RequestBody @Valid Empresa empresa) {
		DeferredResult<Boolean> result = deferredResultService.createDeferredResult();
		requestExecutorService.submit(() -> {
			try {
				result.setResult(empresaService.insert(empresa));
			} catch (Exception e) {
				result.setErrorResult(new ResponseEntity<>("Error al crear la empresa", HttpStatus.BAD_REQUEST));
				e.printStackTrace();
			}
		});
		return result;
	}
	
	@PutMapping("{id}")
	@ResponseBody
	public DeferredResult<Boolean> update(@PathVariable("id") Integer id, @RequestBody @Valid Empresa empresa) {
		DeferredResult<Boolean> result = deferredResultService.createDeferredResult();
		requestExecutorService.submit(() -> {
			try {
				result.setResult(empresaService.update(id, empresa));
			} catch (Exception e) {
				result.setErrorResult(new ResponseEntity<>("Error al actualizar la empresa", HttpStatus.BAD_REQUEST));
				e.printStackTrace();
			}
		});
		return result;
	}

	@DeleteMapping("{id}")
	@ResponseBody
	public DeferredResult<Boolean> delete(@PathVariable("id") Integer id) {
		DeferredResult<Boolean> result = deferredResultService.createDeferredResult();
		requestExecutorService.submit(() -> {
			try {
				result.setResult(empresaService.delete(id));
			} catch (Exception e) {
				result.setErrorResult(new ResponseEntity<>("Error al eliminar la empresa", HttpStatus.BAD_REQUEST));
				e.printStackTrace();
			}
		});
		return result;
	}
	
}
