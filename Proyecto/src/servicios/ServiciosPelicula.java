package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

/**Nombre clase: ServiciosPelicula
 * Descripci�n: Implementamos la interfaz Gen�rica OperacionesImpl con los m�todos a�adir, modificar, borrar y mostrar.
 * Realizamos un m�todo que realice una carga inicial de 25 peliculas desde un fichero Peliculas.txt a la BBDD.
 * Llamamos a los m�todos de capa PeliculaDAO que muestra la pel�cula m�s vista, m�todo que muestra la pelicula m�s valorada y m�todo que muestra la lista de pel�culas filtradas por id.
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
	 * M�todos de la Interfaz gen�rica implementada OperacionesImpl
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
	 * M�todo que muestra la pel�cula m�s vista por los usuarios y m�todo que
	 * muestra la m�s valorada.
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
