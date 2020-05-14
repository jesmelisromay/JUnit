package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import syspagos.EmpleadoJesmelis;
import syspagos.Prima;
import excepciones.*;

@RunWith(value = Parameterized.class)
public class TestEmpleado {

	
	
	@Parameters
	public static ArrayList<Object> pa() {

		
		ArrayList<Object> obj = new ArrayList<>();
		obj.add(new Object[] { "125", "125" });// valor correcto usado para probar establecerNumeroDeEmpleado y estableceMesesTrabajo
		obj.add(new Object[] { "999", "999" });// valor maximo usado para probar establecerNumeroDeEmpleado y estableceMesesTrabajo
		obj.add(new Object[] { "-28", "0" }); // Número negativo usado para probar establecerNumeroDeEmpleado y estableceMesesTrabajo
		obj.add(new Object[] { "1000", "0" }); // Número mayor a 3 dígitos usado para probar establecerNumeroDeEmpleadoy estableceMesesTrabajo
		obj.add(new Object[] { "2lm", "0" }); // No es número usado para probar establecerNumeroDeEmpleado yestableceMesesTrabajo
		obj.add(new Object[] { "000", "0" }); // Número 000 no aplica a estableceMesesTrabajo
		obj.add(new Object[] { "10", "0" }); // Número menor a 3 dígitos no aplica a estableceMesesTrabajo
		
		return obj;
	}
	

	private String actual, esperado;
	public TestEmpleado(String actual, String esperado) {

		this.actual = actual;
		this.esperado = esperado;
		

	}

	EmpleadoJesmelis je = new EmpleadoJesmelis();

	@BeforeClass
	public static void Inicio() {
		System.out.println("incio de prueba ");
	}

	@AfterClass
	public static void fin() {
		System.out.println("fin de prueba");
		
	}

	@Before
	public void InicializarEmpleado() {
		je = new EmpleadoJesmelis();	
	}
	

	@After
	public void BorrarEmpleado() {
		je = null;
	}

	@Test
	public void establecerNumeroDeEmpleadoCorrecto() {

		try {
			je.establecerNumeroEmpleado(actual);
			
		} catch (NumeroEmpleadoException ex) {
			System.out.println(ex + " " + actual);
		}
		assertEquals(esperado, je.getNumeroEmpleado() + "");
	}
	
		

	@Test
	public void establecerNombreDeEmpleadoCorrecto() {
		String ab = "maria";// nombre correcto
		String b = "maria marcano hernandez";// cadena de mas de 10 caracteres
		String c = "maria*/-"; // Cadena que incluya caracteres no alfanuméricos

		try {
			
			je.estableceNombreEmpleado(b);
			assertEquals(null, je.getNombreEmpleado());
			je.estableceNombreEmpleado(c);
			assertEquals(null, je.getNombreEmpleado());
			je.estableceNombreEmpleado(ab);
			assertEquals(ab, je.getNombreEmpleado());
			
		} catch (NombreEmpleadoException e) {
			System.out.println(e);
			
		}

	}

	@Test
	public void estableceMesesTrabajoCorrecto() {

		try {

			if (actual == 000 + "") // incluido el 000
				esperado = 000 + "";
			if (actual.length() < 3) // acepta valores menores de tres digitos, segun el codigo
				esperado = actual;

			je.estableceMesesTrabajo(actual);
		} catch (MesesTrabajoException e) {
			System.out.println(e + " "+ actual);
		}

		assertEquals(esperado, je.getMesesTrabajo() + "");
	}

	@Test
	public void establecerSerDirectivoCorrecto() {

		String c1 = "/"; // Cualquier carácter distinto del símbolo + o –
		String c2 = ""; // Cadena nula.
		String c3 = "+"; // caracter valido a true
		String c4 = "-"; // caracter valido a false
		try {

			je.establecerSerDirectivo(c1);
			assertEquals(false, je.getDirectivo());
			je.establecerSerDirectivo(c2);
			assertEquals(false, je.getDirectivo());
			je.establecerSerDirectivo(c3);
			assertEquals(true, je.getDirectivo());
			je.establecerSerDirectivo(c4);
			assertEquals(false, je.getDirectivo());

		} catch (CargoException e) {
			System.out.println(e); 
		}
	}

	@Test
	public void calcularPrimaCorrecto() {

		/*
		 * El método calcularPrima una vez que los métodos establecer_* han sido
		 * correctamente probados no requiere hacer pruebas tan exhaustivas. Es decir
		 * solo necesitamos realizar las pruebas de la propia lógica de calcular prima
		 */

		try {
			je.calcularPrima("102", "maria", "13", "+");
			assertEquals(Prima.P1, je.getPrima());
			je.calcularPrima("102", "maria", "18", "-");
			assertEquals(Prima.P2, je.getPrima());
			je.calcularPrima("102", "maria", "1", "+");
			assertEquals(Prima.P3, je.getPrima());
			je.calcularPrima("102", "maria", "3", "-");
			assertEquals(Prima.P4, je.getPrima());

		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			System.out.println(e);
		}
	}

}
