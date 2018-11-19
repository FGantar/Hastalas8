package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CLASE FICHERO Contiene métodos estáticos para trabajar con ficheros
 * 
 * @author Rebeca Aceituno
 * @version 15/11/2018
 *
 */
public class Fichero {

	private static Logger logger = LogManager.getLogger(Fichero.class);

	/**
	 * Método estático para leer ficheros. Utilizado para leer la lista de 25
	 * peliculas del archivo "Peliculas.txt".
	 */

	public static ArrayList<String> LeerFichero(String rutaFichero) {
		File fichero = new File(rutaFichero);
		ArrayList<String> ficheroString = new ArrayList<>();

		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String lineaFichero;

			while ((lineaFichero = br.readLine()) != null) {
				if (lineaFichero != "")
					ficheroString.add(lineaFichero);
			}

			br.close();
		} catch (IOException e) {
			logger.error(e.getMessage());

			ficheroString = null;
		}

		return ficheroString;
	}
}
