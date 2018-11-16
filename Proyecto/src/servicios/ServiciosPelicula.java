package servicios;

import java.util.ArrayList;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

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

	
	
	public void peliculasMasVistas(Pelicula p){
		peliculaDAO.peliculasMasVistas(p);
	}
	
	public void peliculasMasValoradas(Pelicula p){
		peliculaDAO.peliculasMasValoradas(p);
	}
	

	@Override
	public ArrayList<Pelicula> mostrarTodo() {
		
		return peliculaDAO.getListaPeliculas();
	}
}
