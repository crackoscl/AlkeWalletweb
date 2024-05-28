package cl.alkewallet.service;


import cl.alkewallet.dao.TransaccionDao;
import cl.alkewallet.model.Transaccion;

public class TransaccionService {
	
	
	private TransaccionDao dao;

	public TransaccionService() {
		this.dao = new TransaccionDao();
	}

	public int insertarCuenta(Transaccion transaccion) {
		int resultado = this.dao.insertar(transaccion);
		return resultado;
	}
	
}
