package servicios;


import java.util.ArrayList;

import dao.UsuarioDAOJDBC;
import model.Usuario;

/**
 * Implementar la interfaz Gen�rica OperacionesImpl
 */

public class ServiciosUsuario implements OperacionesImpl<Usuario> {
	
	/**
	 * Crear objeto usuario de la clase UsuarioDAOJDBC
	 */

	UsuarioDAOJDBC usuario = new UsuarioDAOJDBC();
	
	/**
	 * M�todos de la Interfaz gen�rica implementada OperacionesImpl
	 */
	
	@Override
	public void annadir(Usuario usuario) {
		UsuarioDAOJDBC.annadirUsuario(usuario);
	}
	
	@Override
	public boolean modificar(Usuario usuario) {
		usuario.modificarUsuario(usuario);
	}

	@Override
	public void borrar(Usuario usuario) {
		usuario.borrarUsuario(usuario);
	}

	@Override
	public ArrayList<Usuario> mostrarTodo() {
		
		return usuario.getListaUsuarios();
	}
	
	/** M�todo que muestra las pel�culas que el usuario puede ver.
	 */
	
	public void peliculasQuePuedeVer(Usuario user){
		
		usuario.peliculaQuePuedeVer();
		
	}
}


	

