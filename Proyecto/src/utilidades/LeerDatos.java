package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeerDatos {

	public static String leerString(String msg) throws IOException {
		System.out.println(msg);
		// return new Scanner(System.in).nextLine();
		return new BufferedReader(new InputStreamReader(System.in)).readLine();

	};

	public static int leerInt(String msg) throws NumberFormatException, IOException {
		System.out.println(msg);
		// return new Scanner(System.in).nextInt();
		return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
	};

	public static double leerDouble(String msg) {
		System.out.println(msg);
		return new Scanner(System.in).nextDouble();
	};

}
