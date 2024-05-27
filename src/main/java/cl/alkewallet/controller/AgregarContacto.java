package cl.alkewallet.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.CuentaService;
import cl.alkewallet.service.UsuarioService;
import cl.alkewallet.utils.Validadores;

/**
 * Servlet implementation class AgregarContacto
 */
@WebServlet("/AgregarContacto")
public class AgregarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarContacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/views/agregar_contacto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		Cuenta cuenta = new Cuenta();
		UsuarioService service = new UsuarioService();
		CuentaService cuentaServ = new CuentaService();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/agregar_contacto.jsp");
		String nombre = request.getParameter("nombre");
		String rut  = request.getParameter("rut");
		String email = request.getParameter("email");
		String numCuenta = request.getParameter("num_cuenta");
		LocalDateTime now = LocalDateTime.now();
		Timestamp timestamp = java.sql.Timestamp.valueOf(now);

		if (nombre != null && !nombre.isEmpty() && rut != null && !rut.isEmpty() 
				&& email != null && !email.isEmpty()) {

			if (Validadores.validarRut(rut) && Validadores.validarEmail(email)) {

				try {
					if (service.verificarEmail(email)) {
						request.setAttribute("status", "failed");
						request.setAttribute("mensaje", "El email ya está registrado");
					} else {
						usuario.setNombre(nombre);
						usuario.setRut(rut);
						usuario.setCorreo_electronico(email);
						usuario.setContrasegna(null);
						usuario.setFecha_creacion(timestamp.toString());
						usuario.setIs_super(0);
						int res = service.insertarUsuario(usuario);
						
						 ResultSet rs = service.verificarUsuario(usuario);
						 if (rs.next()) {
							 usuario.setUser_id(rs.getInt("user_id"));
							 cuenta.setNum_cuenta(numCuenta);
							 cuenta.setSaldo(0.0);
							 cuenta.setUsuario(usuario);
						 }
						 
						 int resCuenta = cuentaServ.insertarCuenta(cuenta);
						 
						 if (res > 0 && resCuenta > 0) {
							request.setAttribute("status", "success");
							request.setAttribute("mensaje", "Registro Realizado con exito");
						} else {
							request.setAttribute("status", "failed");
							request.setAttribute("mensaje", "Error al Guardar");
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("mensaje", "Formato de rut o email inválido");
			}

		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("mensaje", "Todos los campos son obligatorios");
		}
		dispatcher.forward(request, response);

	}

}
