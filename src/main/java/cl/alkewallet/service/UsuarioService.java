package cl.alkewallet.service;


import java.sql.ResultSet;
import java.sql.SQLException;

import cl.alkewallet.dao.UsuarioDao;
import cl.alkewallet.model.Usuario;

public class UsuarioService {

	private UsuarioDao dao;
	
	public UsuarioService() {
		this.dao = new UsuarioDao();
	}
	
	public int insertarUsuario(Usuario usuario) {
		int resultado = this.dao.insertar(usuario);
		return resultado;
	}
	
	
	public boolean verificarEmail(String email) throws SQLException {
		boolean resultado = this.dao.emailExist(email);
		return resultado;
	}
	
	public ResultSet verificarUsuario(Usuario usuario) throws SQLException {
		ResultSet resultado = this.dao.userExist(usuario);
		return resultado;
	}
	
	
}
