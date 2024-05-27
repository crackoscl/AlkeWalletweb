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

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.CuentaService;

/**
 * Servlet implementation class ListarContactos
 */
@WebServlet("/ListarContactos")
public class ListarContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarContactos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/listar_contactos.jsp");
		CuentaService cuentaService = new CuentaService();
		Usuario usuario = new Usuario();
		usuario.setIs_super(0);
		
			try {
				List<Cuenta> cuentas = cuentaService.obtenerCuentas(usuario);
				if(cuentas != null) {
					request.setAttribute("cuentas",cuentas);
				
				}
				else {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
