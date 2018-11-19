package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Usuario;
import dao.DAOException;
import dao.UsuarioDAOJDBC;

/**
 * 
 * Clase Test se encarga de realizar test para comprobar el funcionamiento de la
 * aplicación
 * 
 * @author Jorge Castellano
 * @version 19/11/2018
 * 
 */

public class Test {

	private Logger logger = LogManager.getLogger(Test.class);

	/**
	 * 
	 * Metodo anadirUsuario comprueba cuantos usuarios hay y despues de realizar
	 * un insert comprueba si hay uno mas
	 * 
	 */
	@org.junit.Test
	public void anadirUsuario() {

		int cont, cont2;
		Usuario u = new Usuario();

		UsuarioDAOJDBC user = new UsuarioDAOJDBC();

		try {
			cont = user.buscar("select count(*) from Usuario");
			System.out.println(cont);
			u.creadorUsuario();

			user.annadirUsuario(u);

			cont2 = user.buscar("select count(*) from Usuario");
			System.out.println(cont2);
			assertEquals(cont, cont2 - 1);

		} catch (DAOException | NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			logger.warn("ERROR " + e.getMessage());
		}

	}

	/**
	 * 
	 * Metodo testBorrarUsuario comprueba cuantos usuarios hay y despues de
	 * realizar un delete comprueba si hay uno menos
	 * 
	 */
	@org.junit.Test
	public void testBorrarUsuario() {

		UsuarioDAOJDBC userDAO = new UsuarioDAOJDBC();

		// con = new Conex().getConex();

		try {
			int primero = userDAO.buscar("SELECT COUNT(*) FROM USUARIO");

			int cont = userDAO.buscar("SELECT ID_USUARIO FROM USUARIO ORDER BY ID_USUARIO DESC LIMIT 1");

			userDAO.borrarUsuario(cont);

			int segundo = userDAO.buscar("SELECT COUNT(*) FROM USUARIO");

			assertEquals(primero, segundo + 1);

		} catch (Exception e) {
			logger.warn("ERROR " + e.getMessage());
		}

	}

}
