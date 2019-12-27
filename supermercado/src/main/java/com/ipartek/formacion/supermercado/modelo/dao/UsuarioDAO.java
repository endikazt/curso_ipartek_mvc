package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
	
	private static UsuarioDAO INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(UsuarioDAO.class);
	
	private static final String SQL_GET_ALL = "SELECT id, nombre, password FROM usuario ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, password FROM usuario WHERE id=?;";
	//private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT nombre FROM producto ORDER BY u.nombre ASC LIMIT 500;";
	private static final String SQL_EXISTE = " SELECT id, nombre, password FROM usuario WHERE nombre = ? AND password = ?;";
	private static final String SQL_EXISTE_NOMBRE = " SELECT nombre FROM producto WHERE nombre = ?;";
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, password = ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	//private static final String SQL_DELETE_LOGICO = "UPDATE producto SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE id = ?;";
	
	private UsuarioDAO() {
		super();		
	}
	
	public static synchronized UsuarioDAO getIntance() {
		
		if(INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		
		return INSTANCE;
		
	}

	@Override
	public ArrayList<Usuario> getAll() {
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				
				Usuario p = mapper(rs);
				lista.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Usuario getById(int id) throws Exception {
		
		Usuario resul = null;
		
		try (			
				Connection con = ConnectionManager.getConnection();				
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
						
			) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					
					resul = mapper(rs);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		
		Usuario resul = this.getById(id);
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				
		) {

			pst.setInt(1, id);
			
			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				
				LOG.info("Eliminacion completada. Producto = " + resul.toString());
				
			} else {
				
				throw new Exception("No se ha podido eliminar el registro. El usuario ni existe o tiene productos asociados.");
				
			}

		}
		
		return resul;
	}

	@Override
	public Usuario update(int id, Usuario pojo) throws Exception {
		
		Usuario resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);		
				
		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setInt(3, id);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				
				resul = this.getById(id);
				
			} else {
				
				throw new Exception("No se encontro registro para id=" + id);
				
			}
		}
		
		return resul;
	}

	@Override
	public Usuario create(Usuario pojo) throws Exception {
		
		Usuario resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					
		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}

			}

		}

		return resul;
	}

	@Override
	public Usuario exist(String nombre, String password) {
		
		Usuario resul = null;
		
		try (			
				Connection con = ConnectionManager.getConnection();				
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);
						
			) {

			pst.setString(1, nombre);
			pst.setString(2, password);
			LOG.debug(pst);

			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					resul = mapper(rs);
				}
				
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}
	
	private Usuario mapper(ResultSet rs) throws SQLException {
		
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setPassword(rs.getString("password"));
		
		return u;
	}
	
}
