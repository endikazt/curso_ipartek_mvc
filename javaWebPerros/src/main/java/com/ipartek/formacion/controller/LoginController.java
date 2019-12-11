package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginController
 */
@WebServlet( {"/login", "/login/"} )
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

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
		
		String user = request.getParameter("nombre");
		String passwd = request.getParameter("contrasena");
		String recuerdame = request.getParameter("recuerdame");
		String idioma = request.getParameter("idioma");
		String mensaje = "";
		
		switch (idioma) {
		case "esp":
			mensaje = "Logueado correctamente.¡Bienvenido a la pagina web!";
			break;
		case "eus":
			mensaje = " Sesio zuzenki hasita. Ongi etorri webgunera!";
			break;
		case "eng":
			mensaje = "Correctly logged. Welcome to the webpage!";
			break;
		case "ita":
			mensaje = "Loggati correcttamente. Benvenuto nel sitio web!";
			break;
		case "fra":
			mensaje = "Bien connecté, bienvenue sur le site !";
			break;

		default:
			break;
		}
		
		if("admin".equals(user) && "admin".equals(passwd)) {
			
			// Recuperar session del usuario == browser
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", "Administrador");
			session.setAttribute("idioma", idioma);
			session.setMaxInactiveInterval(60); // 5 seg
			// session.setMaxInactiveInterval(-1); // nunca caduca
			
			// Recupera del ambito de session los usuarios y añadir el nuevo usuario
			// ServletContext == application scope de la JSP
			// ServletContext applicationScope = request.getServletContext();
			
			// request.setAttribute("recuerdame", recuerdame);
			// request.setAttribute("mensaje", mensaje);	
			
			String base = request.getContextPath();
			
			response.sendRedirect(base + "/private/home");
			
		} else {
			
			mensaje = "El usuario no existe o la contraseña es incorrecta.";
			
			request.setAttribute("mensaje", mensaje);	
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
		
	}

}
