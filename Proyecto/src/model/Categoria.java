package model;

import java.io.IOException;

import utilidades.LeerDatos;

/**
 * CLASE CATEGORIA: creación y modificación de la misma, ademas de permitir ver
 * su contenido a traves de una id.
 * 
 * @version 15.11.2018
 * @author John
 *
 */

public class Categoria {

	/**
	 * Propiedades de la clase categoria
	 */

	private int id;
	private String nombre;

	/**
	 * Constructores: vacio y con todos los parametros
	 */

	public Categoria() {

	}

	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Getters y setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * To String, HashCode y equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}

	/**
	 * Metodo generador de Categorias
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */

	public void generadorCategorias() throws NumberFormatException, IOException {
		this.setId(LeerDatos.leerInt("ID de la categoria: "));
		this.setNombre(LeerDatos.leerString("Nombre de la categoria: "));

	}

}
