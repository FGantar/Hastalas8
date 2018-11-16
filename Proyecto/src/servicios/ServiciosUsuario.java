package servicios;


import java.util.ArrayList;

import dao.UsuarioDAOJDBC;
import model.Usuario;

/**
 * Implementar la interfaz Genérica OperacionesImpl
 */

public class ServiciosUsuario implements OperacionesImpl<Usuario> {
	
	/**
	 * Crear objeto usuario de la clase UsuarioDAOJDBC
	 */

	UsuarioDAOJDBC usuario = new UsuarioDAOJDBC();
	
	/**
	 * Métodos de la Interfaz genérica implementada OperacionesImpl
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
	
	/** Método que muestra las películas que el usuario puede ver.
	 */
	
	public void peliculasQuePuedeVer(Usuario user){
		
		usuario.peliculaQuePuedeVer();
		
	}
}


	

