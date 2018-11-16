package servicios;

import java.util.ArrayList;

import model.Pelicula;
import model.Usuario;

/**
 * Implementar la interfaz Genérica OperacionesImpl
 */

public class ServiciosPelicula implements OperacionesImpl<Pelicula>{
	
	/**
	 * Crear objeto pelicula de la clase PeliculaDAOJDBC
	 */

	PeliculaDAOJDBC pelicula = new PeliculaDAOJDBC();
	
	/**
	 * Métodos de la Interfaz
	 */
	
	@Override
	public void annadir(Pelicula pelicula) {
		pelicula.annadirPelicula(pelicula);
		
	}

	@Override
	public void modificar(Pelicula pelicula) {
		pelicula.modificarPelicula(pelicula);
		
	}

	@Override
	public void borrar(Pelicula objeto) {
		System.out.println("Servivio proximo");
		
	}

	@Override
	public ArrayList<Pelicula> mostrarTodo() {
		
		return pelicula.getListaPeliculas();
	}
}
