package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloController2
 * Vamos ha relizar el mismo ejercicio pero con una JSP para la response automatica
 * 
 * @see HelloController para ver como hacer esto sin JSP
 * 
 * 
 */
@WebServlet("/ejemplo2")
public class HelloController2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String TETERA = "tetera";
	private static final String USUARIO = "pepe";
	private static final String PASSWORD = "123456";
	private static final String VISTA_RESUMEN = "resumen.jsp";
	private static final String VISTA_NO_PERMISO = "nopermiso.jsp";
	private static final String VISTA_TETERA = "tetera.jsp";
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recibir parametos

		//peticion del cliente
		String userAgent = request.getHeader("User-Agent");		
		String http = request.getProtocol();
		
		//parametros		
		String nombre = request.getParameter("nombre");      
		String password = request.getParameter("password");  
		
		
		//logica de negocio
		
		
		//enviar atributos
		
		request.setAttribute("nombre", nombre);
		
		// request interna del servidor
		request.getRequestDispatcher(VISTA_RESUMEN).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
