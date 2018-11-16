package dao;

/**
 * 
 * Clase UsuarioDAOJDBC
 * Contiene métodos de gestión de usuarios accediendo a la base de datos
 * 
 * @author Cristian G. Fortes
 *@version 1
 *
 */

import model.Usuario;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAOJDBC {

	private Connection con = null;

	public UsuarioDAOJDBC() {
		this.con = new Conex().getConex();
	}

	public void annadirUsuario(Usuario user) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "INSERT INTO USUARIO VALUES (" + user.getIdUsuario() + "," + "'" + user.getNombre() + "',"
					+ "'" + user.getFechaNacimiento() + "'," + "'" + user.getCiudad() + "')";
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error añadiendo usuario");
			}
		} catch (SQLException se) {
			throw new DAOException("Error añadiendo usuario en DAO", se);
		}
	}

	public void modificarUsuario(Usuario user) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE USUARIO " + "SET NOMBRE='" + user.getNombre() + "'," + "FECHA_NACIMIENTO='"
					+ user.getFechaNacimiento() + "'," + "CIUDAD='" + user.getCiudad() + "'," + "WHERE ID_USUARIO="
					+ user.getIdUsuario();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando usuario");
			}
		} catch (SQLException se) {
			throw new DAOException("Error modificando usuario en DAO", se);
		}
	}

	public void borrarUsuario(int idUsuario) throws DAOException {
		Usuario user = buscarPorID(idUsuario);
		if (user == null) {
			throw new DAOException("El Usuario con id: " + idUsuario + " no existe para borrar.");
		}
		try (Statement stmt = con.createStatement()) {
			String query = "DELETE FROM USUARIO WHERE ID_USUARIO=" + idUsuario;
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error borrando usuario");
			}
		} catch (SQLException se) {
			throw new DAOException("Error borrando usuario en DAO", se);
		}
	}

	public Usuario buscarPorID(int idUsuario) {
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM USUARIO WHERE ID_USUARIO=" + idUsuario;
			ResultSet rs = stmt.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			return (new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NOMBRE_USUARIO"),
					rs.getString("FECHA_NACIMIENTO"), rs.getString("CIUDAD")));
		} catch (SQLException se) {
			throw new DAOException("Error buscando usuario DAO", se);
		}
	}

	public ArrayList<Usuario> getListaUsuarios() throws DAOException {
		ArrayList<Usuario> user = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM USUARIO";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				user.add(new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NOMBRE"), rs.getString("FECHA_NACIMIENTO"),
						rs.getString("CIUDAD")));
			}

		} catch (SQLException se) {
			throw new DAOException("Error obteniendo los usuarios en DAO: " + se.getMessage(), se);
		}
		return user;
	}

}
