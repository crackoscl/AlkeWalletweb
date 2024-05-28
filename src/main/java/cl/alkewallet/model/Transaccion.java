package cl.alkewallet.model;

public class Transaccion {

	private int transaction_id;
	private int sender_cuenta_id;
	private int receiver_cuenta_id;
	private int moneda_id;
	private Double importe;
	private String transaction_date;
	

	public Transaccion() {
		super();
	}

	public Transaccion(int transaction_id, int sender_cuenta_id, int receiver_cuenta_id, int moneda_id, Double importe,
			String transaction_date) {
		super();
		this.transaction_id = transaction_id;
		this.sender_cuenta_id = sender_cuenta_id;
		this.receiver_cuenta_id = receiver_cuenta_id;
		this.moneda_id = moneda_id;
		this.importe = importe;
		this.transaction_date = transaction_date;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getSender_cuenta_id() {
		return sender_cuenta_id;
	}

	public void setSender_cuenta_id(int sender_cuenta_id) {
		this.sender_cuenta_id = sender_cuenta_id;
	}

	public int getReceiver_cuenta_id() {
		return receiver_cuenta_id;
	}

	public void setReceiver_cuenta_id(int receiver_cuenta_id) {
		this.receiver_cuenta_id = receiver_cuenta_id;
	}

	public int getMoneda_id() {
		return moneda_id;
	}

	public void setMoneda_id(int moneda_id) {
		this.moneda_id = moneda_id;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	
}
