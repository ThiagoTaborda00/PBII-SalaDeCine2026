package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalaDeCine4DTest {

	private SalaDeCine4D sala;

	@BeforeEach
	void setUp() {
		sala = new SalaDeCine4D(4, 4);
	}

	@Test
	void arrancaSinEfectosEspecialesActivados() {
		assertFalse(sala.tieneEfectosEspeciales());
	}

	@Test
	void sePuedenEncenderLosEfectosEspeciales() {
		sala.encenderEfectosEspeciales();
		assertTrue(sala.tieneEfectosEspeciales());
	}

	@Test
	void sePuedenApagarLosEfectosEspecialesUnaVezEncendidos() {
		sala.encenderEfectosEspeciales();
		sala.apagarEfectosEspeciales();
		assertFalse(sala.tieneEfectosEspeciales());
	}

	@Test
	void elMensajeDeBienvenidaIncluyeElTextoAdicionalDe4D() {
		String mensaje = sala.getSonidoBienvenida();
		assertEquals("Bienvenido al cine. Disfruta una experiencia multidimensional", mensaje);
	}
}
