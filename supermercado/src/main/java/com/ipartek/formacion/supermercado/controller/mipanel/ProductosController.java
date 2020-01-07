package com.ipartek.formacion.supermercado.controller.mipanel;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.Alerta;
import com.ipartek.formacion.supermercado.modelo.ProductoException;
import com.ipartek.formacion.supermercado.modelo.dao.CategoriaDAO;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/mipanel/productos")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(ProductosController.class);
	private static final String VIEW_TABLA = "productos/index.jsp";
	private static final String VIEW_FORM = "productos/formulario.jsp";
	private static String vistaSeleccionda = VIEW_TABLA;
	private static ProductoDAO dao;
	private static CategoriaDAO daoCategorias;
	private Usuario uLogeado;

	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	// Acciones

	private static final String ACCION_LISTAR = "listar";
	private static final String ACCION_FORMULARIO = "formulario";
	private static final String ACCION_GUARDAR = "guardar"; // Crear y modificar
	private static final String ACCION_ELIMINAR = "eliminar";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		dao = ProductoDAO.getIntance();
		daoCategorias = CategoriaDAO.getIntance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Override
	public void destroy() {
		super.destroy();

		dao = null;
		factory = null;
		validator = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pAccion = request.getParameter("accion");
		
		uLogeado = (Usuario)request.getSession().getAttribute("usuarioLogeado");

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

		} catch (Exception e) {
			
			LOG.error("Ha ocurrido un error a la hora de proveer los datos necesarios: vistaSelecionada: " + vistaSeleccionda + ". ERROR: " + e);

		} finally {

			request.getRequestDispatcher(vistaSeleccionda).forward(request, response);
		}

	}

	private void formulario(HttpServletRequest request, HttpServletResponse response) {

		Producto producto = new Producto();

		String pId = request.getParameter("id");

		if (!"".equals(pId) && pId != null) { 				// Comprobamos que el valor del id de producto no es vacio ni null

			try {

				producto = dao.getByIdByUser(Integer.parseInt(pId), uLogeado.getId());

			} catch (NumberFormatException e) {

				LOG.error("El ID pasado no es un numero. ERROR: " + e);
				
				request.setAttribute("mensajeAlerta", new Alerta("Ha ocurrido un error a la hora de procesar la solicitud. Contacte con el adminitrador.", Alerta.TIPO_DANGER));
				
			} catch (Exception e) {
				
				LOG.error("Error al convertir el string de pId en integer. ERROR: " + e);
				
				request.setAttribute("mensajeAlerta", new Alerta("Ha ocurrido un error a la hora de procesar la solicitud. Contacte con el adminitrador.", Alerta.TIPO_DANGER));
				
			} catch (ProductoException e) {
				
				request.setAttribute("mensajeAlerta", new Alerta("Hey, no puedes ver la informacion de un producto que no te corresponde >:(", Alerta.TIPO_DANGER));
				
				LOG.error(ProductoException.EXCEPTION_UNAUTORIZED);
				
			}

		}

		request.setAttribute("producto", producto);
		
		request.setAttribute("categorias", daoCategorias.getAll());
		
		vistaSeleccionda = VIEW_FORM;

	}

	private void guardar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("id");
		String pNombre = request.getParameter("nombre");
		String pPrecio = request.getParameter("precio");
		String pDescuento = request.getParameter("descuento");
		String pDescripcion = request.getParameter("descripcion");
		String pImagen = request.getParameter("imagen");
		String pCategoria = request.getParameter("categoriaId");

		Producto p = new Producto();
			
		p = rellenarDatosFormulario(pId, pNombre, pDescripcion, pImagen, pPrecio, pDescuento);

		Set<ConstraintViolation<Producto>> validaciones = validator.validate(p);

		if (validaciones.size() > 0) {

			mensajeValidacion(request, validaciones);

			request.setAttribute("producto", p);

			vistaSeleccionda = VIEW_FORM;

		} else {

			if ("0".equals(pId)) {                                      // Se comprueba que el valor que llega al controlador es igual a 0, en caso afirmativo se crea el producto

				try {
					
					p.setUsuario(uLogeado);
					
					p.setCategoria(daoCategorias.getById(Integer.parseInt(pCategoria)));

					dao.create(p);

				} catch (Exception e) {

					LOG.error("Error al crear un nuevo porducto. Datos del producto: " + p.toString() + "\n ERROR: " + e);
				}

				request.setAttribute("mensajeAlerta", new Alerta("Producto agregado correctamente :)", Alerta.TIPO_SUCCESS));
				
				this.listar(request, response);

			} else {                                                   // Si el valor es mayor que 0 comienza el proceso de modificacion del producto

				try {
					
					p.setId(Integer.parseInt(pId));
					
					p.setCategoria(daoCategorias.getById(Integer.parseInt(pCategoria)));
					
					Producto productoExixte = dao.getByIdByUser(Integer.parseInt(pId), uLogeado.getId());
					
					if(productoExixte != null) {
						
						dao.update(Integer.parseInt(pId), p);
						
						request.setAttribute("mensajeAlerta", new Alerta("Producto modificado correctamente :)", Alerta.TIPO_SUCCESS));
					}
					
				} catch (NumberFormatException e) {
					
					LOG.error("El ID pasado no es un numero. ERROR: " + e);
					
					request.setAttribute("mensajeAlerta", new Alerta("Ha ocurrido un error a la hora de procesar la solicitud. Contacte con el administrador.", Alerta.TIPO_DANGER));
					
				} catch (Exception e) {
					
					LOG.error("Error al actualizar producto. Datos producto: " + p.toString() + "\n ERROR: " + e);
					
					request.setAttribute("mensajeAlerta", new Alerta("Ha ocurrido un error a la hora de procesar la solicitud. Contacte con el adminitrador.", Alerta.TIPO_DANGER));
					
				} catch (ProductoException e) {
					
					request.setAttribute("mensajeAlerta", new Alerta("Hey, no puedes modificar un producto que no te corresponde >:(", Alerta.TIPO_DANGER));
					
					LOG.error(ProductoException.EXCEPTION_UNAUTORIZED);
					
				}
				
				this.listar(request, response);

			}

		}

	}

	private void mensajeValidacion(HttpServletRequest request, Set<ConstraintViolation<Producto>> validaciones) {

		StringBuilder mensaje = new StringBuilder();
		for (ConstraintViolation<Producto> cv : validaciones) {

			mensaje.append("<p>");
			mensaje.append(cv.getPropertyPath().toString().substring(0, 1).toUpperCase()
					+ (cv.getPropertyPath().toString().substring(1))).append(": ");
			mensaje.append(cv.getMessage());
			mensaje.append("</p>");

		}

		request.setAttribute("mensajeAlerta", new Alerta(mensaje.toString(), Alerta.TIPO_DANGER));

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pId = request.getParameter("id");

		Alerta alerta = new Alerta();

		if ((!"".equals(pId) && pId != null)) {					// Se comprueba que el valor que llega al controlador no es ni vacio ni null

			Producto p = null;
			try {	
				
				if(dao.getByIdByUser(Integer.parseInt(pId), uLogeado.getId()) != null) {
					
					p = dao.delete(Integer.parseInt(pId));
					
					alerta.setTexto("El producto " + p.toString() + " ha sido eliminado con exito.");
					alerta.setTipo(Alerta.TIPO_SUCCESS);
					
				}
				
			} catch (Exception e) {
				
				LOG.error("El ID pasado no es un numero. ERROR: " + e);
				
				alerta.setTexto("Ha ocurrido un error a la hora de procesar la solicitud. Contacte con el administrador.");
				alerta.setTipo(Alerta.TIPO_DANGER);
				
				request.setAttribute("mensajeAlerta", alerta);
				
			} catch (ProductoException e) {
				
				LOG.error(ProductoException.EXCEPTION_UNAUTORIZED);
				
				alerta.setTexto("Hey, no puedes eliminar un producto que no te corresponde >:(");
				alerta.setTipo(Alerta.TIPO_DANGER);
				
				request.setAttribute("mensajeAlerta", alerta);
				
			}

		} else {

			alerta.setTexto("Ha ocurrido un error a la hora de eliminar el producto :(");
			alerta.setTipo(Alerta.TIPO_DANGER);

		}
		
		request.setAttribute("mensajeAlerta", alerta);
		
		this.listar(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			request.setAttribute("productos", dao.getAllByUser(uLogeado.getId()));
			
		} catch (Exception e) {			
			
			LOG.error("Ha ocurrido un error a la hora de listar los productos: " + e);
			
		}
		
		vistaSeleccionda = VIEW_TABLA;

	}

	private Producto rellenarDatosFormulario(String pId, String pNombre, String pDescripcion, String pImagen,
			String pPrecio, String pDescuento) {

		Producto resul = new Producto();

		resul.setId(Integer.parseInt(pId));
		resul.setNombre(pNombre);
		resul.setDescripcion(pDescripcion);
		resul.setImagen(pImagen);

		try { 								// Control del precio a la hora de devolver datos al formulario
			
			resul.setPrecio(Float.parseFloat(pPrecio));
			
		} catch (NumberFormatException e) {
			
			LOG.error("El valor de precio no esta en el formato correcto. ERROR: " + e);
			
			resul.setPrecio(0);
			
		}

		try { 							 // Control del descuento a la hora de devolver datos al formulario
			
			resul.setDescuento(Integer.parseInt(pDescuento));
			
		} catch (NumberFormatException e) {
			
			LOG.error("El valor de descuento no esta en el formato correcto. ERROR: " + e);
			
			resul.setDescuento(-1);
			
		}

		return resul;

	}

}
