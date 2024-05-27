package cl.alkewallet.model;

public class Moneda {

	private int currency_id;
	private String currency_name;
	private String currency_symbol;
	private String creationDate;
	private Double tipoCambio;

	public Moneda() {
		super();
	}

	public Moneda(int currency_id, String currency_name, String currency_symbol, String creationDate,
			Double tipoCambio) {
		super();
		this.currency_id = currency_id;
		this.currency_name = currency_name;
		this.currency_symbol = currency_symbol;
		this.creationDate = creationDate;
		this.tipoCambio = tipoCambio;
	}

	public String getCurrency_name() {
		return currency_name;
	}

	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}

	public String getCurrency_symbol() {
		return currency_symbol;
	}

	public void setCurrency_symbol(String string) {
		this.currency_symbol = string;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String string) {
		this.creationDate = string;
	}

	public int getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
