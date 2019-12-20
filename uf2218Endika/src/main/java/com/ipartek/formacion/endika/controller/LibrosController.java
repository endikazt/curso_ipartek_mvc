package com.ipartek.formacion.endika.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.endika.dao.LibroDAO;
import com.ipartek.formacion.endika.model.Alerta;
import com.ipartek.formacion.endika.model.Libro;


/**
 * Servlet implementation class LibrosController
 */
@WebServlet("/libros")
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibrosController.class);
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
	
		/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if("formulario".equals(accion)) 
		{
			request.setAttribute("libro", new Libro());
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);			
			
		} else {
		
			request.setAttribute("libros", dao.getAll());
			request.setAttribute("mensajeAlerta", new Alerta("Bienvenido a la aplicacion de gestion de libros.",Alerta.TIPO_PRIMARY));
			request.getRequestDispatcher("/index.jsp").forward(request, response);	
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Libro libro = new Libro();
		
		String pID = request.getParameter("id");		
		String pNombre = request.getParameter("nombre");		
		String pPrecio = request.getParameter("precio");		
		String pDescuento = request.getParameter("descuento");
		
		boolean nombreCheck = comprobarNombre(request, response, pNombre);
		boolean precioCheck = comprobarPrecio(request, response, pPrecio);
		boolean descuentoCheck = comprobarDescuento(request, response, pDescuento);				
		
		// Se comprueba que los 3 boolean que certifican que los campos son correctos son true
		
		if(nombreCheck == true && precioCheck == true && descuentoCheck == true)
		{
			
			try {
				
				Float precioFloat = Float.parseFloat(pPrecio);
		
				DecimalFormatSymbols symbols = new DecimalFormatSymbols();
				symbols.setDecimalSeparator('.');
				DecimalFormat df = new DecimalFormat("0.#");
				df.setDecimalFormatSymbols(symbols);
				
				String precioFormateado = df.format(precioFloat);	
				
				libro.setNombre(pNombre);
				libro.setDescuento(Integer.parseInt(pDescuento));
				libro.setPrecio(Float.parseFloat(precioFormateado));
				
				dao.create(libro);
				
				request.setAttribute("libros", dao.getAll());
				request.setAttribute("mensajeAlerta", new Alerta("El libro se ha agregado con exito.",Alerta.TIPO_SUCCESS));
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
				
			} catch (Exception e) {
				
				request.setAttribute("libros", dao.getAll());
				request.setAttribute("mensajeAlerta", new Alerta("Ha ocurrido un erro a la hora de añadir el libro. Error: e.printStackTrace();",Alerta.TIPO_DANGER));
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			
			}
			
		}
		
	}
	
	// Comprueba si el valor de nombre es valido o no
	
	public boolean comprobarNombre(HttpServletRequest request, HttpServletResponse response, String pNombre) throws ServletException, IOException {
		
		boolean resul = false;
		
		if(!"".equals(pNombre) && pNombre != null) 
		{
			
			if(pNombre.length() < 2 || pNombre.length() > 150)
			{
				request.setAttribute("mensajeAlerta", new Alerta("El valor de campo de nombre no puede tener menos de 2 letras o mas de 150.",Alerta.TIPO_DANGER));
				request.getRequestDispatcher("/formulario.jsp").forward(request, response);
				
			} else {
				
				resul = true;
				
			}
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de nombre no puede estar vacio.",Alerta.TIPO_DANGER));
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);			
			
		}
		
		return resul;
		
	}
	
	// Comprueba si el valor de precio es valido o no
	
	public boolean comprobarPrecio(HttpServletRequest request, HttpServletResponse response,String pPrecio) throws ServletException, IOException {
		
		boolean resul = false;
		
		if(!"".equals(pPrecio) && pPrecio != null) 
		{
			
			float precioFloat = 0;
			try {
				precioFloat = Float.parseFloat(pPrecio);
			} catch (NumberFormatException e) {
				
				request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de precio tiene que ser numerico.",Alerta.TIPO_DANGER));
				request.getRequestDispatcher("/formulario.jsp").forward(request, response);
			}
			
			if(precioFloat <= 0)
			{
				request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de precio no puede ser 0.",Alerta.TIPO_DANGER));
				request.getRequestDispatcher("/formulario.jsp").forward(request, response);
				
			} else {
			
				resul = true;
				
			}
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de precio no puede estar vacio.",Alerta.TIPO_DANGER));
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);			
			
		}
		
		return resul;
		
	}
	
	// Comprueba si el valor de descuento es valido o no
	
	public boolean comprobarDescuento(HttpServletRequest request, HttpServletResponse response, String pDescuento) throws ServletException, IOException {
		
		boolean resul = false;
		
		if(!"".equals(pDescuento) && pDescuento != null) 
		{	
			int descuentoParse = 0;
			try {
				descuentoParse = Integer.parseInt(pDescuento);
			} catch (NumberFormatException e) {
				
				request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de descuento tiene que ser numerico.",Alerta.TIPO_DANGER));
				request.getRequestDispatcher("/formulario.jsp").forward(request, response);
			}
			
			if(descuentoParse < 0 || descuentoParse > 100)
			{
				request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de descuento tiene que estar entre 0 y 100.",Alerta.TIPO_DANGER));
				request.getRequestDispatcher("/formulario.jsp").forward(request, response);
				
			} else {
				
				resul = true;
				
			}
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de descuento no puede estar vacio.",Alerta.TIPO_DANGER));
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);			
			
		}
		
		return resul;
		
	}

}
