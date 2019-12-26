package com.ipartek.formacion.supermercado.modelo.dao;

import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public interface IUsuarioDAO extends IDAO<Usuario>{
	
	/**
	 * Comprueba si existe el usuario en la base de datos
	 * @param nombre
	 * @param password
	 * @return Usuario con datos si lo encuentra, null en caso contrario
	 */
	
	Usuario exist(String nombre, String password);

}
