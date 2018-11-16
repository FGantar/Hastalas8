package test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.Statement;

import model.Usuario;
import dao.Conex;

public class Test {

	@org.junit.Test
	public void anadirUsuario() {
		
		int cont, cont2;
		Usuario u = new Usuario();

		UsuarioDAOJDBC user = new UsuarioDAOJDBC();		
		
		

		cont = user.buscar("select count(*) from Usuario");
		
		u.creadorUsuario();
		
		user.annadirUsuario(u);
		
		cont2 =user.buscar("select count(*) from Usuario");
		
		assertEquals(cont, cont2);	
		
	}
	
	@org.junit.Test
	public void testBorrarUsuario() {

		Connection con = null;
		int contBefore;
		int contAfter;
		int idPrueba;
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
			throw new Exception("Error", e);
		}

		assertEquals(contBefore, contAfter + 1);
	}

}
