package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloController
 * 
 * Ejemplo para aprender como recibir peticiones del cliente y responderle solo usando SERVLET
 * @see HelloController2 para ver como se hace lo mismo pero con SERVLET + JSP
 * 
 */
@WebServlet("/ejemplo1")
public class HelloController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String TETERA = "tetera";
	private static final String USUARIO = "pepe";
	private static final String PASSWORD = "123456";
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//peticion del cliente
		String userAgent = request.getHeader("User-Agent");		
		String http = request.getProtocol();
		
		//parametros		
		String nombre = request.getParameter("nombre");      
		String password = request.getParameter("password");  
		
		boolean isMovil = false; 
		
		if ( userAgent.toLowerCase().contains("mobile") ) {
			isMovil = true;
		}
		
		//respuesta
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		if ( USUARIO.equals(nombre) && PASSWORD.equals(password)) {
		
			//por defecto response code 200
			response.setStatus(200);
			
			out.print("<html lang=\"es\">");
			out.print("<head>");
			out.print("<meta charset=\"utf-8\">");
			out.print("<title>Título del sitio</title> ");
			out.print("</head>");
			out.print("<body style=\"font-size:36px;\">");
			out.print("<h1>Página Ejemplo1</h1>");
			out.print("<ol>");
			out.print("<li>Version: " + http + "</li>");
			out.print("<li>Tu nagevador es: " + userAgent + "</li>");
			out.print("<li>Nombre: " + nombre + "</li>");
			out.print("<li>Movil: " + isMovil + "</li>");
			out.print("</ol>");
			out.print("</body>");
			out.print("</html>");
			
		}else {
			
			if ( TETERA.equals(nombre) ) {
				
				response.setStatus(418);
				out.print("<h1>TXU TXU</h1>");
				out.print("<img src=\"https://evert.meulie.net/wp-content/uploads/2016/03/Teapot.png\" alt=\"imagen tetera\" />"); 
				
			}else {			
				// no autorizado
				response.setStatus(401);
				out.print("<h1>NO AUTORIZADO</h1>");
			}	
		}	
		
		out.flush();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}