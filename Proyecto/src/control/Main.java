package control;

import java.io.IOException;

import dao.DAOException;
import gui.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Menu.menu();
		} catch (DAOException | NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}