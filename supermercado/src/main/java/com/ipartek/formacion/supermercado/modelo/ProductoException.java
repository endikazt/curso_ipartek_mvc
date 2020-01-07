package com.ipartek.formacion.supermercado.modelo;

public class ProductoException extends Throwable{

	private static final long serialVersionUID = 1L;
	
	public static final String EXCEPTION_UNAUTORIZED = "El producto no pertenece al usuario.";
	
	public static final String EXCEPTION_NOT_FOUND = "Producto no encontrado para el usuario.";	
	
	public ProductoException(String mensaje) {
		super(mensaje);
	}
	
}
