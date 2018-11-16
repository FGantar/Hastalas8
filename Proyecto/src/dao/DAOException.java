package dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilidades.Fichero;

public class DAOException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(Fichero.class);
	
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
