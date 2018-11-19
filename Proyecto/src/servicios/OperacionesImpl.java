package servicios;

import java.util.ArrayList;

import dao.DAOException;

/**
 * Nombre clase: interface OperacionesImpl<T, U> Descripción: Creamos una
 * interfaz genérica con el fín de usarla para realizar operaciones con Usuario
 * y Pelicula (también podría implementarse a una futura clase de Categorías
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