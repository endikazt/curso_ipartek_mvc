package com.ipartek.formacion.supermercado.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.supermercado.modelo.ProductoException;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public interface IProductoDAO extends IDAO<Producto>{
	
	/**
	 * 
	 * Lista de productos de un usuario
	 * @param id del usuario
	 * @return ArrayList<Producto> lista inicializada en caso de que no tenga productos
	 * 
	 */

	public ArrayList<Producto> getAllByUser(int id);
	
	/**
	 * 
	 * Lista de productos por un categoria 
	 * @param id del categoria
	 * @return ArrayList<Producto> lista inicializada en caso de que no tenga productos
	 * 
	 */

	public ArrayList<Producto> getAllByCategoria(int id);
	
	/**
	 * 
	 * Lista de productos por un categoria y producto de busqueda
	 * @param id del categoria
	 * @param producto a buscar
	 * @return ArrayList<Producto> lista inicializada en caso de que no tenga productos
	 * 
	 */

	public ArrayList<Producto> getAllByCategoriaAndSearchParam(int id, String searchParam);
	
	/**
	 * 
	 * Recupera un producto de un usuario concreto
	 * @param id del producto
	 * @param id del usuario
	 * @return Producto si lo encuentra, null si no lo encuentra
	 * @throws ProductoException cuando intenta recuperar un producto que no pertenece al usuario
	 * 
	 */
	
	Producto getByIdByUser(int idProducto, int idUsuario) throws ProductoException;
	
	/**
	 * 
	 * Modifica un producto de un usuario concreto
	 * @param id del producto
	 * @param id del usuario
	 * @return El Producto modificado si lo encuentra, null si no lo encuentra
	 * @throws ProductoException cuando intenta recuperar un producto que no pertenece al usuario
	 * 
	 */
	
	Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException;
	
	/**
	 * 
	 * Elimina un producto de un usuario concreto
	 * @param id del producto
	 * @param id del usuario
	 * @param datos del producto a modificar
	 * @return El Producto eliminado si lo encuentra, null si no lo encuentra
	 * @throws ProductoException
	 * 		<ol>
	 * 			<li> Cuando intenta eliminar un producto que no le pertenece al usuario
	 * 			<li> Cuando no encuentra el producto pro su id
	 * 		</ol>
	 */
	
	Producto deleteByUser(int idProducto, int idUsuario) throws ProductoException;
	
	

}
