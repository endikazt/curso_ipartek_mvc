package com.ipartek.formacion.endika.dao;

import java.util.ArrayList;

import com.ipartek.formacion.endika.model.Libro;

public class LibroDAO implements IDAO<Libro>{
	
	private ArrayList<Libro> registros;
	private static int indice = 1;
	
	private static LibroDAO INSTANCE = null;
	 
	private LibroDAO() {
		super();
		registros = new ArrayList<Libro>();
		registros.add(new Libro(1, "El despertar del Leviatán (The Expanse 1)", "James S.A. Corey", "https://images-eu.ssl-images-amazon.com/images/I/51K3p2lbJeL.jpg", (float) 21.50 , 5));
		registros.add(new Libro(2, "La guerra de Calibán (The Expanse 2)", "James S.A. Corey", "https://images-na.ssl-images-amazon.com/images/I/915mh7F7qKL.jpg", (float) 21.50 , 5));
		registros.add(new Libro(3, "La puerta de Abadón (The Expanse 3)", "James S.A. Corey", "https://images-na.ssl-images-amazon.com/images/I/91U5TumNq%2BL.jpg", (float) 21.50 , 5));
		registros.add(new Libro(4, "La quema de Cíbola (The Expanse 4)", "James S.A. Corey", "https://images-na.ssl-images-amazon.com/images/I/91F1rGrLM3L.jpg", (float) 21.50 , 5));
		registros.add(new Libro(5, "Los juegos de Nemesis (The Expanse 5)", "James S.A. Corey", "https://images-na.ssl-images-amazon.com/images/I/91aXEJsLS5L.jpg", (float) 21.50 , 5));
		registros.add(new Libro(6, "El problema de los tres cuerpos (Trilogía de los Tres Cuerpos 1))", "Cixin Liu", "https://images-na.ssl-images-amazon.com/images/I/91v3u%2BL0RuL.jpg", (float) 21.50 , 5));
		registros.add(new Libro(7, "El bosque oscuro (Trilogía de los Tres Cuerpos 2)", "Cixin Liu", "https://images-na.ssl-images-amazon.com/images/I/91pDjnI0D4L.jpg", (float) 21.50 , 5));
		registros.add(new Libro(8, "El fin de la muerte (Trilogía de los Tres Cuerpos 3)", "Cixin Liu", "https://images-na.ssl-images-amazon.com/images/I/91dKdSfH%2B8L.jpg", (float) 21.50 , 5));
		registros.add(new Libro(9, "La tierra errante", "Cixin Liu", "https://images-na.ssl-images-amazon.com/images/I/817nb5UPGmL.jpg", (float) 20 , 5));
		registros.add(new Libro(10, "La esfera luminosa", "Cixin Liu", "https://images-na.ssl-images-amazon.com/images/I/91DsvQTrhyL.jpg", (float) 20 , 5));
		registros.add(new Libro(11, "Metro 2033", "Dmitry Glukhovsky", "https://images-na.ssl-images-amazon.com/images/I/71huuEFXaLL.jpg", (float) 20 , 5));
		registros.add(new Libro(12, "Metro 2034", "Dmitry Glukhovsky", "https://images-na.ssl-images-amazon.com/images/I/71xZwdStNaL.jpg", (float) 20 , 5));
		registros.add(new Libro(13, "Metro 2035", "Dmitry Glukhovsky", "https://images-na.ssl-images-amazon.com/images/I/81Pbvt0bJxL.jpg", (float) 20 , 5));
		registros.add(new Libro(14, "Las estrellas son legion", "Kameron Hurley", "https://images-na.ssl-images-amazon.com/images/I/71Iay9UNLGL.jpg", (float) 19 , 5));
		
		indice = 15;
	}
	
	public static LibroDAO getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public ArrayList<Libro> getAll() {
		
		return this.registros;
	}

	@Override
	public Libro getById(int id) throws Exception {
		Libro resul = null;
		
		for (Libro libro : registros) 
		{
			
			if(id == libro.getId())
			{
				resul = libro;
				break;
			}
			
		}
		
		return resul;
	}

	@Override
	public Libro delete(int id) throws Exception {
		Libro resul = null;
		
		for (Libro libro : registros) 
		{
			
			if(id == libro.getId())
			{
				resul = libro;
				registros.remove(resul);
				break;
			}
			
		}
		
		if (resul == null) {
			throw new Exception("Libro no encontrado por su id");
		}
		
		return resul;
	}

	@Override
	public Libro update(int id, Libro pojo) throws Exception {
		Libro resul = null;
		
		for (int i = 0; i < registros.size(); i++)
		{
			if (id == registros.get(i).getId())
			{
				registros.get(i).setNombre(pojo.getNombre());
				registros.get(i).setPrecio(pojo.getPrecio());
				registros.get(i).setDescuento(pojo.getDescuento());
				registros.get(i).setImagen(pojo.getImagen());
				registros.get(i).setAutor(pojo.getAutor());
				resul = pojo;
			}
		}
		
		return resul;
	}

	@Override
	public Libro create(Libro pojo) throws Exception {
		Libro resul = null;

		if(pojo != null)
		{
			pojo.setId(indice++);
			registros.add(pojo);
			resul = pojo;
		
		}
		
		return resul;
	}

}
