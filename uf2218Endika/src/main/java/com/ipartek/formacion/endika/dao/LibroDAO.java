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
