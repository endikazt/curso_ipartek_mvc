package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public class CategoriaDAO implements IDAO<Categoria>{
	
	private static CategoriaDAO INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(CategoriaDAO.class);
	
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM categoria ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM categoria WHERE id=?;";
	private static final String SQL_INSERT = "INSERT INTO categoria (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE categoria SET nombre= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM categoria WHERE id = ?;";
	
	private CategoriaDAO() {
		super();		
	}
	
	public static synchronized CategoriaDAO getIntance() {
		
		if(INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		
		return INSTANCE;
		
	}

	@Override
	public ArrayList<Categoria> getAll() {
		
		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				
				Categoria c = mapper(rs);
				lista.add(c);

			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return lista;
	}

	@Override
	public Categoria getById(int id) throws Exception {
		
		Categoria resul = null;
		
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
			LOG.error(e);
		}
		
		return resul;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		
		Categoria resul = this.getById(id);
		
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
	public Categoria update(int id, Categoria pojo) throws Exception {
		
		Categoria resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);		
				
		) {
			
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, id);

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
	public Categoria create(Categoria pojo) throws Exception {
		
		Categoria resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					
		) {

			pst.setString(1, pojo.getNombre());

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
	
	private Categoria mapper(ResultSet rs) throws SQLException {
		
		Categoria u = new Categoria();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		
		return u;
	}

	@Override
	public ArrayList<Producto> getAllByUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
