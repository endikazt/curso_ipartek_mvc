package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet( {"/private/altausuario", "/private/altausuario/"})
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(FormularioController.class);

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
		
		LOG.debug("Recibiendo peticion");
		
		String base = request.getContextPath();
		
		LOG.debug(base);
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String[] deportes = request.getParameterValues("deportes");
		String sexo = request.getParameter("sexo");
		
		LOG.debug("sexo => " + sexo);
		
		if(!"".equals(nombre) && !"".equals(email) && deportes.length >= 3)
		{
		
		List<String> listaDeportes = new ArrayList<String>();
		listaDeportes = Arrays.asList(deportes);
		
		request.setAttribute("mensaje", "Alta completada correctamente :)");
		request.setAttribute("nombreFormulario", nombre);
		request.setAttribute("emailFormulario", email);
		request.setAttribute("deportesFormulario", listaDeportes);
		
		LOG.debug("Empezando a enviar la peticion");
		
		request.getRequestDispatcher("/private/formulario-ok.jsp").forward(request, response);
		
		} else
		{	
			
			List<String> listaDeportes = new ArrayList<String>();
			listaDeportes = Arrays.asList(deportes);
			
			request.setAttribute("nombreFormulario", nombre);
			request.setAttribute("emailFormulario", email);
			request.setAttribute("deportesFormulario", listaDeportes);
			request.setAttribute("sexoFormulario", sexo);
			request.setAttribute("mensaje", "Error al realizar el alta. Has debido introducir mal algun campo :(");
			request.getRequestDispatcher("/private/formulario.jsp").forward(request, response);
		}
	}

}
