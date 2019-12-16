package com.ipartek.formacion.supermercado.modelo;

public class Alerta {
	
	public static final String TIPO_PRIMARY = "primary";
	public static final String TIPO_DANGER = "danger";
	public static final String TIPO_SUCCESS = "success";
	
	private String texto;
	private String tipo;
		
	
	public Alerta() {
		super();
		this.texto = "ERROR inexperado de la aplicacion";
		this.tipo = TIPO_DANGER;
	}

	public Alerta(String texto, String tipo) {
		super();
		this.texto = texto;
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
