package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

/**
 * Implementar la interfaz Gen�rica OperacionesImpl
 */

public class ServiciosPelicula implements OperacionesImpl<Pelicula> {
	
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
	public void modificar(Pelicula p) {
	}

	@Override
	public void borrar(Pelicula p) {
	}
	
	@Override
	public ArrayList<Pelicula> mostrarTodo() {
		return peliculaDAO.getListaPeliculas();
	}
	
	/** M�todo que muestra la pel�cula m�s vista por los usuarios y m�todo que muestra la m�s valorada.
	 */
	
	public void peliculasMasVistas(){
		peliculaDAO.peliculaMasVista();
	}
	
	public void peliculasMasValoradas(){
		peliculaDAO.peliculaMasValorada();
	}
	

	
}
