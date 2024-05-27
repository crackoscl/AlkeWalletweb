package cl.alkewallet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.CuentaService;

/**
 * Servlet implementation class Enviar
 */
@WebServlet("/Enviar")
public class Enviar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Enviar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/enviar.jsp");
		CuentaService cuentaService = new CuentaService();
		Usuario usuario = new Usuario();
		usuario.setIs_super(0);

		Usuario usuarioSuper = new Usuario();
		if (session.getAttribute("user_id") != null) {
			Object userIdObj = session.getAttribute("user_id");
			if (userIdObj != null) {
				String userIdStr = (String) userIdObj;
				usuarioSuper.setUser_id(Integer.parseInt(userIdStr));
				try {
					Cuenta cuenta = cuentaService.obtenerCuenta(usuarioSuper);
					request.setAttribute("cuenta", cuenta);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		try {
			List<Cuenta> cuentas = cuentaService.obtenerCuentas(usuario);
			if (cuentas != null) {
				request.setAttribute("cuentas", cuentas);

			} else {
				request.setAttribute("status", "failed");
				request.setAttribute("mensaje", "No se encontraron Registros");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
