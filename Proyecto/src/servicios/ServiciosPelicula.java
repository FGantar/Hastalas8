package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

/**
 * Implementar la interfaz Genérica OperacionesImpl
 */

public class ServiciosPelicula implements OperacionesImpl<Pelicula> {
	
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
	public void modificar(Pelicula p) {
	}

	@Override
	public void borrar(Pelicula p) {
	}
	
	@Override
	public ArrayList<Pelicula> mostrarTodo() {
		return peliculaDAO.getListaPeliculas();
	}
	
	/** Método que muestra la película más vista por los usuarios y método que muestra la más valorada.
	 */
	
	public void peliculasMasVistas(){
		peliculaDAO.peliculaMasVista();
	}
	
	public void peliculasMasValoradas(){
		peliculaDAO.peliculaMasValorada();
	}
	

	
}
