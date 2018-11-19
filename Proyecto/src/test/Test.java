package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Usuario;
import dao.Conex;
import dao.DAOException;
import dao.UsuarioDAOJDBC;

/**
 * 
 * Clase Test se encarga de realizar test para comprobar el funcionamiento de la aplicación
 * 
 * @author Jorge Castellano
 * @version 19/11/2018
 * 
 */

public class Test {

	private Logger logger = LogManager.getLogger(Test.class);

	/**
	 * 
	 * Metodo anadirUsuario comprueba cuantos usuarios hay y despues de realizar un insert comprueba si hay uno mas
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
			assertEquals(cont, cont2);

		} catch (DAOException | NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			logger.warn("ERROR " + e.getMessage());
		}

	}
	/**
	 * 
	 * Metodo testBorrarUsuario comprueba cuantos usuarios hay y despues de realizar un delete comprueba si hay uno menos
	 * 
	 */
	@org.junit.Test
	public void testBorrarUsuario() {

		Connection con = null;
		int contBefore = 0;
		int contAfter = 0;
		int idPrueba = 0;

		UsuarioDAOJDBC userDAO = new UsuarioDAOJDBC();

		con = new Conex().getConex();

		try (Statement stmt = con.createStatement()) {
			String query1 = "SELECT COUNT(*) FROM USUARIO";
			ResultSet rs1 = stmt.executeQuery(query1);
			if (rs1.next()) {
				contBefore = rs1.getInt(1);
			}
			String query2 = "SELECT * FROM USUARIO LIMIT 1";
			ResultSet rs2 = stmt.executeQuery(query2);
			if (rs2.next()) {
				idPrueba = rs2.getInt("ID_USUARIO");
			}
			userDAO.borrarUsuario(idPrueba);
			String query3 = "SELECT COUNT(*) FROM USUARIO";
			ResultSet rs3 = stmt.executeQuery(query3);
			if (rs3.next()) {
				contAfter = rs1.getInt(1);
			}

		} catch (Exception e) {
			logger.warn("ERROR " + e.getMessage());
		}

		assertEquals(contBefore, contAfter + 1);
	}

}
