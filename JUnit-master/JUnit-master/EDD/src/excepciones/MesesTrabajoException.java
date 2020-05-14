package excepciones;

public class MesesTrabajoException extends Exception {

	/**
	 * salta cuando meses no es un entero positivo de 3 dígitos
	 */
	private static final long serialVersionUID = 1L;
	
	public MesesTrabajoException(String mensaje) {
		super(mensaje);
	}
	
}
