package servicios;

import java.util.ArrayList;

<<<<<<< HEAD
import dao.PeliculaDAOJDBC;

public class ServiciosPelicula implements OperacionesImpl {
	
	private PeliculaDAOJDBC peliculaDAO=new PeliculaDAOJDBC();

	@Override
	public void annadir(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Object objeto) {
		
		
	}

	@Override
	public void borrar(Object objeto) {
		peliculaDAO.borrarPelicula();
		
	}

	@Override
	public ArrayList mostrarTodo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void peliculasMasVistas(Pelicula p){
		peliculaDAO.peliculasVistas(p);
	}
	
	public void peliculasMasValoradas(Pelicula p){
		peliculaDAO.peliculasVistas(p);
	}
	

	

=======
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
>>>>>>> branch 'master' of https://github.com/FGantar/Hastalas8.git
}
