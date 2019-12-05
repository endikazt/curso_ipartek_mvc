package com.ipartek.formacion.modelo.pojos;

public class Usuario {
	
	private static int numTotalUsuarios = 1;
	
	private int id;
	private String nombre, password, github, imagen;
	
	public Usuario(int id, String nombre, String password, String github, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.github = github;
		this.imagen = imagen;
	}

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
		this.github = "";
		this.imagen = "https://img.icons8.com/officel/2x/user.png";
	}

	public Usuario(String nombre) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
