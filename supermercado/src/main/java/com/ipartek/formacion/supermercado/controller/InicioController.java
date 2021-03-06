package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelo.Alerta;
import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( {"/inicio", "/inicio/"} )
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductoDAO dao;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		dao = ProductoDAO.getIntance();
	} 
	
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		if(null == ConnectionManager.getConnection()) {
			
			//resp.se
			
		}
		
		else {
			
			super.service(req, resp);
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO llamar al DAO de la capa modelo
		ArrayList<Producto> productos = null;
		try {
			productos = dao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productos", productos);
		request.setAttribute("mensajeAlerta", new Alerta("Las mejores ofertas para ti.", Alerta.TIPO_PRIMARY));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
