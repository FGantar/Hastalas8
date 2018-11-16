package servicios;

import java.util.ArrayList;

import dao.DAOException;

/**
 *  Creamos una interfaz genérica con el fín de usarla para realizar operaciones con Usuario y Pelicula (también podría implementarse a una futura clase de Categorías como mejora).
 */

public interface OperacionesImpl<T> {
	
	public void annadir(T objeto) throws DAOException;
	
	public void modificar(T objeto);
	
	public void borrar(T objeto);
	
	public ArrayList<T> mostrarTodo();

}