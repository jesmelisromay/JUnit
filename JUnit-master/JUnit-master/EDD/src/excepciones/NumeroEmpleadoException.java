package excepciones;

public class NumeroEmpleadoException extends Exception {

	/**
	 * salta cuando el N�mero  es menor o mayor a 3 d�gitos
	 */
	private static final long serialVersionUID = 1L;
	
	public NumeroEmpleadoException (String mensaje) {
		super(mensaje);
	}
}
