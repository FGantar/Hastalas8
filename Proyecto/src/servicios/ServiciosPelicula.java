package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

/**Nombre clase: ServiciosPelicula
 * Descripción: Implementamos la interfaz Genérica OperacionesImpl con los métodos añadir, modificar, borrar y mostrar.
 * Realizamos un método que realice una carga inicial de 25 peliculas desde un fichero Peliculas.txt a la BBDD.
 * Llamamos a los métodos de capa PeliculaDAO que muestra la película más vista, método que muestra la pelicula más valorada y método que muestra la lista de películas filtradas por id.
 * 
 * @version: 19.11.2018
 * @author: Rebeca
 */

public class ServiciosPelicula implements OperacionesImpl<Pelicula, Integer> {

	/**
	 * Crear objeto usuario de la clase PeliculaDAOJDBC
	 */

	private PeliculaDAOJDBC peliculaDAO = new PeliculaDAOJDBC();

	/**
	 * Métodos de la Interfaz genérica implementada OperacionesImpl
	 */

	@Override
	public void annadir(Pelicula pelicula) throws DAOException {
		peliculaDAO.annadirPelicula(pelicula);
	}

	@Override
	public void modificar(Pelicula p) throws DAOException {
		peliculaDAO.modificarPelicula(p);
	}

	@Override
	public void borrar(Integer idPelicula) {
	}

	@Override
	public ArrayList<Pelicula> mostrarTodo() throws DAOException {
		return peliculaDAO.getListaPelicula();
	}

	/**
	 * Método que muestra la película más vista por los usuarios y método que
	 * muestra la más valorada.
	 * 
	 * @throws DAOException
	 */

	public Pelicula peliculaMasVista() throws DAOException {
		return peliculaDAO.peliculaMasVista();
	}

	public Pelicula peliculaMasValorada() throws DAOException {
		return peliculaDAO.peliculaMasValorada();
	}

	public void cargaInicialPeliculas() {
		ArrayList<Pelicula> peliculasFichero = PeliculaDAOJDBC.dameLasPeliculasFichero();

		if (peliculasFichero != null) {
			for (Pelicula pelicula : peliculasFichero) {
				try {
					annadir(pelicula);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Pelicula> mostrarPeliculasFiltradas(int catID) throws DAOException {
		return peliculaDAO.getListaPeliculasFiltrada(catID);
	}

}
