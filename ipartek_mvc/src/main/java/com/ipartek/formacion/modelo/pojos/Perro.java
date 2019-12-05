package com.ipartek.formacion.modelo.pojos;

public class Perro {
	
	private int id;
	private String nombre;
	private String foto;
	
	public Perro(int id, String nombre, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
	}

	public Perro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.foto = "https://www.google.es/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=2ahUKEwiP1_C5gJ7mAhXCE4gKHdoMCxYQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.pipperontour.com%2Fmisviajes&psig=AOvVaw3YMuSE2fOfjpJ3_xJ-1B2o&ust=1575617960875184";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
