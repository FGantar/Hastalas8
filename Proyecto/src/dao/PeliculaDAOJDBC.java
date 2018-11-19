package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Pelicula;
import model.Usuario;
import utilidades.Fichero;

public class PeliculaDAOJDBC {

	private static Logger logger = LogManager.getLogger(Fichero.class);
	private Connection con = null;

	public static final String rutaFichero = "src/Peliculas.txt";

	public PeliculaDAOJDBC() {
		this.con = new Conex().getConex();
	}

	public void annadirPelicula(Pelicula film) throws DAOException {
		Pelicula pelicula = buscarPorID(film.getId());
		if (pelicula != null) {
			// throw new DAOException("El Usuario con id: " +
			// user2.getIdUsuario() + " ya existe.");
			System.out.println("La pelicula con id: " + pelicula.getId() + " ya existe.");
		} else {
			try (Statement stmt = con.createStatement()) {

				System.out.println(film);
				String query = "INSERT INTO PELICULA VALUES (" + film.getId() + "," + "'" + film.getNombre() + "',"
						+ film.getAnno() + "," + film.getCategoria() + "," + film.getVista() + ","
						+ film.getValoracion() + ")";

				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error al a�adir pelicula");
				}
			} catch (SQLException se) {
				logger.warn("ERROR" + se.getMessage());
				throw new DAOException("Error a�adiendo pelicula en DAO", se);

			}
		}
	}

	public void modificarPelicula(Pelicula film) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE PELICULA SET ID_PELICULA='" + film.getId() + "',   NOMBRE_PEL='" + film.getNombre()
					+ "', ANNO_ESTRENO= " + film.getAnno() + "', CATEGORIA_ID = '" + film.getCategoria()
					+ "', VISTAS = '" + film.getVista() + "', VALORACION= '" + film.getValoracion() + "WHERE NOMBRE = '"
					+ film.getNombre();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando la pelicula");
			}

		} catch (SQLException se) {
			logger.warn("ERROR " + se.getMessage());
			throw new DAOException("Error modificando pelicula en DAO", se);
		}
	}

	/**
	 * Cogemos la lista de las 25 pel�culas del fichero y las metemos en un
	 * ArrayList<Peliculas> para cargar la Tabla SQL Pelicula. Posteriormente
	 * todos los m�todos de a�adir, modificar, ver... se realizan refiriendose a
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
	 * El m�todo stringToPelicula() nos permite convertir el String del Fichero
	 * separado por "," en objetos Pelicula.
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
			throw new DAOException("Error obteniendo las pel�culas en DAO: " + se.getMessage(), se);
		}
		return films;
	}

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
			throw new DAOException("Error obteniendo las pel�culas en DAO: " + se.getMessage(), se);
		}
		return film;
	}

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
			throw new DAOException("Error obteniendo las pel�culas en DAO: " + se.getMessage(), se);
		}
		return film;
	}

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
			throw new DAOException("Error buscando pel�cula en DAO", se);
		}
	}
	
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
			throw new DAOException("Error obteniendo las pel�culas en DAO: " + se.getMessage(), se);
		}
		return films;
	}

}
