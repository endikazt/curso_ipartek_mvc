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

public class ProductoDAO implements IDAO<Producto>{
	
	private static ProductoDAO INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(ProductoDAO.class);
	
	private static final String SQL_GET_ALL = "SELECT id, nombre, descripcion, imagen, precio, descuento FROM producto ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, descripcion, imagen, precio, descuento FROM producto WHERE id=?;";
	//private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT nombre FROM producto ORDER BY u.nombre ASC LIMIT 500;";
	private static final String SQL_EXISTE = " SELECT id, nombre, descripcion, imagen, precio, descuento FROM producto WHERE id = ? AND nombre = ?;";
	private static final String SQL_EXISTE_NOMBRE = " SELECT nombre FROM producto WHERE nombre = ?;";
	private static final String SQL_INSERT = "INSERT INTO producto (nombre, descripcion, imagen, precio, descuento) VALUES ( ? , ?, ?, ?, ?);";
	private static final String SQL_UPDATE = "UPDATE producto SET nombre= ?, descripcion= ?, imagen= ?, precio= ?, descuento= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ?;";
	//private static final String SQL_DELETE_LOGICO = "UPDATE producto SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE id = ?;";
	
	private ProductoDAO() {
		super();		
	}
	
	public static synchronized ProductoDAO getIntance() {
		
		if(INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
		
	}

	@Override
	public ArrayList<Producto> getAll() throws Exception {
		
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				
				Producto p = new Producto();
				p.setId( rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setImagen(rs.getString("imagen"));
				p.setPrecio(rs.getFloat("precio"));
				p.setDescuento(rs.getInt("descuento"));
				lista.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Producto getById(int id) throws Exception {
		
		Producto resul = new Producto();
		
		try (			
				Connection con = ConnectionManager.getConnection();				
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
						
			) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					resul.setId( rs.getInt("id"));
					resul.setNombre(rs.getString("nombre"));
					resul.setDescripcion(rs.getString("descripcion"));
					resul.setImagen(rs.getString("imagen"));
					resul.setPrecio(rs.getFloat("precio"));
					resul.setDescuento(rs.getInt("descuento"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}

	@Override
	public Producto delete(int id) throws Exception {
		
		Producto resul = this.getById(id);
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				
		) {

			pst.setInt(1, id);
			
			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				
				LOG.info("Eliminacion completada. Prodcuto = " + resul.toString());
				
			} else {
				
				throw new Exception("No se ha podido eliminar el registro.");
				
			}

		}
		
		return resul;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		
		Producto resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);		
				
		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getDescripcion());
			pst.setString(3, pojo.getImagen());
			pst.setFloat(4, pojo.getPrecio());
			pst.setInt(5, pojo.getDescuento());
			pst.setInt(6, id);

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
	public Producto create(Producto pojo) throws Exception {
		
		Producto resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					
		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getDescripcion());
			pst.setString(3, pojo.getImagen());
			pst.setFloat(4, pojo.getPrecio());
			pst.setInt(5, pojo.getDescuento());

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

}
