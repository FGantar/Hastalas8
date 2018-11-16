package servicios;

import java.util.ArrayList;

import dao.DAOException;

/**
 *  Creamos una interfaz gen�rica con el f�n de usarla para realizar operaciones con Usuario y Pelicula (tambi�n podr�a implementarse a una futura clase de Categor�as como mejora).
 */

public interface OperacionesImpl<T> {
	
	public void annadir(T objeto) throws DAOException;
	
	public void modificar(T objeto);
	
	public void borrar(T objeto);
	
	public ArrayList<T> mostrarTodo();

}