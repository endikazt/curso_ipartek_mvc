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
@WebServlet("/privado/libros")
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibrosController.class);
	private static final String VIEW_TABLA = "libros/index.jsp";
	private static final String VIEW_FORM = "libros/formulario.jsp";
	private static String vistaSeleccionda = VIEW_TABLA;
	private static LibroDAO dao;
	
	//Acciones
	
	private static final String ACCION_LISTAR = "listar";
	private static final String ACCION_FORMULARIO = "formulario";
	private static final String ACCION_GUARDAR = "guardar"; // Crear y modificar
	private static final String ACCION_ELIMINAR = "eliminar";
	
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
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doAction(request, response);	
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recoger parametros
		
		String pAccion = request.getParameter("accion");	
		
		LOG.debug("Accion a realizar -> " + pAccion);
		
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
			
			LOG.info("Enviando a la vista -> " + vistaSeleccionda);
			
			request.getRequestDispatcher(vistaSeleccionda).forward(request, response);
		}
		
	}

	
	
	private void formulario(HttpServletRequest request, HttpServletResponse response) {
		
		Libro libro = null;
		
		String pId = request.getParameter("id");
		
		if(!"".equals(pId) && pId != null)
		{			
			
			try {
				libro = dao.getById(Integer.parseInt(pId));
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		} else {

			libro = new Libro();
			
		}
		
		request.setAttribute("libro", libro);
		vistaSeleccionda = VIEW_FORM;
		
	}
	
	private void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Libro libro = new Libro();
		
		String pID = request.getParameter("id");		
		String pNombre = request.getParameter("nombre");		
		String pPrecio = request.getParameter("precio");		
		String pDescuento = request.getParameter("descuento");
		String pImagen = request.getParameter("imagen");
		String pAutor = request.getParameter("autor");
		
		boolean nombreCheck = comprobarNombre(request, response, pNombre);
		boolean precioCheck = comprobarPrecio(request, response, pPrecio);
		boolean descuentoCheck = comprobarDescuento(request, response, pDescuento);			
		boolean autorCheck = comprobarAutor(request, response, pAutor);			
		boolean imagenCheck = comprobarImagen(request, response, pImagen);			
		
		// Se comprueba que los 3 boolean que certifican que los campos son correctos son true
		
		if(nombreCheck == true && precioCheck == true && descuentoCheck == true && autorCheck && imagenCheck)
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
				libro.setImagen(pImagen);
				libro.setAutor(pAutor);
				
				if("0".equals(pID))
				{
					
					try {
						
						dao.create(libro);
						
					} catch (Exception e) {
						
						LOG.error(e);
						
					}
					
					LOG.info("Producto nuevo agregado -> " + libro.toString());
					
					request.setAttribute("libros", dao.getAll());
					request.setAttribute("mensajeAlerta", new Alerta("El libro se ha agregado con exito.",Alerta.TIPO_SUCCESS));
					vistaSeleccionda = VIEW_TABLA;
					
				} else {
					
					libro.setId(Integer.parseInt(pID));
					
					try {
						
						dao.update(Integer.parseInt(pID), libro);
						
					} catch (NumberFormatException e) {
						
						LOG.error(e);	
						
					} catch (Exception e) {
						
						LOG.error(e);
					}
					
					LOG.info("Producto modificado -> Anterior: " + dao.getById(libro.getId())+ ", Actual: " + libro.toString());
					
					request.setAttribute("mensajeAlerta", new Alerta("Producto modificado correctamente :)", Alerta.TIPO_SUCCESS));
					request.setAttribute("libros", dao.getAll());
					vistaSeleccionda = VIEW_TABLA;
					
				}
				
			} catch (Exception e) {
				
				request.setAttribute("libros", dao.getAll());
				request.setAttribute("mensajeAlerta", new Alerta(("Ha ocurrido un erro a la hora de añadir el libro. Error: " + e),Alerta.TIPO_DANGER));
				vistaSeleccionda = VIEW_TABLA;
			
			}
			
		}				
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		
		Alerta alerta = new Alerta();
		
		if((!"".equals(pId) && pId !=null))
		{
			
			Libro l = null;			
			try {
				l = dao.delete(Integer.parseInt(pId));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			LOG.info("Producto eliminado -> " + l.toString());
			
			alerta.setTexto("El producto " + l.toString() + " ha sido eliminado con exito.");
			alerta.setTipo(Alerta.TIPO_SUCCESS);
			
		}  else {
			
			alerta.setTexto("Ha ocurrido un error a la hora de eliminar el producto :(");
			alerta.setTipo(Alerta.TIPO_DANGER);
			
		}
		
		request.setAttribute("mensajeAlerta", alerta);

		this.listar(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("libros", dao.getAll() );
		vistaSeleccionda = VIEW_TABLA;
		
	}
	
	// Comprueba si el valor de nombre es valido o no
	
	public boolean comprobarNombre(HttpServletRequest request, HttpServletResponse response, String pNombre) throws ServletException, IOException {
		
		boolean resul = false;
		
		if(!"".equals(pNombre) && pNombre != null) 
		{
			
			if(pNombre.length() < 2 || pNombre.length() > 150)
			{
				request.setAttribute("mensajeAlerta", new Alerta("El valor de campo de nombre no puede tener menos de 2 letras o mas de 150.",Alerta.TIPO_DANGER));
				vistaSeleccionda = VIEW_FORM;
				
			} else {
				
				resul = true;
				
			}
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de nombre no puede estar vacio.",Alerta.TIPO_DANGER));
			vistaSeleccionda = VIEW_FORM;		
			
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
				vistaSeleccionda = VIEW_FORM;
			}
			
			if(precioFloat <= 0)
			{
				request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de precio no puede ser 0.",Alerta.TIPO_DANGER));
				vistaSeleccionda = VIEW_FORM;
				
			} else {
			
				resul = true;
				
			}
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de precio no puede estar vacio.",Alerta.TIPO_DANGER));
			vistaSeleccionda = VIEW_FORM;	
			
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
				vistaSeleccionda = VIEW_FORM;
			}
			
			if(descuentoParse < 0 || descuentoParse > 100)
			{
				request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de descuento tiene que estar entre 0 y 100.",Alerta.TIPO_DANGER));
				vistaSeleccionda = VIEW_FORM;
				
			} else {
				
				resul = true;
				
			}
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de descuento no puede estar vacio.",Alerta.TIPO_DANGER));		
			vistaSeleccionda = VIEW_FORM;
		}
		
		return resul;
		
	}
	
	private boolean comprobarImagen(HttpServletRequest request, HttpServletResponse response, String pImagen) {
		
		boolean resul = false;
		
		if(!"".equals(pImagen) && pImagen != null) 
		{
				
				resul = true;
				
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de imagen no puede estar vacio.",Alerta.TIPO_DANGER));
			vistaSeleccionda = VIEW_FORM;		
			
		}
		
		return resul;	
		
	}

	private boolean comprobarAutor(HttpServletRequest request, HttpServletResponse response, String pAutor) {
		boolean resul = false;
		
		if(!"".equals(pAutor) && pAutor != null) 
		{
				
			resul = true;
			
		} else {
			
			request.setAttribute("mensajeAlerta", new Alerta("El valor del campo de autor no puede estar vacio.",Alerta.TIPO_DANGER));
			vistaSeleccionda = VIEW_FORM;		
			
		}
		
		return resul;
	}

}
