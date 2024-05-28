package cl.alkewallet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Usuario;

public class CuentaDao extends Dao {

	public int insertar(Cuenta cuenta) {
		String stInsert = "INSERT INTO cuenta(num_cuenta,saldo,user_id) VALUES ('" + cuenta.getNum_cuenta() + "','"
				+ cuenta.getSaldo() + "','" + cuenta.getUsuario().getUser_id() + "')";

		int insert = actualizarBaseDatos(stInsert);
		return insert;
	}

	public int update(Cuenta cuenta) {
		String stUpdate = "UPDATE cuenta SET num_cuenta = '" + cuenta.getNum_cuenta() + "', saldo = '"
				+ cuenta.getSaldo() + "' WHERE cuenta_id = " + cuenta.getCuenta_id() + "'";

		int insert = actualizarBaseDatos(stUpdate);
		return insert;
	}

	
	public int updateSaldo(Cuenta cuenta) {
		String stUpdate = "UPDATE cuenta SET saldo = '"
				+ cuenta.getSaldo() + "' WHERE num_cuenta = '" + cuenta.getNum_cuenta()+"'";
		int insert = actualizarBaseDatos(stUpdate);
		return insert;
	}
	
	public int delete(Cuenta cuenta) {
		String stUpdate = "DELETE FROM cuenta WHERE id ='" + cuenta.getCuenta_id() + "'";
		int insert = actualizarBaseDatos(stUpdate);
		return insert;
	}

	public Cuenta consultarDatos(Usuario usuario) throws SQLException {
		String query = "SELECT c.num_cuenta, c.saldo, u.rut, u.correo_electronico, u.nombre " + 
                "FROM cuenta c " + 
                "JOIN usuario u ON c.user_id = u.user_id " + 
                "WHERE u.user_id = '" + usuario.getUser_id() + "'";
		realizarConsulta(query);
		if(rs.next()) {
			Cuenta cuenta = new Cuenta();
			usuario.setRut(rs.getString("rut"));
			usuario.setCorreo_electronico(rs.getString("correo_electronico"));
			usuario.setNombre(rs.getString("nombre"));
			cuenta.setNum_cuenta(rs.getString("num_cuenta"));
			cuenta.setSaldo(rs.getDouble("saldo"));
			cuenta.setUsuario(usuario);
			return cuenta;
			
		}
		return null;
		
		
	}
	
	
	public List<Cuenta>listarCuentas(Usuario usuario) throws SQLException {
		List<Cuenta> listaCuentas = new ArrayList<>();
		
		String query = "SELECT c.cuenta_id,c.num_cuenta, c.saldo,u.user_id ,u.rut, u.correo_electronico, u.nombre " + 
                "FROM cuenta c " + 
                "JOIN usuario u ON c.user_id = u.user_id " + 
                "WHERE u.is_super_user = '" + usuario.getIs_super() + "'";
		realizarConsulta(query);
		while(rs.next()) {
			Cuenta cuenta = new Cuenta();
			Usuario user = new Usuario();
			user.setUser_id(rs.getInt("user_id"));
			user.setRut(rs.getString("rut"));
			user.setCorreo_electronico(rs.getString("correo_electronico"));
			user.setNombre(rs.getString("nombre"));
			cuenta.setCuenta_id(rs.getString("cuenta_id"));
			cuenta.setNum_cuenta(rs.getString("num_cuenta"));
			cuenta.setSaldo(rs.getDouble("saldo"));
			cuenta.setUsuario(user);
			listaCuentas.add(cuenta);
			
		}
		return listaCuentas;
	}

}
