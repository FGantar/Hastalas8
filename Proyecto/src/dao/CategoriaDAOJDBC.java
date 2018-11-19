package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Categoria;

/**
 * Clase DAO categoria
 * @author John
 * @version 16.11.2018
 */

public class CategoriaDAOJDBC {

	/**
	 * Especificamos como nos conectaremos a la BBDD
	 */

	private Connection con = null;

	public CategoriaDAOJDBC() {
		this.con = new Conex().getConex();
	}

	/**
	 * Metoto para añadir una nueva categoria
	 */

	public void annadirCategoria(Categoria categoria) throws DAOException {
		try (Statement stmt = con.createStatement()) {

			String query = "INSERT INTO CATEGORIA VALUES (" + categoria.getId() + "," + categoria.getNombre() + ")";
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error al añadir categoria");
			}

		} catch (SQLException se) {
			throw new DAOException("Error añadiendo categoria en DAO", se);
		}
	}

	/**
	 * Metodo para modificar las categorias de la BBDD
	 */

	public void modificarCategoria(Categoria categoria) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE CATEGORIA SET ID_CATEGORIA='" + categoria.getId() + "',   NOMBRE_CAT='"
					+ categoria.getNombre() + "'" + "WHERE NOMBRE_CAT = '" + categoria.getNombre();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando la categoria");
			}

		} catch (SQLException se) {
			throw new DAOException("Error modificando categoria en DAO", se);
		}

	}

	/**
	 * Metodo para mostrar todas las categorias
	 */
	public ArrayList<Categoria> getListaPelicula() throws DAOException {
		ArrayList<Categoria> categorias = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM CATEGORIA";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				categorias.add(new Categoria(rs.getInt("ID_CATEGORIA"), rs.getString("NOMBRE_CAT")));
			}

		} catch (SQLException se) {
			throw new DAOException("Error obteniendo las categorias en DAO: " + se.getMessage(), se);
		}
		return categorias;
	}

}
