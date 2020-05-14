package excepciones;

public class NumeroEmpleadoException extends Exception {

	/**
	 * salta cuando el Número  es menor o mayor a 3 dígitos
	 */
	private static final long serialVersionUID = 1L;
	
	public NumeroEmpleadoException (String mensaje) {
		super(mensaje);
	}
}
