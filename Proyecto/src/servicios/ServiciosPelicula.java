package servicios;

import java.util.ArrayList;

import dao.DAOException;
import dao.PeliculaDAOJDBC;
import model.Pelicula;

public class ServiciosPelicula implements OperacionesImpl {
	
	private PeliculaDAOJDBC peliculaDAO=new PeliculaDAOJDBC();

	@Override
	public void annadir(Object objeto) throws DAOException {
		peliculaDAO.annadirPelicula((Pelicula)objeto);
		
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
