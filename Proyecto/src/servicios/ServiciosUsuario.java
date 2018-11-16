package servicios;


import java.util.ArrayList;

public class ServiciosUsuario implements OperacionesImpl<Usuario> {

	UsuarioDAOJDBC usuario = new UsuarioDAOJDBC();
	
	@Override
	public void annadir(Usuario usuario) {
		usuarioDAOJDBC.annadirUsuario(usuario);
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
	
	

}


	

