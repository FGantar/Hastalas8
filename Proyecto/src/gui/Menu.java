package gui;

import model.Pelicula;
import model.Usuario;
import servicios.ServiciosUsuario;
import utilidades.LeerDatos;

public class Menu {
	
	private static ServiciosUsuario sv= new ServiciosUsuario();
	
	public static void menu(){
		
		int i =LeerDatos.leerInt("Introduce un numero");
		
		do{
		
		System.out.println("0. para salir");
		System.out.println("1.gestion categorias");
		System.out.println("2.gestion de usuarios");
		System.out.println("3.gestion de peliculas");
		
		switch(i){
		
		case 1:
			menuCategorias();
		case 2:
			menuUsuario();
		case 3:
			menuPelicula();
			
		}
		
		}while(i!=0);
		
	}
	
	public static void menuUsuario(){
		
		int i =LeerDatos.leerInt("Introduce un numero");
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.añadir usuario");
		System.out.println("2.borrar usuario");
		System.out.println("3.modificar usuario");
		System.out.println("4.listado de usuarios");
		System.out.println("5.peliculas que puede ver un usuario");
		Usuario  u= new Usuario();
		u.creadorUsuario();
		switch(i){
		
		case 1:
		 sv.annadir(u);
		 break;
		case 2:
		 sv.borrar(u);
		 break;
		case 3:
		 sv.modificar(u);
		 break;
		case 4:
		 sv.mostrarTodo();
		 break;
		case 5:
		 sv.peliculasQuePuedeVer(u);
		}
		
		}while(i!=0);
		
	}	
	
	public static void menuPelicula(){
		
		int i =LeerDatos.leerInt("Introduce un numero");
		Pelicula p= new Pelicula();
		
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.añadir pelicula");
		System.out.println("2.borrar pelicula");
		System.out.println("3.modificar pelicula");
		System.out.println("4.listado de pelicula");
		System.out.println("6.pelicula mas vistas");
		System.out.println("7.listado peliculas filtradas");
		System.out.println("8.pelicua¡las mas valoradas");
		
		switch(i){
		
		case 1:
			
		case 2:
			
		case 3:
		
		case 4:
			
		case 5:
		}
		
		}while(i!=0);
		
	}	
	
public static void menuCategorias(){
		
		int i =LeerDatos.leerInt("Introduce un numero");
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.añadir pelicula");
		System.out.println("2.borrar pelicula");
		System.out.println("3.modificar pelicula");

		
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
