package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex {
	
	private Connection con;

public void GetConex(){
		
		
		try {
			String driverClassName = "com.mysql.jdbc.Driver";
			String driverUrl = "jdbc:mysql://10.90.36.8:3302/movieflix";
			String user = "grupo4";
			String password = "1234";
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverUrl, user, password);
		}catch (Exception e){
			System.out.println("ERROR" + e.getMessage());
		}		
	}

public void CerrarConex(){
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}
