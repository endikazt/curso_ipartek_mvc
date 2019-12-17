package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelo.Alerta;
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
		
		Producto producto = null;
		
		String pId = request.getParameter("id");
		
		if(!"".equals(pId) && pId != null)
		{			
			
			try {
				producto = dao.getById(Integer.parseInt(pId));
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		} else {

			producto = new Producto();
			
		}
		
		request.setAttribute("producto", producto);
		vistaSeleccionda = VIEW_FORM;
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		String pNombre = request.getParameter("nombre");
		String pPrecio = request.getParameter("precio");
		String pDescuento = request.getParameter("descuento");
		String pDescripcion = request.getParameter("descripcion");
		String pImagen = request.getParameter("imagen");
		
		Producto p = new Producto();
		p.setNombre(pNombre);
		p.setDescripcion(pDescripcion);
		p.setPrecio(Float.parseFloat(pPrecio));
		p.setDescuento(Integer.parseInt(pDescuento));
		p.setImagen(pImagen);
		
		if((!"".equals(pId) && pId !=null) || (!"".equals(pNombre) && pNombre !=null) || (!"".equals(pPrecio) && pPrecio !=null) 
				|| (!"".equals(pDescuento) && pDescuento !=null) || (!"".equals(pDescripcion) && pDescripcion !=null) 
				|| (!"".equals(pImagen) && pImagen !=null)) 
		{	
		
			if("0".equals(pId))
			{
				
				try {
					dao.create(p);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("mensajeAlerta", new Alerta("Producto agregado correctamente :)", Alerta.TIPO_SUCCESS));
				this.listar(request, response);
				
			} else {
				
				p.setId(Integer.parseInt(pId));
				
				try {
					dao.update(Integer.parseInt(pId), p);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("mensajeAlerta", new Alerta("Producto modificado correctamente :)", Alerta.TIPO_SUCCESS));
				
				this.listar(request, response);
				
			}
		} else {
			
			vistaSeleccionda = VIEW_FORM;
			
			request.setAttribute("mensajeAlerta", new Alerta("Ha ocurrido un error a la hora de agregar el producto :(. Compruebe que todo esta bien.", Alerta.TIPO_SUCCESS));
			
		}
		
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		
		Alerta alerta = new Alerta();
		
		if((!"".equals(pId) && pId !=null))
		{
			
			Producto p = null;			
			try {
				p = dao.delete(Integer.parseInt(pId));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			alerta.setTexto("El producto " + p.toString() + " ha sido eliminado con exito.");
			alerta.setTipo(Alerta.TIPO_SUCCESS);
			
		}  else {
			
			alerta.setTexto("Ha ocurrido un error a la hora de eliminar el producto :(");
			alerta.setTipo(Alerta.TIPO_DANGER);
			
		}
		
		request.setAttribute("mensajeAlerta", alerta);

		this.listar(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("productos", dao.getAll() );
		vistaSeleccionda = VIEW_TABLA;
		
	}
	
}
