package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Pelicula;
import utilidades.Fichero;

/**
 * CLASE USUARIODAOJDBC
 * Contiene métodos de gestión de peliculas accediendo a la base de datos
 * @author Cristian G. Fortes
 *
 */

public class PeliculaDAOJDBC {

	private static Logger logger = LogManager.getLogger(PeliculaDAOJDBC.class);
	private Connection con = null;

	public static final String rutaFichero = "src/Peliculas.txt";

	public PeliculaDAOJDBC() {
		this.con = new Conex().getConex();
	}

	/**
	 * Método para insertar una pelicula a la base de datos 
	 * @param film
	 * @throws DAOException
	 */
	public void annadirPelicula(Pelicula film) throws DAOException {
		Pelicula pelicula = buscarPorID(film.getId());
		if (pelicula != null) {
			System.out.println("La pelicula con id: " + pelicula.getId() + " ya existe.");
		} else {
			try (Statement stmt = con.createStatement()) {

				System.out.println(film);
				String query = "INSERT INTO PELICULA VALUES (" + film.getId() + "," + "'" + film.getNombre() + "',"
						+ film.getAnno() + "," + film.getCategoria() + "," + film.getVista() + ","
						+ film.getValoracion() + ")";

				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error al añadir pelicula");
				}
			} catch (SQLException se) {
				logger.warn("ERROR" + se.getMessage());
				throw new DAOException("Error añadiendo pelicula en DAO", se);

			}
		}
	}

	/**
	 * Metodo para modificar una pelicula en la base de datos
	 * @param film
	 * @throws DAOException
	 */
	public void modificarPelicula(Pelicula film) throws DAOException {
		Pelicula pel = buscarPorID(film.getId());
		if (pel == null) {
			System.out.println("La pelicula con id: " + film.getId() + " no existe.");
		} else {
			try (Statement stmt = con.createStatement()) {
				String query = "UPDATE PELICULA SET NOMBRE_PEL='" + film.getNombre() + "'," + "ANNO_ESTRENO='"
						+ film.getAnno() + "'," + "CATEGORIA_ID=" + film.getCategoria() + "," + "VISTA="
						+ film.getVista() + ", VALORACION=" + film.getValoracion() + " WHERE ID_PELICULA=" + film.getId();
				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error modificando pelicula");
				}
			} catch (SQLException se) {
				logger.warn("Error " + se.getMessage());
				throw new DAOException("Error modificando pelicula en DAO", se);
			}
		}
	}
	
	public void borrarPelicula(int idPelicula) throws DAOException {
		Pelicula film = buscarPorID(idPelicula);
		if (film == null) {
			System.out.println("La pelicula con id: " + idPelicula + " no existe para borrar.");
		} else {
			try (Statement stmt = con.createStatement()) {
				String query = "DELETE FROM PELICULA WHERE ID_PELICULA=" + idPelicula;
				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error borrando pelicula");
				}
			} catch (SQLException se) {
				logger.warn("Error " + se.getMessage());
				throw new DAOException("Error borrando pelicula en DAO", se);
			}
		}
	}

	/**
	 * Cogemos la lista de las 25 películas del fichero y las metemos en un
	 * ArrayList<Peliculas> para cargar la Tabla SQL Pelicula. Posteriormente
	 * todos los métodos de añadir, modificar, ver... se realizan refiriendose a
	 * la tabla.
	 */

	public static ArrayList<Pelicula> dameLasPeliculasFichero() {
		ArrayList<Pelicula> peliculasCargadas = new ArrayList<>();

		ArrayList<String> pelisFichero = Fichero.LeerFichero(rutaFichero);

		if (pelisFichero != null) {
			for (String valor : pelisFichero) {
				peliculasCargadas.add(stringToPelicula(valor));
			}
		}
		return peliculasCargadas;
	}

	 /**
	 * El método stringToPelicula() nos permite convertir el String del Fichero
	 * separado por "," en objetos Pelicula.
	 * @param peliculaString
	 * @return Pelicula
	 */

	private static Pelicula stringToPelicula(String peliculaString) {
		Pelicula peliculaObjeto = new Pelicula();

		if (peliculaString != null && peliculaString != "") {
			String[] datosPelicula = peliculaString.split(",");

			if (datosPelicula.length == 6) {
				peliculaObjeto.setId(Integer.parseInt(datosPelicula[0].trim()));
				peliculaObjeto.setNombre(datosPelicula[1].trim());
				peliculaObjeto.setAnno(Integer.parseInt(datosPelicula[2].trim()));
				peliculaObjeto.setCategoria(Integer.parseInt(datosPelicula[3].trim()));
				peliculaObjeto.setVista(Integer.parseInt(datosPelicula[4].trim()));
				peliculaObjeto.setValoracion(Integer.parseInt(datosPelicula[5].trim()));
			}
		}

		return peliculaObjeto;
	}

	/**
	 * 
	 * Metodo getListaPelicula devuelve una lista de películas
	 * @return ArrayList<Pelicula>
	 * @throws DAOException
	 */
	public ArrayList<Pelicula> getListaPelicula() throws DAOException {
		ArrayList<Pelicula> films = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULA";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				films.add(new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ANNO_ESTRENO"), rs.getInt("CATEGORIA_ID"),
						rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("ID_PELICULA")));
			}

		} catch (SQLException se) {
			throw new DAOException("Error obteniendo las películas en DAO: " + se.getMessage(), se);
		}
		return films;
	}

	/**
	 * Metodo peliculaMasVista devuelve la película mas vista
	 * @return Pelicula
	 * @throws DAOException
	 */
	public Pelicula peliculaMasVista() throws DAOException {
		Pelicula film = null;
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULA ORDER BY VISTA DESC LIMIT 1";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				film = new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ANNO_ESTRENO"), rs.getInt("CATEGORIA_ID"),
						rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("ID_PELICULA"));
			}
		} catch (SQLException se) {
			throw new DAOException("Error obteniendo las películas en DAO: " + se.getMessage(), se);
		}
		return film;
	}

	/**
	 * Metodo peliculaMasValorada devuelve la película mas valorada
	 * 
	 * @return Pelicula
	 * @throws DAOException
	 */
	public Pelicula peliculaMasValorada() throws DAOException {
		Pelicula film = null;
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULA ORDER BY VALORACION DESC LIMIT 1";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				film = new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ANNO_ESTRENO"), rs.getInt("CATEGORIA_ID"),
						rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("ID_PELICULA"));
			}
		} catch (SQLException se) {
			throw new DAOException("Error obteniendo las películas en DAO: " + se.getMessage(), se);
		}
		return film;
	}

	/**
	 * Metodo buscarPorID busca una Pelicula por id y la devuelve
	 * 
	 * @param idPelicula
	 * @return Pelicula
	 * @throws DAOException
	 */
	public Pelicula buscarPorID(int idPelicula) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULA WHERE ID_PELICULA=" + idPelicula;
			ResultSet rs = stmt.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			return (new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ID_PELICULA"), rs.getInt("ANNO_ESTRENO"),
					rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("CATEGORIA_ID")));
		} catch (SQLException se) {
			logger.warn("Error " + se.getMessage());
			throw new DAOException("Error buscando película en DAO", se);
		}
	}
	
	/**
	 * Metodo getListaPeliculasFiltradas devuleve una arraylist de peliculas filtradas
	 * por una categoria
	 * 
	 * @param catID
	 * @return ArrayList<Pelicula>
	 * @throws DAOException
	 */
	public ArrayList<Pelicula> getListaPeliculasFiltrada(int catID) throws DAOException {
		ArrayList<Pelicula> films = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULA WHERE CATEGORIA_ID=" + catID;
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				films.add(new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ANNO_ESTRENO"), rs.getInt("CATEGORIA_ID"),
						rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("ID_PELICULA")));
			}

		} catch (SQLException se) {
			throw new DAOException("Error obteniendo las películas en DAO: " + se.getMessage(), se);
		}
		return films;
	}

}
