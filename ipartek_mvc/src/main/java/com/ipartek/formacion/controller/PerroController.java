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
	
    private ArrayList<Perro> perros = new ArrayList<Perro>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Se ejecuta la primera vez qu ese llama a este servelet y nunca mas");
		super.init(config);
		perros.add( new Perro("bubba") );
		perros.add( new Perro("rataplan") );
		perros.add( new Perro("mosca") );
		perros.add( new Perro("txakur") );
		perros.add( new Perro("lagun") );
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
		
		super.service(request, response); LOG.trace("Se ejecuta el doGet y doPost");
		
		LOG.trace("Se ejecuta despues del soGet y del doPost");
		
		LOG.trace("Listar perros");
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("ejercicios/jsp/perros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recibir datos del form
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String eliminar = request.getParameter("eliminar");
		String foto = request.getParameter("foto");
		
		if("true".equals(eliminar)) 
		{
			
			for(int i = 0; i < perros.size(); i++)
			{
				if(Integer.parseInt(id) == (perros.get(i).getId()))
				{
					perros.remove(i);
					
					System.out.println(perros.get(i).getNombre());
				}
			}
			
		} 
		else 
		{
					
			//crear perro
			Perro p = new Perro();
			p.setNombre(nombre);
			p.setFoto(foto);
			
			//guardar en lista
			perros.add(p);
		
		}
	
	}

}