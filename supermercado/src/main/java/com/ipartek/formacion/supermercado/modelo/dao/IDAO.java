package com.ipartek.formacion.supermercado.modelo.dao;

import java.util.ArrayList;

public interface IDAO<P> {
	
	/**
	 * 
	 * Recupera todos los pojos de una base de datos
	 * @param ArrayList<P>
	 * @throws Exception 
	 * 
	 */
	
	ArrayList<P> getAll() throws Exception;
	
	/**
	 * 
	 * Recupera un pojo por id
	 * @param id identificador
	 * @return pojo pedido
	 * @throws exception si no se encuentra el pojo
	 * 
	 */
	
	P getById(int id) throws Exception;
	
	/**
	 * 
	 * Elimina un pojo por id
	 * @param id idetificador
	 * @return pojo eliminado
	 * @throws exception si no se puede eliminar o no lo encunetra
	 * 
	 */
	
	P delete(int id) throws Exception;
	
	/**
	 * 
	 * Actualiza un pojo por id
	 * @param id identificador
	 * @return pojo actualizado
	 * @throws Exception si no se puede eliminar o no se encuentra
	 * 
	 */
	
	P update (int id, P pojo) throws Exception;
	
	/**
	 * 
	 * Crea un pojo mediante otro pojo
	 * @param pojo
	 * @return pojo
	 * @throws Exception si no se puede actualizar o no lo encuentra
	 * 
	 */
	
	P create(P pojo) throws Exception;

}
