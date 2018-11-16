package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pelicula;
import model.Usuario;

public class PeliculaDAOJDBC {

	private Connection con = null;

	public PeliculaDAOJDBC() {
		this.con = new Conex().getConex();
	}

	public void annadirPelicula(Pelicula film) throws DAOException {
		try (Statement stmt = con.createStatement()) {

			String query = "INSERT INTO PELICULA VALUES (" + film.getIdPelicula() + "," + "'" + film.getNombre() + "',"
					+ film.getAnno() + "," + film.getCategoria() + "," + film.getVistas() + "," + film.getValoracion()
					+ ")";

			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error al añadir pelicula");
			}
		} catch (SQLException se) {
			throw new DAOException("Error añadiendo pelicula en DAO", se);
		}
	}

	public void modificarPelicula(Pelicula film) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE PELICULA SET ID_PELICULA='" + film.getId() + "',   NOMBRE_PEL='"+film.getNombre()+"', ANNO_ESTRENO= "+film.getAnno()+
								"', CATEGORIA_ID = '"+film.getCategoria()+"', VISTAS = '"+film.getVista()+"', VALORACION= '"+film.getValoracion()+
								"WHERE NOMBRE = '" + film.getNombre();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando la pelicula");
			}

		} catch (SQLException se) {
			throw new DAOException("Error modificando pelicula en DAO", se);
		}
	}

}
