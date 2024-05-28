package cl.alkewallet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.model.Moneda;

public class MonedaDao extends Dao {

	public int insertar(Moneda moneda) {
		String stInsert = "INSERT INTO moneda(currency_name,currency_symbol,tipo_cambio,creationDate) VALUES ('"
				+ moneda.getCurrency_name() + "','" + moneda.getCurrency_symbol() + "','"+moneda.getTipoCambio()+"','" + moneda.getCreationDate()
				+ "')";

		int insert = actualizarBaseDatos(stInsert);
		return insert;
	}

	public int update(Moneda moneda) {
		String stUpdate = "UPDATE moneda SET currency_name = '" + moneda.getCurrency_name() + "', currency_symbol = '"
                + moneda.getCurrency_symbol() + "', tipo_cambio = '" + moneda.getTipoCambio() + "', creationDate = '" + moneda.getCreationDate() + "' WHERE id = "
                + moneda.getCurrency_id();

		int insert = actualizarBaseDatos(stUpdate);
		return insert;

	}

	public int delete(Moneda moneda) {
		String stUpdate = "DELETE FROM moneda WHERE id ='" + moneda.getCurrency_id() + "'";
		int insert = actualizarBaseDatos(stUpdate);
		return insert;
	}
	
	public List<Moneda> consultarDatos() throws SQLException{
		List<Moneda> listaMonedas = new ArrayList<>();
		String query = "SELECT currency_id,currency_name,currency_symbol,tipo_cambio,creationDate FROM moneda";
		realizarConsulta(query);
		
		while(rs.next()){
			Moneda moneda = new Moneda();
			moneda.setCurrency_id(rs.getInt("currency_id"));
			moneda.setCurrency_name(rs.getString("currency_name"));
			moneda.setCurrency_symbol(rs.getString("currency_symbol"));
			moneda.setCreationDate(rs.getString("creationDate"));
			listaMonedas.add(moneda);
		}
		
		return listaMonedas;
		
	}

}
