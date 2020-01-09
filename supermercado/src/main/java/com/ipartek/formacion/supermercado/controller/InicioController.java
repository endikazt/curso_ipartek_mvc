package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
		daoCategoria = null;
		
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if ( null == ConnectionManager.getConnection() ) {
			
			resp.sendRedirect( req.getContextPath() + "/error.jsp");
			
		} else {
		
			// llama a GET o POST
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
		
		Alerta alerta = new Alerta();
		
		alerta.setTexto("Las mejores ofertas para ti.");
		alerta.setTipo(Alerta.TIPO_PRIMARY);
		
		if(pAccion == null) {  					// Si la variable pAccion es null lista todos los productos
			
			LOG.trace("Listar todos los productos.");
			
			try {
				productos = dao.getAll();
				categorias = daoCategoria.getAll();
			} catch (Exception e) {
				LOG.error(e);
			}
			
		} else {
			
			if(!pProducto.trim().equals("") && pProducto != null ) {	   		// Si el campo de pProducto no es null ni esta vacio, lista los productos que contengan ese parametro dentro de la categoria
				
				LOG.trace("Listar todos los productos de la categoria " + pCategoria + " y que contengan '" + pProducto + "'");				
				
				try {
					
					String searchParam = "%" + pProducto + "%";
					
					productos = dao.getAllByCategoriaAndSearchParam(Integer.parseInt(pCategoria), searchParam);
					
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
				
				
			} else {			// Si el campo pProducto es nulo o esta vacio, lista todos los productos de la categoria seleccionada
				
				LOG.trace("Listar todos los productos de la categoria " + pCategoria);
				
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
