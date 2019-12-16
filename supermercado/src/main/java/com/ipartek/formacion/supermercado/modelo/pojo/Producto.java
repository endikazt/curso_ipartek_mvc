package com.ipartek.formacion.supermercado.modelo.pojo;

public class Producto {
	
	public static final int DESCUENTO_MIN = 0;
	public static final int DESCUENTO_MAX = 100;

	private int id, descuento;
	private String nombre, imagen, descripcion;
	private float precio;
	
	public Producto() {
		super();
		this.id = 0;
		this.descuento = 0;
		this.nombre = "";
		this.imagen = "https://image.flaticon.com/icons/png/512/372/372627.png";
		this.descripcion = "";
		this.precio = 0;
	}


	public Producto(int id, int descuento, String nombre, String imagen, String descripcion, float precio) {
		super();
		this.id = id;
		this.descuento = descuento;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precio = precio;
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
