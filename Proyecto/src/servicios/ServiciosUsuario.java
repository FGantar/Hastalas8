package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.UsuarioDAOJDBC;
import model.Pelicula;
import model.Usuario;

/** Nombre clase: ServiciosUsuario
 * Descripci�n: Implementamos la interfaz Gen�rica OperacionesImpl con los m�todos a�adir, modificar, borrar y mostrar.
 * Llamamos a los m�todos de capa UsuarioDAO que muestra las pel�culas que el usuario puede ver y m�todo que muestra las peliculas que no ha visto.
 * 
 * @version: 19.11.2018
 * @author: Rebeca
 * 
 */

public class ServiciosUsuario implements OperacionesImpl<Usuario, Integer> {

	/**
	 * Crear objeto usuario de la clase UsuarioDAOJDBC
	 */

	UsuarioDAOJDBC usuarioDAO = new UsuarioDAOJDBC();

	/**
	 * M�todos de la Interfaz gen�rica implementada OperacionesImpl
	 */

	@Override
	public void annadir(Usuario usuario) throws DAOException {
		usuarioDAO.annadirUsuario(usuario);
	}

	@Override
	public void modificar(Usuario usuario) throws DAOException {
		usuarioDAO.modificarUsuario(usuario);
	}

	@Override
	public void borrar(Integer idUsuario) throws DAOException {
		usuarioDAO.borrarUsuario(idUsuario);
	}

	@Override
	public ArrayList<Usuario> mostrarTodo() throws DAOException {
		return usuarioDAO.getListaUsuarios();
	}

	/**
	 * M�todo que muestra las pel�culas que el usuario puede ver y m�todo que muestra las peliculas que no ha visto.
	 * 
	 * @throws DAOException
	 */

	public ArrayList<Pelicula> peliculasQuePuedeVer(int idUsuario) throws DAOException {

		return usuarioDAO.peliculasQuePuedeVer(idUsuario);

	}

	public ArrayList<Pelicula> peliculasNoVistas(int idUsuario) throws DAOException {

		return usuarioDAO.peliculasNoVistas(idUsuario);

	}

}
