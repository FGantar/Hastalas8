package control;

import java.io.IOException;

import dao.DAOException;
import gui.Menu;

public class Main {

	public static void main(String[] args) {

		try {
			Menu.menu();
		} catch (DAOException | NumberFormatException | IOException e) {

			e.printStackTrace();
		}
	}

}