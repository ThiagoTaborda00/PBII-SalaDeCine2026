package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ButacaTest {

	@Test
	void unaButacaNuevaEmpiezaLibre() {
		Butaca butaca = new Butaca();
		assertFalse(butaca.estaOcupada());
	}

	@Test
	void ocuparDejaLaButacaOcupada() {
		Butaca butaca = new Butaca();
		butaca.ocupar();
		assertTrue(butaca.estaOcupada());
	}

	@Test
	void muestraOSiEstaLibre() {
		Butaca butaca = new Butaca();
		assertEquals("O", butaca.toString());
	}

	@Test
	void muestraXSiEstaOcupada() {
		Butaca butaca = new Butaca();
		butaca.ocupar();
		assertEquals("X", butaca.toString());
	}
}
