package gui;

import java.io.IOException;

import dao.Conex;
import dao.DAOException;
import model.Categoria;
import model.Pelicula;
import model.Usuario;
import servicios.ServiciosCategoria;
import servicios.ServiciosPelicula;
import servicios.ServiciosUsuario;
import utilidades.LeerDatos;

/**
 * Clase menu gestiona la interfaz gr�fica de la aplicacion
 * 
 * @author Jorge Castellano
 * @version 19.11.2018
 *
 */

public class Menu {

	private static Conex c;

	public static void menu() throws DAOException, NumberFormatException, IOException {
		int i = -1;

		while (i < 0 || i > 4) {

			System.out.println("*** MEN� PRINCIPAL ***");
			System.out.println("* Introduzca un n�mero para navegar: *");
			System.out.println("0.Para salir");
			System.out.println("1.Gestion categorias");
			System.out.println("2.Gestion de usuarios");
			System.out.println("3.Gestion de peliculas");
			System.out.println("4.CARGA INICIAL PELICULAS");

			i = LeerDatos.leerInt("Introduce un numero:");

		}

		switch (i) {
		case 1:
			menuCategorias();
			break;
		case 2:
			menuUsuario();
			break;
		case 3:
			menuPelicula();
			break;
		case 4:
			ServiciosPelicula sp = new ServiciosPelicula();
			sp.cargaInicialPeliculas();
			break;

		}
		if (c != null) {
			c.cerrarConex();

		}
	}

	/**
	 * 
	 * M�todo menuUsuario se encarga de gestionar las opciones usuario
	 * 
	 * 
	 * @throws DAOException
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void menuUsuario() throws DAOException, NumberFormatException, IOException {

		ServiciosUsuario sv = new ServiciosUsuario();
		int i = -1;

		while (i < 0 || i > 6) {

			System.out.println("*** MEN� DE GESTI�N DE USUARIOS ***");
			System.out.println("* Introduzca un n�mero para navegar: ");
			System.out.println("0.Para volver atras");
			System.out.println("1.A�adir usuario");
			System.out.println("2.Borrar usuario");
			System.out.println("3.Modificar usuario");
			System.out.println("4.Listado de usuarios");
			System.out.println("5.Peliculas que puede ver un usuario");
			System.out.println("6.Peliculas que no ha visto el usuario");
			i = LeerDatos.leerInt("Introduce un numero:");

		}
		Usuario u = new Usuario();
		if (i == 1 || i == 3)
			u.creadorUsuario();
		switch (i) {
		case 0:
			i = 0;
			menu();
			break;
		case 1:
			sv.annadir(u);

			break;
		case 2:
			sv.borrar(LeerDatos.leerInt("Introduce el id de usuario a borrar:"));

			break;
		case 3:
			sv.modificar(u);
			break;
		case 4:
			System.out.println(sv.mostrarTodo());
			break;
		case 5:
			System.out.println(sv.peliculasQuePuedeVer(LeerDatos.leerInt("Introduce el id de usuario:")));
			break;
		case 6:
			System.out.println(sv.peliculasNoVistas(LeerDatos.leerInt("Introduce el id de usuario:")));
			break;
		}

	}

	/**
	 * 
	 * 
	 * M�todo menuPelicula se encarga de gestionar las opciones de pelicula
	 * 
	 * @throws DAOException
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public static void menuPelicula() throws DAOException, NumberFormatException, IOException {
		int i = -1;

		while (i < 0 || i > 7) {

			System.out.println("*** MEN� DE GESTI�N DE PEL�CULAS ***");
			System.out.println("* Introduzca un n�mero para navegar: ");
			System.out.println("0.Para volver atras");
			System.out.println("1.A�adir pelicula");
			System.out.println("2.Borrar pelicula");
			System.out.println("3.Modificar pelicula");
			System.out.println("4.Listado de pelicula");
			System.out.println("5.Pelicula mas vistas");
			System.out.println("6.Listado peliculas filtradas");
			System.out.println("7.Peliculas mas valoradas");
			i = LeerDatos.leerInt("Introduce un numero:");

		}

		ServiciosPelicula sv = new ServiciosPelicula();

		Pelicula p = new Pelicula();
		switch (i) {
		case 0:
			menu();
			break;
		case 1:
			p.generadorPeliculas();
			sv.annadir(p);
			break;
		case 2:
			int idPelicula = LeerDatos.leerInt("Introduce id de pelicula a borrar:");
			sv.borrar(idPelicula);
			break;
		case 3:
			p.generadorPeliculas();
			sv.modificar(p);
			break;
		case 4:
			System.out.println(sv.mostrarTodo());
			break;
		case 5:
			System.out.println(sv.peliculaMasVista());
			break;
		case 6:
			System.out.println(sv.mostrarPeliculasFiltradas(LeerDatos.leerInt(
					"Indica la categoria:\nPulsa 1: Animaci�n. /nPulsa 2: Polic�aca. /nPulsa 3: Comedia./nPulsa 4: Aventuras./nPulsa 5: Rom�ntica./nPulsa 6: Thriller.")));
			break;
		case 7:
			System.out.println(sv.peliculaMasValorada());
			break;
		}

	}

	/**
	 * 
	 * M�todo menuCategoria se encarga de gestionar las opciones de categor�as
	 * 
	 * @throws DAOException
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public static void menuCategorias() throws DAOException, NumberFormatException, IOException {

		int i = -1;
		while (i < 0 || i > 3) {

			System.out.println("*** MEN� DE GESTI�N DE CATEGOR�AS ***");
			System.out.println("* Introduzca un n�mero para navegar: ");
			System.out.println("0.Para volver atras");
			System.out.println("1.A�adir categoria");
			System.out.println("2.Modificar una categoria existente");
			System.out.println("3.Mostrar categorias");
			i = LeerDatos.leerInt("Introduce un numero: ");
		}

		ServiciosCategoria sv = new ServiciosCategoria();

		Categoria c = new Categoria();

		switch (i) {

		case 0:
			menu();
			break;
		case 1:
			c.generadorCategorias();
			sv.annadir(c);
			break;

		case 2:
			sv.modificar(c);
			break;

		case 3:
			System.out.println(sv.mostrarTodo());
			break;
		}

	}

}
