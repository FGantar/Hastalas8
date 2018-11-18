package gui;

import java.io.IOException;

import dao.DAOException;
import model.Pelicula;
import model.Usuario;
import servicios.ServiciosPelicula;
import servicios.ServiciosUsuario;
import utilidades.LeerDatos;

public class Menu {
	
	public static void menu() throws DAOException, NumberFormatException, IOException{
		int i;
		do{
		
		System.out.println("0. para salir");
		System.out.println("1.gestion categorias");
		System.out.println("2.gestion de usuarios");
		System.out.println("3.gestion de peliculas");
		System.out.println("4.CARGA INICIAL PELICULAS");
		
		
		i=LeerDatos.leerInt("Introduce un numero");
		
		switch(i){
		
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
			ServiciosPelicula sp= new ServiciosPelicula();
			sp.cargaInicialPeliculas();
			break;
			
		}
		
		}while(i!=0);
		
	}
	
	public static void menuUsuario() throws DAOException, NumberFormatException, IOException{
		
		ServiciosUsuario sv= new ServiciosUsuario();
		int i =0;
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.añadir usuario");
		System.out.println("2.borrar usuario");
		System.out.println("3.modificar usuario");
		System.out.println("4.listado de usuarios");
		System.out.println("5.peliculas que puede ver un usuario");
		i=LeerDatos.leerInt("Introduce un numero");
		Usuario  u= new Usuario();
		if(i==1 || i==3)
		u.creadorUsuario();
		switch(i){
		case 0:
			menu();
			break;
		case 1:
		 sv.annadir(u);
		 
		 break;
		case 2:
		 sv.borrar(LeerDatos.leerInt("Introduce el id de usuario a borrrar"));
		
		 break;
		case 3:
		 sv.modificar(u);
		 break;
		case 4:
			System.out.println(sv.mostrarTodo());
		 break;
		case 5:
			System.out.println(sv.peliculasQuePuedeVer(LeerDatos.leerInt("Introduce el id de usuario")));
		 break;
		}
		
		}while(i!=0);
		
	}	
	
	public static void menuPelicula() throws DAOException, NumberFormatException, IOException{		
		int i = 0;
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.añadir pelicula");
		System.out.println("2.borrar pelicula");
		System.out.println("3.modificar pelicula");
		System.out.println("4.listado de pelicula");
		System.out.println("5.pelicula mas vistas");
		System.out.println("6.listado peliculas filtradas");
		System.out.println("7.peliculas mas valoradas");
		
		ServiciosPelicula sv= new ServiciosPelicula();
	    i = LeerDatos.leerInt("Introduce un numero");
		Pelicula p = new Pelicula();
		switch(i){
		case 0:
			menu();
			break;
		case 1:
			p.generadorPeliculas();
			sv.annadir(p);
			break;
		case 2:
			 int idPelicula = LeerDatos.leerInt("Introduce id de pelicula a borrar");
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
			//falta
			break;
		case 7:
			System.out.println(sv.peliculaMasValorada());
			 break;
		}
		
		}while(i!=0);
		
	}	

	//hacer cuando este categoria
public static void menuCategorias() throws DAOException, NumberFormatException, IOException{
		
		int i =0;
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.añadir pelicula");
		System.out.println("2.borrar pelicula");
		System.out.println("3.modificar pelicula");
		i=LeerDatos.leerInt("Introduce un numero");
		
		switch(i){
		
		case 0:
		 menu();
		break;	
		case 1:
			
		case 2:
			
		case 3:
		
		case 4:
			
		case 5:
		}
		
		}while(i!=0);
		
	}	

}
