package com.ipartek.formacion.supermercado.modelo.dao;

import java.util.ArrayList;

import org.omg.CORBA.portable.IndirectionException;

import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public class ProductoDAO implements IDAO<Producto>{
	
	private static ProductoDAO INSTANCE = null;
	private ArrayList<Producto> registros;
	private int indice = 1;
	
	private ProductoDAO() {
		super();
		registros = new ArrayList<Producto>();
		
		// TODO 10 productos mas elaborados
		registros.add(new Producto(1,10,"Turrón duro","https://supermercado.eroski.es/images/17930009.jpg", "Turrón duro, caja 250 g", 20));
		registros.add(new Producto(2,70,"Langostino crudo","https://supermercado.eroski.es/images/16550501.jpg", "Langostino crudo 35/42, caja 700 g", 20));
		registros.add(new Producto(3,70,"Vino Tinto","https://supermercado.eroski.es/images/2026631.jpg", "Vino Tinto Crianza, botella 75 cl\r\n", 20));
		registros.add(new Producto(4,70,"La gula del norte 430 g","https://supermercado.eroski.es/images/19780345.jpg", "Gulas del norte congeladas, bandeja 430 g", 20));
		registros.add(new Producto(5,70,"EL ALMENDRO, 280 g","https://supermercado.eroski.es/images/22615017.jpg", "Turrón crujiente de chocolate negro, tableta 280 g", 20));
		registros.add(new Producto(6,70,"BAQUÉ 2x250g","https://supermercado.eroski.es/images/2679173.jpg", "Café molido natural, pack", 20));
		registros.add(new Producto(7,50,"COOSUR","https://supermercado.eroski.es/images/15923279.jpg", "Aceite oliva virgen extra", 20));
		registros.add(new Producto(8,40,"SAN MIGUEL","https://supermercado.eroski.es/images/16514556.jpg", "Cerveza, pack 24x33 cl", 20));
		registros.add(new Producto(9,70,"ZÜ PREMIUM 2L","https://supermercado.eroski.es/images/13899539.jpg", "Zumo de naranja exprimido sin pulpa", 20));
		registros.add(new Producto(10,50,"CODORNÍU, 75 cl","https://supermercado.eroski.es/images/399691.jpg", "Cava Brut Reserva, botella 75 cl", 20));
		
		indice = 11;
		
	}
	
	public static synchronized ProductoDAO getIntance() {
		
		if(INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
		
	}

	@Override
	public ArrayList<Producto> getAll() {
		
		return registros;
	}

	@Override
	public Producto getById(int id) throws Exception {
		
		Producto resul = null;
		
		for(int i = 0; i < registros.size(); i++) {
			
			if(id == registros.get(i).getId())
			{
				resul = registros.get(i);
			}
			
		}
		
		return resul;
	}

	@Override
	public Producto delete(int id) throws Exception {
		
		Producto resul = null;
		
		for(int i = 0; i < registros.size(); i++) {
			
			if(id == registros.get(i).getId())
			{
				resul = registros.get(i);
				registros.remove(i);
			}
			
		}
		
		return resul;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		
		Producto resul = null;
		
		for(int i = 0; i < registros.size(); i++) {
			
			if(id == registros.get(i).getId())
			{
				registros.get(i).setNombre(pojo.getNombre());
				registros.get(i).setDescripcion(pojo.getDescripcion());
				registros.get(i).setPrecio(pojo.getPrecio());
				registros.get(i).setDescuento(pojo.getDescuento());
				registros.get(i).setImagen(pojo.getImagen());
				resul = registros.get(i);
				break;
			}
			
		}
		
		return resul;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {
		
		Producto resul = null;
		
		pojo.setId(indice);
		indice++;
		
		registros.add(pojo);
		resul = pojo;
		
		return resul;
	}

}
