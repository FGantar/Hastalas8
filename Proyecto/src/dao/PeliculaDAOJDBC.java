package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Usuario;

public class PeliculaDAOJDBC {
	
	private Connection con = null;

	public PeliculaDAOJDBC() {
		this.con = new Conex().getConex();
	}

	public void annadirPelicula(Pelicula film) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "INSERT INTO PELICULA VALUES (" + film.getIdPelicula() + "," + "'" + film.getNombre() + "',"
				 + film.getAnno() + ","  + film.getCategoria() + "," + film.getVistas() + "," + film.getValoracion() + ")";
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error añadiendo usuario");
			}
		} catch (SQLException se) {
			throw new DAOException("Error añadiendo usuario en DAO", se);
		}
	}

}
