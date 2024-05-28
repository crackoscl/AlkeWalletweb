package cl.alkewallet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Moneda;
import cl.alkewallet.model.Transaccion;
import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.CuentaService;
import cl.alkewallet.service.MonedaService;
import cl.alkewallet.service.TransaccionService;
import cl.alkewallet.utils.ApiMonedas;

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
		LocalDateTime now = LocalDateTime.now();
		Timestamp timestamp = java.sql.Timestamp.valueOf(now);
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
		
		MonedaService monedaS = new MonedaService();
		List<Moneda> listaMonedas;
		try {
			listaMonedas = monedaS.obtenerMonedas();
			if (listaMonedas.size() > 0) {
				request.setAttribute("listaMonedas", listaMonedas);
			} else {
				if(ApiMonedas.GetIndicadores()!= null) {
					JsonObject dataMonedas = ApiMonedas.GetIndicadores();
					JsonObject dolar = dataMonedas.getAsJsonObject("dolar");
					JsonObject euro = dataMonedas.getAsJsonObject("euro");
					Moneda moneda = new Moneda();
					moneda.setCurrency_name(dolar.get("codigo").getAsString());
					moneda.setCurrency_symbol("$");
					moneda.setTipoCambio(dolar.get("valor").getAsDouble());
					moneda.setCreationDate(timestamp.toString());
					monedaS.insertarMoneda(moneda);
					moneda.setCurrency_name(euro.get("codigo").getAsString());
					moneda.setCurrency_symbol("€");
					moneda.setTipoCambio(euro.get("valor").getAsDouble());
					moneda.setCreationDate(timestamp.toString());
					monedaS.insertarMoneda(moneda);
					
				}
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/enviar.jsp");
		HttpSession session = request.getSession();
		Transaccion transaccion = new Transaccion();
		TransaccionService tsService = new TransaccionService();
		String cuenta = request.getParameter("cuentaId");
		String monedaId = request.getParameter("monedaId");
		String monto = request.getParameter("monto");
		String numCuentaP =request.getParameter("numCuenta");
		String[] values = cuenta.split("-");
		String cuentaId = values[0];
		String numCuenta = values[1];
		
		/*
		 * transaccion.setSender_cuenta_id(numCuentaP);
		 * transaccion.setReceiver_cuenta_id(cuentaId);
		 * transaccion.setMoneda_id(monedaId); transaccion.setImporte();
		 */
		
		dispatcher.forward(request, response);
	}

}
