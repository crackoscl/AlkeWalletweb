package cl.alkewallet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.dao.MonedaDao;
import cl.alkewallet.model.Moneda;

public class MonedaService {

	private MonedaDao dao;
	
	public MonedaService() {
		this.dao = new MonedaDao();
	}
	
	
	public int insertarMoneda(Moneda moneda) {
		int resultado = this.dao.insertar(moneda);
		return resultado;
	}
	
	public List<Moneda> obtenerMonedas() throws SQLException {
		List<Moneda> listMonedas = new ArrayList<>();
		
		listMonedas = this.dao.consultarDatos();
		
		return listMonedas;
	}
	
}
