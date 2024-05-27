package cl.alkewallet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.dao.CuentaDao;
import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Usuario;


public class CuentaService {
	

	private CuentaDao dao;

	public CuentaService() {
		this.dao = new CuentaDao();
	}

	public int insertarCuenta(Cuenta cuenta) {
		int resultado = this.dao.insertar(cuenta);
		return resultado;
	}
	
	public int updateCuenta(Cuenta cuenta) {
		int resultado = this.dao.update(cuenta);
		return resultado;
	}
	
	public int updateCuentaSaldo(Cuenta cuenta) {
		int resultado = this.dao.updateSaldo(cuenta);
		return resultado;
	}
	
	public Cuenta obtenerCuenta(Usuario usuario) throws SQLException {
		Cuenta cuenta = this.dao.consultarDatos(usuario);
		return cuenta;
	}
	
	public List<Cuenta> obtenerCuentas(Usuario usuario) throws SQLException {
		List<Cuenta> listCuentas = new ArrayList<>();
		
		listCuentas = this.dao.listarCuentas(usuario);
		
		return listCuentas;
	}
	
	
}
