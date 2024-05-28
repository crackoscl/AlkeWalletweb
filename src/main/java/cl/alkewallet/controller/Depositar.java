package cl.alkewallet.controller;

import java.io.IOException;
import java.sql.SQLException;

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
import cl.alkewallet.utils.Validadores;

/**
 * Servlet implementation class Depositar
 */
@WebServlet("/Depositar")
public class Depositar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Depositar() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/depositar.jsp");
		Usuario usuario = new Usuario();
		CuentaService cuentaService = new CuentaService();

		if (session.getAttribute("user_id") != null) {
			Object userIdObj = session.getAttribute("user_id");
			if (userIdObj != null) {
				String userIdStr = (String) userIdObj;
				usuario.setUser_id(Integer.parseInt(userIdStr));
				try {
					Cuenta cuenta = cuentaService.obtenerCuenta(usuario);
					request.setAttribute("cuenta", cuenta);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/depositar.jsp");
		Cuenta cuenta = new Cuenta();
		CuentaService cuentaService = new CuentaService();
		String monto = request.getParameter("monto");
		String num_cuenta = request.getParameter("num_cuenta");
		String oldsaldo = request.getParameter("oldsaldo");
		

		if (monto != null && !monto.isEmpty() && num_cuenta != null && !num_cuenta.isEmpty()) {
	        double dMonto = Validadores.parseDouble(monto);
	        double doldsaldo = Validadores.parseDouble(oldsaldo);

	        if (dMonto > 0) {
	        	
	            cuenta.setSaldo(doldsaldo+dMonto);
	            cuenta.setNum_cuenta(num_cuenta); 
	          
	            try {
	                int res = cuentaService.updateCuentaSaldo(cuenta);

	                if (res > 0) {
	                	request.setAttribute("cuenta", cuenta);
	                    request.setAttribute("status", "success");
	                    request.setAttribute("mensaje", "Deposito Realizado con éxito");
	                } else {
	                	request.setAttribute("num_cuenta", num_cuenta);
		            	request.setAttribute("oldsaldo", oldsaldo);
	                    request.setAttribute("status", "failed");
	                    request.setAttribute("mensaje", "Error al Depositar");
	                }
	            } catch (Exception e) {
	            	request.setAttribute("num_cuenta", num_cuenta);
	            	request.setAttribute("oldsaldo", oldsaldo);
	                request.setAttribute("status", "failed");
	                request.setAttribute("mensaje", "Error al actualizar el saldo de la cuenta: " + e.getMessage());
	                e.printStackTrace();
	            }
	        } else {
	        	request.setAttribute("num_cuenta", num_cuenta);
            	request.setAttribute("oldsaldo", oldsaldo);
	            request.setAttribute("status", "failed");
	            request.setAttribute("mensaje", "El monto debe ser mayor a 0");
	        }
	    } else {
	    	request.setAttribute("num_cuenta", num_cuenta);
        	request.setAttribute("oldsaldo", oldsaldo);
	        request.setAttribute("status", "failed");
	        request.setAttribute("mensaje", "Ingresa un monto");
	    }

		dispatcher.forward(request, response);

	}
}

