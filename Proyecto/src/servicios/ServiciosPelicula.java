package servicios;

import java.util.ArrayList;

import dao.PeliculaDAOJDBC;

public class ServiciosPelicula implements OperacionesImpl {
	
	private PeliculaDAOJDBC peliculaDAO=new PeliculaDAOJDBC();

	@Override
	public void annadir(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Object objeto) {
		
		
	}

	@Override
	public void borrar(Object objeto) {
		peliculaDAO.borrarPelicula();
		
	}

	@Override
	public ArrayList mostrarTodo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void peliculasMasVistas(Pelicula p){
		peliculaDAO.peliculasVistas(p);
	}
	
	public void peliculasMasValoradas(Pelicula p){
		peliculaDAO.peliculasVistas(p);
	}
	

	

}
