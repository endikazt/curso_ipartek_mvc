package com.ipartek.formacion.endika.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.endika.dao.LibroDAO;
import com.ipartek.formacion.endika.model.Alerta;
import com.ipartek.formacion.endika.model.Libro;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( {"/inicio", "/inicio/"} )
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LibroDAO dao;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		dao = LibroDAO.getInstance();
	} 
	
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO llamar al DAO de la capa modelo
		ArrayList<Libro> libros = dao.getAll();
		
		request.setAttribute("libros", libros);
		request.setAttribute("mensajeAlerta", new Alerta("Bienvenido a la libreria :)", Alerta.TIPO_PRIMARY));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
