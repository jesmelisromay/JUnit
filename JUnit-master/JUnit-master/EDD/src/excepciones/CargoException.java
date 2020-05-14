package excepciones;

public class CargoException  extends Exception {
	
	/**
	 * salata cuando directivo es un char distinto de 
	 * + o - 
	 */
	private static final long serialVersionUID = 1L;

	public CargoException (String mensaje) {
		super(mensaje);
	}
}
