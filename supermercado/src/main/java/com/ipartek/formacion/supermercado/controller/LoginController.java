package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.Alerta;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginController.class);
	private UsuarioDAO dao;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		dao = UsuarioDAO.getIntance();
		
	}

	@Override
	public void destroy() {
		super.destroy();

		dao = null;
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
		
		Alerta mensajeAlerta = new Alerta();
		
		String nombre = request.getParameter("nombre");
		String passwd = request.getParameter("password");
		
		try {
			
			Usuario user = dao.exist(nombre, passwd);
			
			if(user != null ) {
				
				LOG.info("Login correcto - " + user);
				
				// Recuperar session del usuario == browser
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogeado", user);
				session.setMaxInactiveInterval(-1); // 5 seg
				
				String base = request.getContextPath();
				
				mensajeAlerta.setTexto("¡Bienvenido " + user.getNombre() + "!");
				mensajeAlerta.setTipo(Alerta.TIPO_SUCCESS);
				
				request.setAttribute("mensajeAlerta", mensajeAlerta);	
				request.getRequestDispatcher("/seguridad/index.jsp").forward(request, response);	
				
			} else {
				
				mensajeAlerta.setTexto("El usuario no existe o la contraseña es incorrecta.");
				mensajeAlerta.setTipo(Alerta.TIPO_DANGER);
				
				request.setAttribute("mensajeAlerta", mensajeAlerta);	
				request.getRequestDispatcher("login.jsp").forward(request, response);	
			}
		} catch (Exception e) {
			LOG.error(e);
		}		
		
	}

}
