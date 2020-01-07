package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.ProductoException;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public class ProductoDAO implements IProductoDAO{
	
	private static ProductoDAO INSTANCE = null;
	
	private final static Logger LOG = Logger.getLogger(ProductoDAO.class);
	
	private static final String SQL_GET_ALL = "SELECT id, nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria FROM producto ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria  FROM producto WHERE id=?;";
	private static final String SQL_GET_BY_ID_BY_USER = "SELECT id, nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria  FROM producto WHERE id = ? AND id_usuario = ?;";
	private static final String SQL_GET_ALL_BY_USER = "SELECT p.id, p.nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria  FROM producto p, usuario u " 
													+ " WHERE p.id_usuario = u.id AND u.id = ? ORDER BY p.id DESC LIMIT 500;";
	//private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT nombre FROM producto ORDER BY u.nombre ASC LIMIT 500;";
	//private static final String SQL_EXISTE = " SELECT id, nombre, descripcion, imagen, precio, descuento FROM producto WHERE id = ? AND nombre = ?;";
	//private static final String SQL_EXISTE_NOMBRE = " SELECT nombre FROM producto WHERE nombre = ?;";
	private static final String SQL_INSERT = "INSERT INTO producto (nombre, descripcion, imagen, precio, descuento, id_usuario, id_categoria) VALUES ( ? , ?, ?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE = "UPDATE producto SET nombre= ?, descripcion= ?, imagen= ?, precio= ?, descuento= ?, id_usuario = ?, id_categoria = ? WHERE id = ?;";
	private static final String SQL_UPDATE_BY_USER = "UPDATE producto SET nombre= ?, descripcion= ?, imagen= ?, precio= ?, descuento= ?, id_usuario = ?, id_categoria = ? WHERE id = ? AND id_usuario = ?;";
	private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ?;";
	private static final String SQL_DELETE_BY_USER = "DELETE FROM producto WHERE id = ? AND id_usuario = ?;";
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
				
				Producto p = mapper(rs);
				lista.add(p);

			}

		} catch (SQLException e) {
			LOG.error(e);
		}

		return lista;
	}
	
	@Override
	public ArrayList<Producto> getAllByUser(int id) {
		
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (
				
			Connection con = ConnectionManager.getConnection();
				
			PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_USER);
					
		) {
			
			pst.setInt(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					
					Producto p = mapper(rs);
					lista.add(p);

				}
			} catch (NumberFormatException e) {
				LOG.error(e);
			} catch (Exception e) {
				LOG.error(e);
			}

		} catch (SQLException e) {
			
			LOG.error("Ha ocurrido un error a la hora de lista los productos por usuario: " + e);
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
					
					resul = mapper(rs);
					
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return resul;
	}
	
	@Override
	public Producto getByIdByUser(int idProducto, int idUsuario) throws ProductoException {
		
		Producto resul = null;
		
		try (			
				Connection con = ConnectionManager.getConnection();				
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID_BY_USER);
						
			) {

			pst.setInt(1, idProducto);
			pst.setInt(2, idUsuario);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					
					resul = new Producto();
					resul = mapper(rs);
					
				} else {
					
					throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
					
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
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
	public Producto deleteByUser(int idProducto, int idUsuario) throws ProductoException {
		
		Producto resul = this.getByIdByUser(idProducto, idUsuario);
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_DELETE_BY_USER);
				
		) {

			pst.setInt(1, idProducto);
			pst.setInt(2, idUsuario);
			
			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				
				LOG.info("Eliminacion completada. Prodcuto = " + resul.toString());
				
			} else {
				
				throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
				
			}

		} catch (SQLException e) {
			LOG.error(e);
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
			pst.setInt(6, pojo.getUsuario().getId());
			pst.setInt(7, pojo.getCategoria().getId());
			pst.setInt(8, id);

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
	public Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException {
		
		Producto resul = null;
		
		try (
				
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE_BY_USER);		
				
		) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getDescripcion());
			pst.setString(3, pojo.getImagen());
			pst.setFloat(4, pojo.getPrecio());
			pst.setInt(5, pojo.getDescuento());
			pst.setInt(6, pojo.getUsuario().getId());
			pst.setInt(7, pojo.getCategoria().getId());
			pst.setInt(8, idProducto);
			pst.setInt(9, idUsuario);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				
				resul = this.getByIdByUser(idProducto, idUsuario);
				
			} else {
				
				throw new ProductoException(ProductoException.EXCEPTION_UNAUTORIZED);
				
			}
		} catch (SQLException e) {
			LOG.error(e);
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
			pst.setInt(6, pojo.getUsuario().getId());
			pst.setInt(7, pojo.getCategoria().getId());

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
	
	private Producto mapper(ResultSet rs) throws NumberFormatException, Exception {
		
		UsuarioDAO daoUsuario = UsuarioDAO.getIntance();
		
		CategoriaDAO daoCategoria = CategoriaDAO.getIntance();
		
		Producto p = new Producto();
		
		p.setId(rs.getInt("id"));
		p.setNombre(rs.getString("nombre"));
		p.setDescripcion(rs.getString("descripcion"));
		p.setImagen(rs.getString("imagen"));
		p.setPrecio(Float.parseFloat(rs.getString("precio")));
		p.setDescuento(Integer.parseInt(rs.getString("descuento")));
		p.setUsuario(daoUsuario.getById(Integer.parseInt(rs.getString("id_usuario"))));
		
		p.setCategoria(daoCategoria.getById(rs.getInt("id_categoria")));
		
		return p;
	}

}
