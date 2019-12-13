package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.PerroDAO;
import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerroController
 */
@WebServlet({"/private/perros2","/private/perros2/"})
public class PerroController2 extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(PerroController2.class);
	private static PerroDAO dao = PerroDAO.getInstance();
	private String mensaje;
	private int indice = 0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Se ejecuta la primera vez qu ese llama a este servlet y nunca mas");
		super.init(config);
		try {
			dao.create( new Perro(1,"bubba") );
			dao.create( new Perro(2, "rataplan") );
			dao.create( new Perro(3, "mosca") );
			dao.create( new Perro(4, "txakur") );
			dao.create( new Perro(5, "lagun") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		indice = 6;
	}
	
	@Override
	public void destroy() {
		LOG.trace("Se ejecuta solo una vez cuando se detiene el servidor");
		super.destroy();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Se ejecuta antes del doGet y del doPost");
		
		mensaje = "";
		
		super.service(request, response); LOG.trace("Se ejecuta el doGet y doPost");
		
		LOG.trace("Se ejecuta despues del soGet y del doPost");
		
		LOG.trace("Listar perros");
		request.setAttribute("perros", dao.getAll());
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/private/perros-jstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = (request.getParameter("id") == null)? 0 : Integer.parseInt(request.getParameter("id"));
		boolean adoptar = (request.getParameter("adoptar") == null)? false : true;
		boolean editar = (request.getParameter("editar") == null)? false : true;
		
		LOG.trace("id: " + id + ", adoptar: " + adoptar + ", editar: " + editar);
		
		if(id > 0) 
		{
			Perro perro = dao.getById(id);
			
			if(adoptar == true ) {
			
				try {
					dao.delete(perro.getId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LOG.info("El perro " + perro.toString() + " se ha adoptado");
				mensaje = "Perro adoptado";
				
			}
			
			if(editar == true ) {
				
				try {
					dao.update(id, perro);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("perroEditar", perro);
				
			}		
			
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recibir datos del form
		
		LOG.trace("doGET");
		
		int id = (request.getParameter("id") == null)? 0 : Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String foto = request.getParameter("foto");
		
		//TODO validar datos
		
		if(id > 0) 
		{
			Perro perro;
			try {
				perro = dao.delete(id);
				LOG.info("El perro " + perro.toString() + " se ha adoptado");			
				mensaje = "Perro modificado correctamente";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		else 
		{
					
			LOG.trace("Crear perro");
			
			Perro p = new Perro();
			p.setId(indice);
			p.setNombre(nombre);
			p.setFoto(foto);
			indice++;
			
			try {
				dao.create(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mensaje = "Gracias por dar de alta un nuevo perro";
		}
	
	}

}