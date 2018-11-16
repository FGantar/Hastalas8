package utilidades;

import java.util.Scanner;

public class LeerDatos {

	public static String leerString(String msg) {
		System.out.println(msg);
		return new Scanner(System.in).nextLine();
	};

	public static int leerInt(String msg) {
		System.out.println(msg);
		return new Scanner(System.in).nextInt();
	};

	public static double leerDouble(String msg) {
		System.out.println(msg);
		return new Scanner(System.in).nextDouble();
	};

}
