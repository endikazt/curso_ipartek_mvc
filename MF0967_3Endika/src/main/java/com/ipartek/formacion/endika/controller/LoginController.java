package com.ipartek.formacion.endika.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.endika.model.Alerta;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "administrador";
	private static final String PASSWORD = "123456";
	private final static Logger LOG = Logger.getLogger(LoginController.class);


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
		
		if(USUARIO.equals(user) && PASSWORD.equals(passwd)) {
			
			// Recuperar session del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", user);
			session.setMaxInactiveInterval(60*2); // 5 seg
			
			String base = request.getContextPath();
			
			mensajeAlerta.setTexto("¡Bienvenido " + user + "!");
			mensajeAlerta.setTipo(Alerta.TIPO_SUCCESS);
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);	
			request.getRequestDispatcher("/privado/index.jsp").forward(request, response);	
			
		} else {
			
			mensajeAlerta.setTexto("El usuario no existe o la contraseña es incorrecta.");
			mensajeAlerta.setTipo(Alerta.TIPO_DANGER);
			
			request.setAttribute("mensajeAlerta", mensajeAlerta);	
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}		
		
	}

}
