package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Pelicula;
import model.Usuario;
import utilidades.Fichero;

public class PeliculaDAOJDBC {

	private Connection con = null;
	
	public static final String rutaFichero = "Peliculas.txt";

	public PeliculaDAOJDBC() {
		this.con = new Conex().getConex();
	}

	public void annadirPelicula(Pelicula film) throws DAOException {
		try (Statement stmt = con.createStatement()) {

			String query = "INSERT INTO PELICULA VALUES (" + film.getId() + "," + "'" + film.getNombre() + "',"
					+ film.getAnno() + "," + film.getCategoria() + "," + film.getVista() + "," + film.getValoracion()
					+ ")";

			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error al añadir pelicula");
			}
		} catch (SQLException se) {
			throw new DAOException("Error añadiendo pelicula en DAO", se);
		}
	}

	public void modificarPelicula(Pelicula film) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE PELICULA SET ID_PELICULA='" + film.getId() + "',   NOMBRE_PEL='"+film.getNombre()+"', ANNO_ESTRENO= "+film.getAnno()+
								"', CATEGORIA_ID = '"+film.getCategoria()+"', VISTAS = '"+film.getVista()+"', VALORACION= '"+film.getValoracion()+
								"WHERE NOMBRE = '" + film.getNombre();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando la pelicula");
			}

		} catch (SQLException se) {
			throw new DAOException("Error modificando pelicula en DAO", se);
		}
	}
	
	/**
	 *  Cogemos la lista de las 25 películas del fichero y las metemos en un ArrayList<Peliculas> para cargar la Tabla SQL Pelicula. Posteriormente todos los métodos de añadir, modificar, ver... se realizan refiriendose a la tabla.
	 */
	
		public static ArrayList<Pelicula> dameLasPeliculasFichero(){
			ArrayList<Pelicula> peliculasCargadas = new ArrayList<>();
		
			ArrayList<String> pelisFichero = Fichero.LeerFichero(rutaFichero);
		
			if(pelisFichero != null)
			{
				for(String valor: pelisFichero)
				{
					peliculasCargadas.add(stringToPelicula(valor));}
			}
			return peliculasCargadas;
		}
			
	/**
	 * El método stringToPelicula() nos permite convertir el String del Fichero separado por "," en objetos Pelicula.
	 */
		
		private static Pelicula stringToPelicula(String peliculaString){
			Pelicula peliculaObjeto = new Pelicula();
		
			if(peliculaString != null && peliculaString != "")
			{
				String[] datosPelicula = peliculaString.split(",");
				
				if(datosPelicula.length == 6)
				{
					peliculaObjeto.setId(Integer.parseInt(datosPelicula[0]));
					peliculaObjeto.setNombre(datosPelicula[1]);
					peliculaObjeto.setAnno(Integer.parseInt(datosPelicula[2]));
					peliculaObjeto.setCategoria(Integer.parseInt(datosPelicula[3]));
					peliculaObjeto.setVista(Integer.parseInt(datosPelicula[4]));
					peliculaObjeto.setValoracion(Integer.parseInt(datosPelicula[5]));
				}
			}
		
			return peliculaObjeto;
		}


}
