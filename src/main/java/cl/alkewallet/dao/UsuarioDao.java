package cl.alkewallet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.alkewallet.model.Usuario;

public class UsuarioDao extends Dao {

	public int insertar(Usuario usuario) {
		String stInsert = "INSERT INTO usuario" + "(nombre,rut,correo_electronico,contrasegna,fecha_creacion,is_super_user)"
				+ "VALUES ('" + usuario.getNombre() + "','"+ usuario.getRut() +"','" + usuario.getCorreo_electronico() + "','"
				+ usuario.getContrasegna() + "','" + usuario.getFecha_creacion() + "','"+usuario.getIs_super()+"')";
		int insert = actualizarBaseDatos(stInsert);
		return insert;
	}

	public int update(Usuario usuario) {
		String stUpdate = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "', correo_electronico = '"
				+ usuario.getCorreo_electronico() + "', contrasegna = '" + usuario.getContrasegna()
				+ "',rut = '"+usuario.getRut()+"',fecha_creacion '" + usuario.getFecha_creacion() + "'+" + " WHERE id = " + usuario.getUser_id() + "'";

		int insert = actualizarBaseDatos(stUpdate);
		return insert;

	}

	public int delete(Usuario usuario) {
		String stUpdate = "DELETE FROM usuario WHERE id ='" + usuario.getUser_id() + "'";
		int insert = actualizarBaseDatos(stUpdate);
		return insert;
	}
	
	
	public boolean emailExist(String email) throws SQLException{
		String stSelect = "SELECT COUNT(*) FROM usuario WHERE correo_electronico='" + email + "'";
		realizarConsulta(stSelect);
		if (rs.next()) {
			int count = rs.getInt(1);
			return count > 0;
		}
		return false;
	}
	
	
	public ResultSet userExist(Usuario usuario) throws SQLException {
		String stSelect = "SELECT * FROM usuario WHERE correo_electronico='" + usuario.getCorreo_electronico() + "' and contrasegna='"+usuario.getContrasegna()+"'";
		realizarConsulta(stSelect);
		return rs;
		
	}

}
