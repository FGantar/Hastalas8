package gui;

import java.io.IOException;

import dao.DAOException;
import model.Categoria;
import model.Pelicula;
import model.Usuario;
import servicios.ServiciosCategoria;
import servicios.ServiciosPelicula;
import servicios.ServiciosUsuario;
import utilidades.LeerDatos;

public class Menu {


	public static void menu() throws DAOException, NumberFormatException, IOException {
		int i;
		do {

			System.out.println("*** MENÚ PRINCIPAL ***");
			System.out.println("* Introduzca un número para navegar: *");
			System.out.println("0.Para salir");
			System.out.println("1.Gestion categorias");
			System.out.println("2.Gestion de usuarios");
			System.out.println("3.Gestion de peliculas");
			System.out.println("4.CARGA INICIAL PELICULAS");

			i = LeerDatos.leerInt("Introduce un numero:");

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

		} while (i != 0);
		System.out.println("Ciao");
	}

	public static void menuUsuario() throws DAOException, NumberFormatException, IOException {

		ServiciosUsuario sv = new ServiciosUsuario();
		int i = 0;

		do {

			System.out.println("*** MENÚ DE GESTIÓN DE USUARIOS ***");
			System.out.println("* Introduzca un número para navegar: ");
			System.out.println("0.Para volver atras");
			System.out.println("1.Añadir usuario");
			System.out.println("2.Borrar usuario");
			System.out.println("3.Modificar usuario");
			System.out.println("4.Listado de usuarios");
			System.out.println("5.Peliculas que puede ver un usuario");
			System.out.println("6.Peliculas que no ha visto el usuario");
			i = LeerDatos.leerInt("Introduce un numero:");
			Usuario u = new Usuario();
			if (i == 1 || i == 3)
				u.creadorUsuario();
			switch (i) {
			case 0:
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

		} while (i != 0);

	}

	public static void menuPelicula() throws DAOException, NumberFormatException, IOException {
		int i = 0;
		do {

			System.out.println("*** MENÚ DE GESTIÓN DE PELÍCULAS ***");
			System.out.println("* Introduzca un número para navegar: ");
			System.out.println("0.Para volver atras");
			System.out.println("1.Añadir pelicula");
			System.out.println("2.Borrar pelicula");
			System.out.println("3.Modificar pelicula");
			System.out.println("4.Listado de pelicula");
			System.out.println("5.Pelicula mas vistas");
			System.out.println("6.Listado peliculas filtradas");
			System.out.println("7.Peliculas mas valoradas");

			ServiciosPelicula sv = new ServiciosPelicula();
			i = LeerDatos.leerInt("Introduce un numero:");
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
				sv.modificar(p);
				break;
			case 4:
				System.out.println(sv.mostrarTodo());
				break;
			case 5:
				System.out.println(sv.peliculaMasVista());
				break;
			case 6:
				// falta
				break;
			case 7:
				System.out.println(sv.peliculaMasValorada());
				break;
			}

		} while (i != 0);

	}
public static void menuCategorias() throws DAOException, NumberFormatException, IOException{
		
		int i =0;
		
		do{
			
		System.out.println("*** MENÚ DE GESTIÓN DE CATEGORÍAS ***");
		System.out.println("* Introduzca un número para navegar: ");
		System.out.println("0.Para volver atras");
		System.out.println("1.Añadir categoria");
		System.out.println("2.Modificar una categoria existente");
		System.out.println("3.Mostrar categorias");

		ServiciosCategoria sv= new ServiciosCategoria();
	    i = LeerDatos.leerInt("Introduce un numero: ");
		Categoria c = new Categoria();
		
		switch(i){
		
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
		
		}while(i!=0);
		
	}	

}
