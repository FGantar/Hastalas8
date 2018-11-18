package servicios;


import java.util.ArrayList;

import dao.DAOException;
import dao.UsuarioDAOJDBC;
import model.Pelicula;
import model.Usuario;

/**
 * Implementar la interfaz Gen�rica OperacionesImpl
 */

public class ServiciosUsuario implements OperacionesImpl<Usuario,Integer> {
	
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
	public void borrar(Integer idUsuario) throws DAOException{
		usuarioDAO.borrarUsuario(idUsuario);
	}

	@Override
	public ArrayList<Usuario> mostrarTodo() throws DAOException {
		return usuarioDAO.getListaUsuarios();}
		
	/** M�todo que muestra las pel�culas que el usuario puede ver.
	 * @throws DAOException 
	*/
	
	
	public ArrayList<Pelicula> peliculasQuePuedeVer(Usuario user) throws DAOException{
		
		return usuarioDAO.peliculasQuePuedeVer(user);
		
	}
}


	

