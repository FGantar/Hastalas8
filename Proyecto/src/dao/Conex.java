package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conex {

	private Connection con;
	private Logger logger = LogManager.getLogger(Conex.class);
	
	/**
	 * Creamos el método conectar/cerrar conexion para poder establecer comunicación Java-MySQL.
	 */

	public Connection getConex() {

		try {

			String driverClassName = "com.mysql.jdbc.Driver";
			String driverUrl = "jdbc:mysql://10.90.36.8:3306/movieflix";
			String user = "grupo4";
			String password = "1234";
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverUrl, user, password);

		} catch (Exception e) {
			logger.warn("Error" + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}

	public void cerrarConex() {
		try {
			con.close();
		} catch (SQLException e) {
			logger.warn("Error" + e.getMessage());
		}
	}
}
