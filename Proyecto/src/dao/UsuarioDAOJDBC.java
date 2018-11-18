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

import model.Pelicula;
import model.Usuario;
import utilidades.Fichero;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDAOJDBC {

	private Connection con = null;
	private static Logger logger = LogManager.getLogger(Fichero.class);

	public UsuarioDAOJDBC() {
		this.con = new Conex().getConex();
	}

	public void annadirUsuario(Usuario user) throws DAOException {
		Usuario user2 = buscarPorID(user.getIdUsuario());
		if (user2 != null) {
			// throw new DAOException("El Usuario con id: " +
			// user2.getIdUsuario() + " ya existe.");
			System.out.println("El Usuario con id: " + user2.getIdUsuario() + " ya existe.");
		} else {
			try (Statement stmt = con.createStatement()) {
				String query = "INSERT INTO USUARIO VALUES (" + user.getIdUsuario() + "," + "'" + user.getNombre()
						+ "'," + "'" + user.getFechaNacimiento() + "','" + user.getCiudad() + "'," + user.getIdAbono()
						+ ")";
				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error añadiendo usuario");
				}
			} catch (SQLException se) {
				logger.warn("Error " + se.getMessage());
				throw new DAOException("Error añadiendo usuario en DAO", se);

			}
		}
	}

	public void modificarUsuario(Usuario user) throws DAOException {
		Usuario user2 = buscarPorID(user.getIdUsuario());
		if (user2 == null) {
			// throw new DAOException("El Usuario con id: " +
			// user2.getIdUsuario() + " no existe.");
			System.out.println("El Usuario con id: " + user2.getIdUsuario() + " no existe.");
		} else {
			try (Statement stmt = con.createStatement()) {
				String query = "UPDATE USUARIO SET NOMBRE='" + user.getNombre() + "'," + "FECHA_NACIMIENTO='"
						+ user.getFechaNacimiento() + "'," + "CIUDAD='" + user.getCiudad() + "'," + "ID_ABONO="
						+ user.getIdAbono() + " WHERE ID_USUARIO=" + user.getIdUsuario();
				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error modificando usuario");
				}
			} catch (SQLException se) {
				logger.warn("Error " + se.getMessage());
				throw new DAOException("Error modificando usuario en DAO", se);
			}
		}
	}

	public void borrarUsuario(int idUsuario) throws DAOException {
		Usuario user = buscarPorID(idUsuario);
		if (user == null) {
			// throw new DAOException("El Usuario con id: " + idUsuario + " no
			// existe para borrar.");
			System.out.println("El Usuario con id: " + idUsuario + " no existe para borrar.");
		} else {
			try (Statement stmt = con.createStatement()) {
				String query = "DELETE FROM USUARIO WHERE ID_USUARIO=" + idUsuario;
				if (stmt.executeUpdate(query) != 1) {
					throw new DAOException("Error borrando usuario");
				}
			} catch (SQLException se) {
				logger.warn("Error " + se.getMessage());
				throw new DAOException("Error borrando usuario en DAO", se);
			}
		}
	}

	public Usuario buscarPorID(int idUsuario) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT U.ID_USUARIO, U.NOMBRE, U.FECHA_NACIMIENTO, U.CIUDAD, A.NOMBRE_AB FROM USUARIO AS U, ABONO AS A WHERE U.ID_USUARIO="
					+ idUsuario + " and U.ID_ABONO=A.ID_ABONO";
			ResultSet rs = stmt.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			return (new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NOMBRE"), rs.getString("FECHA_NACIMIENTO"),
					rs.getString("CIUDAD"), rs.getString("NOMBRE_AB")));
		} catch (SQLException se) {
			logger.warn("Error " + se.getMessage());
			throw new DAOException("Error buscando usuario en DAO", se);
		}
	}

	public ArrayList<Usuario> getListaUsuarios() throws DAOException {
		ArrayList<Usuario> user = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT U.ID_USUARIO, U.NOMBRE, U.FECHA_NACIMIENTO, U.CIUDAD, A.NOMBRE_AB FROM USUARIO AS U, ABONO AS A WHERE U.ID_ABONO=A.ID_ABONO";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				user.add(new Usuario(rs.getInt("ID_USUARIO"), rs.getString("NOMBRE"), rs.getString("FECHA_NACIMIENTO"),
						rs.getString("CIUDAD"), rs.getString("NOMBRE_AB")));
			}

		} catch (SQLException se) {
			logger.warn("Error " + se.getMessage());
			throw new DAOException("Error obteniendo los usuarios en DAO: " + se.getMessage(), se);
		}
		return user;
	}

	public int buscar(String query) throws DAOException {
		int idBuscar = 0;
		try (Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				idBuscar = rs.getInt("ID_USUARIO");
			}

		} catch (SQLException se) {
			throw new DAOException("Error obteniendo los usuarios en DAO: " + se.getMessage(), se);
		}
		return idBuscar;
	}

	public ArrayList<Pelicula> peliculasQuePuedeVer(int idUsuario) throws DAOException {
		ArrayList<Pelicula> peli = new ArrayList<>();
		Pelicula p;
		Usuario user2 = buscarPorID(idUsuario);
		/*if (user2 == null) {
			// throw new DAOException("El Usuario con id: " +
			// user2.getIdUsuario() + " ya existe.");
			System.out.println("El Usuario con id: " + user2.getIdUsuario() + " no existe.");
		} else {*/
			try (Statement stmt = con.createStatement()) {
				ResultSet rs = stmt.executeQuery(
						"select p.* from pelicula p join categoria c on p.categoria_id=c.id_categoria join abono_categoria a on a.categoria_id=c.id_categoria join abono n on "
								+ idUsuario + "=a.abono_id group by p.nombre_pel");
				while (rs.next()) {
					p = new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ANNO_ESTRENO"), rs.getInt("CATEGORIA_ID"),
							rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("ID_PELICULA"));
					peli.add(p);
				}

			} catch (SQLException se) {
				logger.warn("Error " + se.getMessage());
				throw new DAOException("Error obteniendo los usuarios en DAO: " + se.getMessage(), se);
			}
		//}
		return peli;
	}

	public ArrayList<Pelicula> peliculasNoVistas(int idUsuario) throws DAOException {

		ArrayList<Pelicula> noVistas = new ArrayList<Pelicula>();

		try (Statement stmt = con.createStatement()) {
			String query = "SELECT P.* FROM PELICULA P, USUARIO U, USUARIO_PELICULA PU, CATEGORIA C, ABONO_CATEGORIA AC, ABONO A WHERE U.ID_USUARIO="
					+ idUsuario + " AND PU.ID_USUARIO= "+idUsuario+ " AND P.ID_PELICULA NOT IN (SELECT PA.ID_PELICULA FROM USUARIO_PELICULA PA) AND P.CATEGORIA_ID=C.ID_CATEGORIA AND C.ID_CATEGORIA=AC.CATEGORIA_ID AND A.ID_ABONO=AC.ABONO_ID AND A.ID_ABONO=U.ID_ABONO GROUP BY P.NOMBRE_PEL";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				noVistas.add(new Pelicula(rs.getString("NOMBRE_PEL"), rs.getInt("ANNO_ESTRENO"), rs.getInt("CATEGORIA_ID"),
						rs.getInt("VISTA"), rs.getInt("VALORACION"), rs.getInt("ID_PELICULA")));
			}
		} catch (SQLException se) {
			logger.warn("Error " + se.getMessage());
			throw new DAOException("Error obteniendo los usuarios en DAO: " + se.getMessage(), se);
		}

		return noVistas;
	}

}
