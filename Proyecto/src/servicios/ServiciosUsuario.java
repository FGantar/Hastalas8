package servicios;


import java.util.ArrayList;

import dao.UsuarioDAOJDBC;
import model.Usuario;

public class ServiciosUsuario implements OperacionesImpl<Usuario> {

	UsuarioDAOJDBC usuario = new UsuarioDAOJDBC();
	
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
	
	public void peliculasQuePuedeVer(Usuario user){
		
		usuario.peliculaQuePuedeVer();
		
		
		
	}
	

}


	

