package cl.alkewallet.model;

public class Usuario {
	private int user_id;
	private String nombre;
	private String correo_electronico;
	private String rut;
	private String contrasegna;
	private String fecha_creacion;
	private int is_super;

	
	public Usuario() {
		super();
	}

	public Usuario(int user_id, String nombre, String correo_electronico, String rut, String contrasegna,
			String fecha_creacion) {
		super();
		this.user_id = user_id;
		this.nombre = nombre;
		this.correo_electronico = correo_electronico;
		this.rut = rut;
		this.contrasegna = contrasegna;
		this.fecha_creacion = fecha_creacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getIs_super() {
		return is_super;
	}

	public void setIs_super(int i) {
		this.is_super = i;
	}
	
	

}
