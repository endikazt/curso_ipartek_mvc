package com.ipartek.formacion.supermercado.modelo.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Producto {
	
	public static final int DESCUENTO_MIN = 0;
	public static final int DESCUENTO_MAX = 100;

	private int id;
	
	@NotNull(message="Este campo no puede estar vacio.")
	@NotBlank(message="Este campo no puede estar vacio.")
	@Size(min = 2, max = 150, message="El valor de este campo tiene que estar entre 2 y 150 caracteres.")
	private String nombre; 
	
	@NotNull(message="Este campo no puede estar vacio.")
	@NotBlank(message="Este campo no puede estar vacio.")
	@Size(min = 2, max = 150, message="El valor de este campo tiene que estar entre 2 y 150 caracteres.")
	private String descripcion;
	
	@NotNull(message="Este campo no puede estar vacio.")
	@NotBlank(message="Este campo no puede estar vacio.")
	private String imagen;
	
	@NotNull(message= "Este campo no puede estar vacio.")
	@Range(min = 1, message="El valor de este campo no puede ser menor que 1.")
	private float precio;
	
	@NotNull(message= "Este campo no puede estar vacio.")
	@Range(min = 0, max = 100, message="El valor de este campo tiene que estar entre 0 y 100.")
	private int descuento;
	
	private Usuario usuario;
	
	public Producto() {
		super();
		this.id = 0;
		this.descuento = 0;
		this.nombre = "";
		this.imagen = "https://image.flaticon.com/icons/png/512/372/372627.png";
		this.descripcion = "";
		this.precio = 0;
		this.usuario = new Usuario();
	}


	public Producto(int id, int descuento, String nombre, String imagen, String descripcion, float precio, Usuario usuario) {
		super();
		this.id = id;
		this.descuento = descuento;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precio = precio;
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public float calcularPrecioDescuento() {
		
		float precioDescuento = 0;
		
		precioDescuento = (precio - ((precio*descuento)/100));
		
		return precioDescuento;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", descuento=" + descuento + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
}
