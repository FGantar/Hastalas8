package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Categoria;

public class CategoriaDAOJDBC {
	
	/*
	 * Especificamos como el nos conectaremos a la BBDD
	 */
	
	private Connection con = null;
	
	public CategoriaDAOJDBC(){
		this.con = new Conex().getConex();
	}
	
	/*
	 * Metoto para a�adir una nueva categoria
	 */
	
	public void annadirCategoria(Categoria categoria) throws DAOException{
		try (Statement stmt = con.createStatement()) {
			
			String query = "INSERT INTO CATEGORIA VALUES ("+categoria.getId()+","+categoria.getNombre()+")";
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error al a�adir categoria");}
		
		} catch (SQLException se) {
			throw new DAOException("Error a�adiendo categoria en DAO", se);
		}
	}
	
	/*
	 * Metodo para modificar las categorias de la BBDD
	 */
	
	public void modificarCategoria(Categoria categoria) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE CATEGORIA SET ID_CATEGORIA='" + categoria.getId() + "',   NOMBRE_CAT='"+categoria.getNombre()+"'"+
								"WHERE NOMBRE_CAT = '" + categoria.getNombre();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando la categoria");
			}

		} catch (SQLException se) {
			throw new DAOException("Error modificando categoria en DAO", se);
		}
		
		
	}
	
	
	

}
