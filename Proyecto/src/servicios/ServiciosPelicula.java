package servicios;

import java.util.ArrayList;

import model.Pelicula;
import model.Usuario;

public class ServiciosPelicula implements OperacionesImpl<Pelicula>{

	PeliculaDAOJDBC pelicula = new PeliculaDAOJDBC();
	
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
		System.out.println("Servivio proximo");
		return null;
	}
	
	

}
