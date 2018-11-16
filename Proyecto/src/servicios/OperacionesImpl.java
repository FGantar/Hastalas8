package servicios;

import java.util.ArrayList;

public interface OperacionesImpl<T> {
	
	public void annadir(T objeto);
	
	public void modificar(T objeto);
	
	public void borrar(T objeto);
	
	public ArrayList<T> mostrarTodo();

}