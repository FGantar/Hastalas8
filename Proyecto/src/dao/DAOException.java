package dao;

/**
 * Clase DAO excepciones, donde tenemos nuestras excepciones personalizadas 
 * @author Cristian G. Fortes
 * @version 15/11/2018
 */


public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {

		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
