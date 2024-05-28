package cl.alkewallet.dao;

import cl.alkewallet.model.Transaccion;

public class TransaccionDao extends Dao {

	public int insertar(Transaccion transaccion) {
		String stInsert = "INSERT INTO transaccion(sender_cuenta_id,receiver_cuenta_id,moneda_id,importe,transaction_date) VALUES ('"
				+ transaccion.getSender_cuenta_id() + "','" + transaccion.getReceiver_cuenta_id() + "','"
				+ transaccion.getMoneda_id() + "','" + transaccion.getImporte() + "','"
				+ transaccion.getTransaction_date() + "')";

		int insert = actualizarBaseDatos(stInsert);
		return insert;
	}

}
