package cl.alkewallet.model;

public class Cuenta {

	private String cuenta_id;
	private String num_cuenta;
	private Double saldo;
	private Usuario usuario;
	

	public Cuenta() {
		super();
	}

	public Cuenta(String cuenta_id, String num_cuenta, Double saldo, Usuario usuario) {
		super();
		this.cuenta_id = cuenta_id;
		this.num_cuenta = num_cuenta;
		this.saldo = saldo;
		this.usuario = usuario;
	}

	public String getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(String id_cuenta) {
		this.cuenta_id = id_cuenta;
	}

	public String getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double monto) {
		this.saldo = monto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
