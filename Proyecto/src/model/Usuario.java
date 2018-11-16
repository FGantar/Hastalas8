package model;

import utilidades.LeerDatos;

/**
 * 
 * Clase Usuario Contiene información del usuario y un método para crear nuevos
 * usuarios
 * 
 * @author Cristian G. Fortes
 * @version 1
 *
 */

// prueba2

public class Usuario {

	// ATRIBUTOS

	/**
	 * Id del Usuario
	 */
	private int idUsuario;

	/**
	 * Nombre del Usuario
	 */
	private String nombre;

	/**
	 * Fecha de Nacimiento del Usuario
	 */
	private String fechaNacimiento;

	/**
	 * Ciudad de residencia del Usuario
	 */
	private String ciudad;

	/**
	 * Abono del usuario
	 */
	private String abono;

	// CONSTRUCTORES

	/**
	 * Constructor por defecto
	 */
	public Usuario() {
		super();
	}

	/**
	 * Constructor con los 4 parámetros
	 * 
	 * @param nombre
	 * @param fechaNacimiento
	 * @param ciudad
	 * @param abono
	 */
	public Usuario(int idUsuario, String nombre, String fechaNacimiento, String ciudad, String abono) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.abono = abono;
	}

	// MÉTODOS PUBLICOS

	/**
	 * Getters y Setters
	 *
	 */

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getAbono() {
		return abono;
	}

	public void setAbono(String abono) {
		this.abono = abono;

	}

	/**
	 * Crea un usuario pidiendo los valores de los atributos por teclado
	 */
	public void creadorUsuario() {

		this.setIdUsuario(LeerDatos.leerInt("Introduce la id del usuario: "));
		this.setNombre(LeerDatos.leerString("Introduce el nombre del usuario: "));
		this.setFechaNacimiento(LeerDatos.leerString("Introduce la fecha de nacimiento del usuario: "));
		this.setCiudad(LeerDatos.leerString("Introduce el nombre de la ciudad: "));
		this.setAbono(LeerDatos.leerString("Introduce el abono del usuario (basico, extra, premium): ").toUpperCase());
	}

	public int getIdAbono() {
		int idAb = 0;
		String abono = this.getAbono();
		abono.toUpperCase();
		if (abono.equals("BASICO")) {
			idAb = 1;
		} else if (abono.equals("EXTRA")) {
			idAb = 2;
		} else if (abono.equals("PREMIUM")) {
			idAb = 3;
		} else {
			System.out.println("Abono no válido");
		}
		return idAb;

	}

}
