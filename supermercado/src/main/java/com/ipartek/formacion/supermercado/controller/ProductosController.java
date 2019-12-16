package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/seguridad/productos")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_TABLA = "productos/index.jsp";
	private static final String VIEW_FORM = "productos/formulario.jsp";
	private static String vistaSeleccionda = VIEW_TABLA;
	private static ProductoDAO dao;
	
	//Acciones
	
	private static final String ACCION_LISTAR = "listar";
	private static final String ACCION_FORMULARIO = "formulario";
	private static final String ACCION_GUARDAR = "guardar"; // Crear y modificar
	private static final String ACCION_ELIMINAR = "eliminar";
	
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
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recoger parametros
		
		String pAccion = request.getParameter("accion");
		
		String pId = request.getParameter("id");
		String pNombre = request.getParameter("nombre");
		String pPrecio = request.getParameter("precio");
		String pDescuento = request.getParameter("descuento");
		String pDescripcion = request.getParameter("descripcion");
		String pImagen = request.getParameter("imagen");
		
		
		try {
			
			switch (pAccion) {
			case ACCION_LISTAR:
				listar(request, response);
				break;
			case ACCION_ELIMINAR:	
				eliminar(request, response);
				break;
			case ACCION_GUARDAR:	
				guardar(request, response);
				break;
			case ACCION_FORMULARIO:	
				formulario(request, response);
				break;
			default:
				listar(request, response);
				break;
			}
			
		}catch (Exception e) {
			// TODO log
			e.printStackTrace();
			
		}finally {
			
			request.getRequestDispatcher(vistaSeleccionda).forward(request, response);
		}
		
	}

	
	
	private void formulario(HttpServletRequest request, HttpServletResponse response) {
		
		//TODO pregutar por pID > 0 recuperar del DAO
		// si no New Producto()
		
		//  	dao.getById(id) => implementar
		
		request.setAttribute("producto", new Producto() );
		vistaSeleccionda = VIEW_FORM;
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("productos", dao.getAll() );
		vistaSeleccionda = VIEW_TABLA;
		
	}
	
}
