package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CLASE LEERDATOS Contiene métodos estáticos para leer por teclado datos de
 * distinto tipo
 * 
 * @author Jhon
 * @version 14/11/2018
 *
 */
public class LeerDatos {

	/**
	 * Método para leer Strings desde teclado
	 * 
	 * @param msg
	 * @return
	 * @throws IOException
	 */
	public static String leerString(String msg) throws IOException {
		System.out.println(msg);
		// return new Scanner(System.in).nextLine();
		return new BufferedReader(new InputStreamReader(System.in)).readLine();

	};

	/**
	 * Método para leer int desde teclado
	 * 
	 * @param msg
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static int leerInt(String msg) throws NumberFormatException, IOException {
		System.out.println(msg);
		// return new Scanner(System.in).nextInt();
		return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
	};

}
