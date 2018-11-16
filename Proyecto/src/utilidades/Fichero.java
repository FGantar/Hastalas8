package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fichero {
	
private static Logger logger = LogManager.getLogger(Fichero.class);

/**
 * Crear Métodos estáticos para leer ficheros y escribir ficheros.
 * Utilizado para leer la lista de 25 peliculas del archivo "Peliculas.txt".
 */
	
	public static ArrayList<String> LeerFichero(String rutaFichero)
	{
		File fichero = new File (rutaFichero);
		ArrayList<String> ficheroString = new ArrayList<>();
		
		try 
		{
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String lineaFichero;
			
			while ((lineaFichero = br.readLine()) != null) {
				ficheroString.add(lineaFichero);
			}
			
			br.close();
		}
	     catch (IOException e) {
	    	 logger.error(e.getMessage());
	    	 
			ficheroString = null;
		} 
		
		return ficheroString;
	}
	
	public static void EscribirFichero(String rutaFichero, String lineaEscribir){
		File fichero = new File(rutaFichero);

		try {
			FileWriter fw = new FileWriter(fichero,true); 
			PrintWriter pw = new PrintWriter(fw);		
			 
			pw.println(lineaEscribir);
			pw.close();
			
			}
		catch (IOException e) {
			logger.error(e.getMessage());
		} 
	}
	

}
