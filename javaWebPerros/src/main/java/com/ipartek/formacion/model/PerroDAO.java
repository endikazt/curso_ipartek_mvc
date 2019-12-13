package com.ipartek.formacion.model;

import java.util.ArrayList;

import com.ipartek.formacion.model.pojo.Perro;

public class PerroDAO  implements IDAO<Perro>{
	
	private ArrayList<Perro> registros;
	private static int indice = 1;
	
	private static PerroDAO INSTANCE = null;
	 
	//capar para que no se pueda hacer un new de esta clases
	private PerroDAO() {
		super();
		registros = new ArrayList<Perro>();
	}
	
	public static PerroDAO getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new PerroDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public ArrayList<Perro> getAll() {
		
		return this.registros;
	}

	@Override
	public Perro getById(int id) {
		
		Perro resul = null;
		
		for (Perro perro : registros) 
		{
			
			if(id == perro.getId())
			{
				resul = perro;
				break;
			}
			
		}
		
		return resul;
	}

	@Override
	public Perro delete(int id) throws Exception {
		
		Perro resul = null;
		
		for (Perro perro : registros) 
		{
			
			if(id == perro.getId())
			{
				resul = perro;
				registros.remove(resul);
				break;
			}
			
		}
		
		if (resul == null) {
			throw new Exception("Perro no encontrado por su id");
		}
		
		return resul;
	}

	@Override
	public Perro update(int id, Perro pojo) throws Exception {
		
		Perro resul = null;
		
		for (int i = 0; i < registros.size(); i++)
		{
			if (id == registros.get(i).getId())
			{
				registros.get(i).setNombre(pojo.getNombre());;
				registros.get(i).setFoto(pojo.getFoto());;
				resul = pojo;
			}
		}
		
		return resul;
	}

	@Override
	public Perro create(Perro pojo) throws Exception {
		
		Perro resul = null;

		if(pojo != null)
		{
			pojo.setId(indice++);
			registros.add(pojo);
			resul = pojo;
		
		}
		
		return resul;
	}
	
	

}
