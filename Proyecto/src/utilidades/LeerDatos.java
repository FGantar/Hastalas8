package utilidades;

import java.util.Scanner;

public class LeerDatos {
	
		public static String leerString(){
			return new Scanner(System.in).nextLine();
		};
		public static int leerInt(){
			return new Scanner(System.in).nextInt();
		};
		public static double leerDouble(){
			return new Scanner(System.in).nextDouble();
		};	
	

}
