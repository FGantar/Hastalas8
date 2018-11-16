package servicios;


import java.util.ArrayList;

import dao.DAOException;
import dao.UsuarioDAOJDBC;
import model.Usuario;

/**
 * Implementar la interfaz Gen�rica OperacionesImpl
 */

public class ServiciosUsuario implements OperacionesImpl<Usuario> {
	
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
	public void borrar(int IDusuario) throws DAOException{
		usuarioDAO.borrarUsuario(IDusuario);
	}

	@Override
	public ArrayList<Usuario> mostrarTodo() throws DAOException {
		return usuarioDAO.getListaUsuarios();}
		
	/** M�todo que muestra las pel�culas que el usuario puede ver.
	*/
	
	
	public void peliculasQuePuedeVer(Usuario user){
		
		usuarioDAO.peliculaQuePuedeVer();
		
	}
}


	

