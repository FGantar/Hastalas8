package gui;

import model.Pelicula;
import model.Usuario;
import servicios.ServiciosPelicula;
import servicios.ServiciosUsuario;
import utilidades.LeerDatos;

public class Menu {
	
	public static void menu(){
		int i;
		
		do{
		
		System.out.println("0. para salir");
		System.out.println("1.gestion categorias");
		System.out.println("2.gestion de usuarios");
		System.out.println("3.gestion de peliculas");
		
		
		i=LeerDatos.leerInt("Introduce un numero");
		
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
		
		ServiciosUsuario sv= new ServiciosUsuario();
		int i =0;
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.a�adir usuario");
		System.out.println("2.borrar usuario");
		System.out.println("3.modificar usuario");
		System.out.println("4.listado de usuarios");
		System.out.println("5.peliculas que puede ver un usuario");
		i=LeerDatos.leerInt("Introduce un numero");
		Usuario  u= new Usuario();
		u.creadorUsuario();
		switch(i){
		case 0:
			menu();
			break;
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
		
		ServiciosPelicula sv= new ServiciosPelicula();
		int i =LeerDatos.leerInt("Introduce un numero");
		Pelicula p= new Pelicula();
		
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.a�adir pelicula");
		System.out.println("2.borrar pelicula");
		System.out.println("3.modificar pelicula");
		System.out.println("4.listado de pelicula");
		System.out.println("5.pelicula mas vistas");
		System.out.println("6.listado peliculas filtradas");
		System.out.println("7.pelicua�las mas valoradas");
		
		switch(i){
		case 0:
			menu();
			break;
		case 1:
			sv.annadir(p);
		case 2:
			 sv.borrar(p);
		case 3:
			 sv.modificar(u);
		case 4:
			 sv.mostrarTodo();
		case 5:
			//cambiar
			 sv.mostrarTodo();
			break;
		case 6:
			//cambiar
			 sv.mostrarTodo();
			break;
		case 7:
			//cambiar
			 sv.mostrarTodo();
			 break;
		}
		
		}while(i!=0);
		
	}	

	//hacer cuando este categoria
public static void menuCategorias(){
		
		int i =0;
		
		do{
		
		System.out.println("0. para volver atras");
		System.out.println("1.a�adir pelicula");
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