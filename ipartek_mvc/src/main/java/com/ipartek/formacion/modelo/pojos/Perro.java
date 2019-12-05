package com.ipartek.formacion.modelo.pojos;

public class Perro {
	
	private static int numTotalPerros = 1;
	
	private int id;
	private String nombre;
	private String foto;
	
	public Perro(int id, String nombre, String foto) {
		super();
		this.id = numTotalPerros;
		this.nombre = nombre;
		this.foto = foto;
		numTotalPerros++;
	}

	public Perro() {
		super();
		this.id = numTotalPerros;
		this.nombre = "";
		this.foto = "https://criptogaceta.com/wp-content/uploads/2018/02/doge-el-perro-criptomoneda.jpg";
		numTotalPerros++;
	}
	
	public Perro(String nombre) {
		this();
		this.nombre = nombre;		
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
	
	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", foto=" + foto + "]";
	}

}
