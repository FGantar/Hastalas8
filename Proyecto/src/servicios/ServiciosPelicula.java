package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

/**
 * Implementar la interfaz Genérica OperacionesImpl
 */

public class ServiciosPelicula implements OperacionesImpl<Pelicula,Integer> {
	
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
	public void borrar(Integer idPelicula) {
	}
	
	@Override
	public ArrayList<Pelicula> mostrarTodo() throws DAOException {
		return peliculaDAO.getListaPelicula();
	}
	
	/** Método que muestra la película más vista por los usuarios y método que muestra la más valorada.
	 * @throws DAOException 
	 */
	
	public Pelicula peliculaMasVista() throws DAOException{
		return peliculaDAO.peliculaMasVista();
	}
	
	public Pelicula peliculaMasValorada() throws DAOException{
		return peliculaDAO.peliculaMasValorada();
	}
	
	public void cargaInicialPeliculas()
	{
		ArrayList<Pelicula> peliculasFichero = PeliculaDAOJDBC.dameLasPeliculasFichero();
		
		if(peliculasFichero != null)
		{
			for(Pelicula pelicula : peliculasFichero)
			{
				try {
					annadir(pelicula);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	
}
