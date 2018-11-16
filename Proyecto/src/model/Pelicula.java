package model;

import utilidades.LeerDatos;

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
	 * Constructores: vacío y con todos los parámetros
	 */
	
	public Pelicula() {
		super();
	}

	public Pelicula(String nombre, int anno, int categoria, int vista, int valoracion, int id) {
		super();
		this.nombre = nombre;
		this.anno = anno;
		this.categoria = categoria;
		this.vista=vista;
		this.valoracion=valoracion;
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
		return "Pelicula [nombre=" + nombre + ", anno=" + anno + ", categoria=" + categoria + ", vista=" + vista
				+ ", valoracion=" + valoracion + ", id=" + id + "]";
	}
	
	/**
	 * Metodo generador de peliculas
	 */
	
	public void generadorPeliculas(){
		
		this.setId(LeerDatos.leerInt("ID película: "));
		this.setNombre(LeerDatos.leerString("Nombre de la película: "));
		this.setAnno(LeerDatos.leerInt("Año: "));
		this.setCategoria(LeerDatos.leerInt("Pulsa 1;Policiaca. /nPulsa 2; Romántica. /nPulsa 3; Aventuras./nPulsa 4; Comedia./nPulsa 5; Animación./nPulsa 6; Thriller."));
	}
}
