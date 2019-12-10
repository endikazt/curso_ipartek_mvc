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

import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class PerroController
 */
@WebServlet("/perros")
public class PerroController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(PerroController.class);
	private String mensaje;
	private int indice = 0;
	
    private ArrayList<Perro> perros = new ArrayList<Perro>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Se ejecuta la primera vez qu ese llama a este servlet y nunca mas");
		super.init(config);
		perros.add( new Perro(1,"bubba") );
		perros.add( new Perro(2, "rataplan") );
		perros.add( new Perro(3, "mosca") );
		perros.add( new Perro(4, "txakur") );
		perros.add( new Perro(5, "lagun") );
		indice = 6;
	}
	
	@Override
	public void destroy() {
		LOG.trace("Se ejecuta solo una vez cuando se detiene el servidor");
		super.destroy();
		perros = null;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Se ejecuta antes del doGet y del doPost");
		
		mensaje = "";
		
		super.service(request, response); LOG.trace("Se ejecuta el doGet y doPost");
		
		LOG.trace("Se ejecuta despues del soGet y del doPost");
		
		LOG.trace("Listar perros");
		request.setAttribute("perros", perros);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("ejercicios/jsp/perros.jsp").forward(request, response);
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
			Perro perro = null;
			for(int i = 0; i < perros.size(); i++)
			{
				if(id == (perros.get(i).getId()))
				{
					perro = perros.get(i);
				}
			}
			
			if(adoptar == true ) {
			
				perros.remove(perro);
				LOG.info("El perro " + perro.toString() + " se ha adoptado");
				mensaje = "Perro adoptado";
				
			}
			
			if(editar == true ) {
				
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
			Perro perro = null;
			for(int i = 0; i < perros.size(); i++)
			{
				if(id == (perros.get(i).getId()))
				{
					perro = perros.get(i);
					perros.get(i).setNombre(nombre);
					perros.get(i).setFoto(foto);
				}
			}
			
			LOG.info("El perro " + perro.toString() + " se ha adoptado");			
			mensaje = "Perro modificado correctamente";
			
			
		} 
		else 
		{
					
			LOG.trace("Crear perro");
			
			Perro p = new Perro();
			p.setId(indice);
			p.setNombre(nombre);
			p.setFoto(foto);
			indice++;
			
			mensaje = "Gracias por dar de alta un nuevo perro";
			
			//guardar en lista
			perros.add(p);
		
		}
	
	}

}