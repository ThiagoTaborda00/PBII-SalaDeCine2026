package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalaDeCineSorroundTest {

	private SalaDeCineSorround sala;

	@BeforeEach
	void setUp() {
		sala = new SalaDeCineSorround(4, 4);
	}

	@Test
	void arrancaConVolumen90() {
		assertEquals(90, sala.getVolumen());
	}

	@Test
	void tiene30Parlantes() {
		assertEquals(30, sala.getCantidadDeParlantes());
	}

	@Test
	void tienePotenciaTotalDe1200() {
		assertEquals(1200, sala.getPotenciaTotal());
	}

	@Test
	void sePuedeModificarElVolumen() {
		assertTrue(sala.cambiarVolumen(50));
		assertEquals(50, sala.getVolumen());
	}

	@Test
	void esUnaInstanciaDeSalaDeCine() {
		assertTrue(sala instanceof SalaDeCine);
	}
}
