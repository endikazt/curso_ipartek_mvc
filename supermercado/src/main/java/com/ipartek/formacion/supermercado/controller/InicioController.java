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

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.Alerta;
import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.dao.CategoriaDAO;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( {"/inicio", "/inicio/"} )
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioController.class);
	private static ProductoDAO dao;
	private static CategoriaDAO daoCategoria;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		dao = ProductoDAO.getIntance();
		daoCategoria = CategoriaDAO.getIntance();
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
		
		String pCategoria = request.getParameter("categoriaId");
		String pProducto = request.getParameter("producto");
		String pAccion = request.getParameter("accion");
		
		ArrayList<Producto> productos = null;
		ArrayList<Categoria> categorias = null;
		
		LOG.debug(pCategoria + " " + pProducto + " " + pAccion);
		
		Alerta alerta = new Alerta();
		
		if(pAccion == null) {
			
			try {
				productos = dao.getAll();
				categorias = daoCategoria.getAll();
			} catch (Exception e) {
				LOG.error(e);
			}
			
			alerta.setTexto("Las mejores ofertas para ti.");
			alerta.setTipo(Alerta.TIPO_PRIMARY);
			
		} else {
			
			if(!pProducto.trim().equals("") && pProducto != null ) {	
				
				LOG.debug("ENTRANDO A LA PARTE DE OBETENER TODOS POR PARAM");
				
				try {
					
					productos = dao.getAllByCategoriaAndSearchParam(Integer.parseInt(pCategoria), pProducto);
					
					LOG.debug(productos);
					
					categorias = daoCategoria.getAll();
					
				} catch (NumberFormatException e) {
					
					alerta.setTexto("Ha ocurrido un error al procesar la solicitud. Intentelo de nuevo.");
					alerta.setTipo(Alerta.TIPO_DANGER);
					
					try {
						productos = dao.getAll();
						categorias = daoCategoria.getAll();
					} catch (Exception e1) {
						LOG.error(e);
					}
				}
				
				
			} else {
				
				LOG.debug("ENTRANDO A LA PARTE DE OBETENER TODOS POR CATEGORIA");
				
				
				try {
					productos = dao.getAllByCategoria(Integer.parseInt(pCategoria));
					categorias = daoCategoria.getAll();
				} catch (NumberFormatException e) {
					
					alerta.setTexto("Ha ocurrido un error al procesar la solicitud. Intentelo de nuevo.");
					alerta.setTipo(Alerta.TIPO_DANGER);
					
					try {
						productos = dao.getAll();
						categorias = daoCategoria.getAll();
					} catch (Exception e1) {
						LOG.error(e);
					}
				}
				
				
			}

		}
		
		request.setAttribute("productos", productos);
		request.setAttribute("categorias", categorias);
		request.setAttribute("mensajeAlerta", alerta);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
