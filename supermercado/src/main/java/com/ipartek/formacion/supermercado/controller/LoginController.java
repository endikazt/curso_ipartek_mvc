package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.modelo.Alerta;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "admin";
	private static final String PASSWORD = "admin";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alerta mensajeAlerta = new Alerta();
		
		String user = request.getParameter("nombre");
		String passwd = request.getParameter("password");
		
		if("admin".equals(user) && "admin".equals(passwd)) {
			
			// Recuperar session del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", user);
			session.setMaxInactiveInterval(-1); // 5 seg
			
			String base = request.getContextPath();
			
			mensajeAlerta.setTexto("¡Bienvenido " + user + "!");
			mensajeAlerta.setTipo(Alerta.TIPO_SUCCESS);
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);	
			request.getRequestDispatcher("/seguridad/index.jsp").forward(request, response);	
			
		} else {
			
			mensajeAlerta.setTexto("El usuario no existe o la contraseña es incorrecta.");
			mensajeAlerta.setTipo(Alerta.TIPO_DANGER);
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);	
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}		
		
	}

}
