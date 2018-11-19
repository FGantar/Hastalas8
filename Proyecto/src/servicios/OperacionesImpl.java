package servicios;

import java.util.ArrayList;

import dao.DAOException;

/**
 * Nombre clase: interface OperacionesImpl<T, U> Descripci�n: Creamos una
 * interfaz gen�rica con el f�n de usarla para realizar operaciones con Usuario
 * y Pelicula (tambi�n podr�a implementarse a una futura clase de Categor�as
 * como mejora).
 * 
 * @version: 19.11.2018
 * @author: Rebeca
 * 
 * 
 */

public interface OperacionesImpl<T, U> {

	public void annadir(T objeto) throws DAOException;

	public void modificar(T objeto) throws DAOException;

	public void borrar(U id) throws DAOException;

	public ArrayList<T> mostrarTodo() throws DAOException;

}