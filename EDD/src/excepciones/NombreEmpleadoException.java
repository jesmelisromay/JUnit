package excepciones;

public class NombreEmpleadoException extends Exception {

	/**
	 * salta si el nombre tiene mas de 10 caracteres 
	 * o caracteres distintos de letras 
	 */
	private static final long serialVersionUID = 1L;
	
	public NombreEmpleadoException (String mensaje) {
		super(mensaje);
	}
}
