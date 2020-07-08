package com.bytesw.prueba.ejercicio3.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.bytesw.prueba.ejercicio3.dao.EmpresaDao;
import com.bytesw.prueba.ejercicio3.web.model.Empresa;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpresaDaoImpl implements EmpresaDao {

	@NonNull
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Optional<List<Empresa>> getAll() {

		String sql = "SELECT ID, NOMBRE, NIT, FECHA_FUNDACION, DIRECCION FROM EMPRESA";
		System.out.println("SQL[" + sql + "]");

		try {
			return Optional.ofNullable(jdbcTemplate.query(sql, (RowMapper<Empresa>) (rs, rowNum) -> Empresa.builder()
					.id(rs.getInt("ID")).nombre(rs.getString("NOMBRE")).nit(rs.getString("NIT"))
					.fechaFundacion(rs.getDate("FECHA_FUNDACION")).direccion(rs.getString("DIRECCION")).build()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Empresa> getEmpresaById(Integer id) {
		String sql = "SELECT ID, NOMBRE, NIT, FECHA_FUNDACION, DIRECCION FROM EMPRESA WHERE ID = :id";
		System.out.println("SQL[" + sql + "]");

		try {
			return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new MapSqlParameterSource().addValue("id", id),
					(RowMapper<Empresa>) (rs, rowNum) -> Empresa.builder().id(rs.getInt("ID"))
							.nombre(rs.getString("NOMBRE")).nit(rs.getString("NIT"))
							.fechaFundacion(rs.getDate("FECHA_FUNDACION")).direccion(rs.getString("DIRECCION"))
							.build()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> insert(Empresa empresa) {
		try {

			String SQL = "INSERT INTO EMPRESA(NOMBRE, NIT, FECHA_FUNDACION, DIRECCION) "
					+ "VALUES (:nombre, :nit, :fechaFundacion, :direccion)";

			System.out.println(SQL);

			int resultado = jdbcTemplate.update(SQL,
					new MapSqlParameterSource().addValue("nombre", empresa.getNombre())
							.addValue("nit", empresa.getNit())
							.addValue("fechaFundacion", empresa.getFechaFundacion())
							.addValue("direccion", empresa.getDireccion()));

			return Optional.of(resultado == 1);

		} catch (EmptyResultDataAccessException e) {
			return Optional.of(false);
		}
	}

	@Override
	public Optional<Boolean> update(Integer id, Empresa empresa) {
		try {
			String SQL="UPDATE EMPRESA SET NOMBRE = :nombre, NIT = :nit , FECHA_FUNDACION = :fechaFundacion, DIRECCION = :direccion "
				+ " WHERE ID = :id ";
		
			System.out.println(SQL);
			
			int resultado=jdbcTemplate.update(
					SQL,
					new MapSqlParameterSource().addValue("id",  id).addValue("nombre", empresa.getNombre())
					.addValue("nit", empresa.getNit())
					.addValue("fechaFundacion", empresa.getFechaFundacion())
					.addValue("direccion", empresa.getDireccion()));

			
			return Optional.of(resultado==1);
						
		} catch (EmptyResultDataAccessException e) {
			return Optional.of(false);
		}	}

	@Override
	public Optional<Boolean> delete(Integer id) {
		
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("id", id);
			
			boolean result = (jdbcTemplate.update("DELETE FROM EMPRESA WHERE ID = :id", parameters)) > 0;
			
			return Optional.of(result);
	}

}
