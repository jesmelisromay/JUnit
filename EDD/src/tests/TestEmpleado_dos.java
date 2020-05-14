package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import excepciones.CargoException;
import excepciones.MesesTrabajoException;
import excepciones.NombreEmpleadoException;
import excepciones.NumeroEmpleadoException;
import syspagos.EmpleadoJesmelis;
import syspagos.Prima;

public class TestEmpleado_dos {

	EmpleadoJesmelis empleado = new EmpleadoJesmelis();
	

	@Before
	public void InicializarEmpleado() {
		empleado = new EmpleadoJesmelis();	
	}
	

	@After
	public void BorrarEmpleado() {
		empleado = null;
	}

	
	@Test
	public void NumeroDeEpleadoCorrecto() {
		
		try {
			empleado.establecerNumeroEmpleado("425");
		} catch (NumeroEmpleadoException e) {
			fail();
		}
		
		assertEquals(425, empleado.getNumeroEmpleado());
		
	}
	
	@Test
	public void NombreDeEmpleadoCorrecto() {
		try {
			empleado.estableceNombreEmpleado("maria");
		} catch (NombreEmpleadoException e) {
			fail();
		}
		assertEquals("maria", empleado.getNombreEmpleado());
	}
	
	
	@Test
	public void MesesDeTrabajoCorrecto() {
		try {
			empleado.estableceMesesTrabajo("20");
		} catch (MesesTrabajoException e) {
			fail();
		}
		assertEquals(20, empleado.getMesesTrabajo());
	}
	
	
	@Test
	public void SerDirectivoCorrectoPositivo() {
		try {
			empleado.establecerSerDirectivo("+");
		} catch (CargoException e) {
			fail();
		}
		
		assertTrue(empleado.getDirectivo());
	}
	
	
	@Test
	public void SerDirectivoCorrectoNegativo() {
		try {
			empleado.establecerSerDirectivo("-");
		} catch (CargoException e) {
			fail();
		}
		
		assertFalse(empleado.getDirectivo());
	}
	
	@Test
	public void CalcularPrimaP1() {
		try {
			empleado.calcularPrima("125", "jose", "13", "+");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
		}
		
		assertEquals(Prima.P1, empleado.getPrima());
	}
	
	@Test
	public void CalcularPrimaP2() {
		try {
			empleado.calcularPrima("125", "jose", "15", "-");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
		}
		
		assertEquals(Prima.P2, empleado.getPrima());
	}
	
	@Test
	public void CalcularPrimaP3() {
		try {
			empleado.calcularPrima("125", "jose", "6", "+");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
		}
		
		assertEquals(Prima.P3, empleado.getPrima());
	}
	
	@Test
	public void CalcularPrimaP4() {
		try {
			empleado.calcularPrima("125", "jose", "2", "-");
		} catch (NumeroEmpleadoException | NombreEmpleadoException | MesesTrabajoException | CargoException e) {
			fail();
		}
		
		assertEquals(Prima.P4, empleado.getPrima());
	}
	
	
	
	

}
