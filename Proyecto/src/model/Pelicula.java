package model;

import java.io.IOException;

import utilidades.LeerDatos;

/**
 * 
 * CLASE PEL�CULA Contiene informaci�n de las pel�culas, m�todos para crear
 * nuevas pel�culas y obtener el nombre de la categor�a a partir de la id de
 * esta.
 * 
 * @author Rebeca Aceituno
 * @version 15.11.2018
 *
 */

public class Pelicula {

	/**
	 * propiedades de la clase Pelicula
	 */

	private String nombre;
	private int anno;
	private int categoria;
	private int vista;
	private int valoracion;
	private int id;

	/**
	 * Constructores: vac�o y con todos los par�metros
	 */

	public Pelicula() {
		super();
	}

	public Pelicula(String nombre, int anno, int categoria, int vista, int valoracion, int id) {
		super();
		this.nombre = nombre;
		this.anno = anno;
		this.categoria = categoria;
		this.vista = vista;
		this.valoracion = valoracion;
		this.id = id;
	}

	/**
	 * Getters y setters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getVista() {
		return vista;
	}

	public void setVista(int vista) {
		this.vista = vista;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * To String, HasCode and equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + categoria;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + valoracion;
		result = prime * result + vista;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (anno != other.anno)
			return false;
		if (categoria != other.categoria)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (valoracion != other.valoracion)
			return false;
		if (vista != other.vista)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pelicula [T�tulo=");
		builder.append(nombre);
		builder.append(", a�o de estreno=");
		builder.append(anno);
		builder.append(", categoria=");
		builder.append(getNombreCategoria(categoria));
		builder.append(", vistas=");
		builder.append(vista);
		builder.append(", valoraci�n=");
		builder.append(valoracion);
		builder.append(", id=");
		builder.append(id);
		builder.append("]\n");
		return builder.toString();
	}

	/**
	 * Metodo generador de peliculas
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */

	public void generadorPeliculas() throws NumberFormatException, IOException {

		this.setId(LeerDatos.leerInt("ID pel�cula: "));
		this.setNombre(LeerDatos.leerString("Nombre de la pel�cula: "));
		this.setAnno(LeerDatos.leerInt("A�o: "));
		this.setCategoria(LeerDatos.leerInt(
				"Pulsa 1: Animaci�n. /nPulsa 2: Polic�aca. /nPulsa 3: Comedia./nPulsa 4: Aventuras./nPulsa 5: Rom�ntica./nPulsa 6: Thriller."));
		this.setVista(LeerDatos.leerInt("Num veces que la viste: "));
		this.setValoracion(LeerDatos.leerInt("Valoraci�n 0/10: "));
	}

	public String getNombreCategoria(int idCategoria) {
		String nameCat = null;
		switch (idCategoria) {
		case 1:
			nameCat = "Animaci�n";
			break;
		case 2:
			nameCat = "Polic�aca";
			break;
		case 3:
			nameCat = "Comedia";
			break;
		case 4:
			nameCat = "Aventuras";
			break;
		case 5:
			nameCat = "Rom�ntica";
			break;
		case 6:
			nameCat = "Thriller";
			break;
		}
		return nameCat;
	}
}
