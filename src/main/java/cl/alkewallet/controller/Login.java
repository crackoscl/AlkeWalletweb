package cl.alkewallet.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.alkewallet.model.Usuario;
import cl.alkewallet.service.UsuarioService;
import cl.alkewallet.utils.Validadores;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/views/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		UsuarioService service = new UsuarioService();
		RequestDispatcher dispatcher= request.getRequestDispatcher("views/login.jsp");
		HttpSession session= request.getSession();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		if (pass != null && !pass.isEmpty() && email != null && !email.isEmpty()) {
			
			if (Validadores.validarEmail(email)) {
				usuario.setCorreo_electronico(email);
				usuario.setContrasegna(pass);
				usuario.setIs_super(1);
				
				try {
					ResultSet rs = service.verificarUsuario(usuario);
					if(rs.next()) {
						session.setAttribute("user_id", rs.getString("user_id"));
						session.setAttribute("name", rs.getString("nombre"));
						dispatcher= request.getRequestDispatcher(request.getContextPath());
					}else {
						request.setAttribute("status", "failed");
						request.setAttribute("mensaje", "Usuario no Registrado");	
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else {
				request.setAttribute("status", "failed");
				request.setAttribute("mensaje", "Formato de email inválido");
			}
			
		}else {
			request.setAttribute("status", "failed");
			request.setAttribute("mensaje", "Todos los campos son obligatorios");
		}
		
		dispatcher.forward(request, response);
	}

}
