package servicios;

import java.util.ArrayList;

import dao.CategoriaDAOJDBC;
import dao.DAOException;
import model.Categoria;

/**
 * Nombre clase: ServiciosCategoria Descripci�n: Implementamos la interfaz
 * Gen�rica OperacionesImpl con los m�todos a�adir, modificar, borrar y mostrar.
 * 
 * @version: 19.11.2018
 * @author: John
 */

public class ServiciosCategoria implements OperacionesImpl<Categoria, Integer> {

	/**
	 * Crear el objeto categoria de la clase CategoriaDAOJDBC
	 */
	private CategoriaDAOJDBC categoriaDAO = new CategoriaDAOJDBC();

	/**
	 * Metodos, a�adir, modificar categoria correspondientes, borrar vacio
	 * puesto que no se necesita metodo getlistaCategoria para mostrar las
	 * categorias existantes
	 */

	@Override
	public void annadir(Categoria categoria) throws DAOException {
		categoriaDAO.annadirCategoria(categoria);
	}

	@Override
	public void modificar(Categoria c) throws DAOException {
		categoriaDAO.modificarCategoria(c);

	}

	@Override
	public void borrar(Integer id) throws DAOException {
	}

	@Override
	public ArrayList<Categoria> mostrarTodo() throws DAOException {
		return categoriaDAO.getListaPelicula();
	}

}
