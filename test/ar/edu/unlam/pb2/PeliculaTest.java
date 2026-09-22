package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliculaTest {

	private Pelicula starWars;

	@BeforeEach
	void setUp() {
		starWars = new Pelicula("Star Wars", Genero.SUSPENSO, 180, 16);
	}

	@Test
	void seInicializaConLosDatosCorrectos() {
		assertEquals("Star Wars", starWars.getTitulo());
		assertEquals(Genero.SUSPENSO, starWars.getGenero());
		assertEquals(180, starWars.getDuracion());
		assertEquals(16, starWars.getEdadMinima());
	}

	@Test
	void unMayorDeEdadPuedeVerla() {
		assertTrue(starWars.puedeVerla(20));
	}

	@Test
	void unMenorDeEdadNoPuedeVerla() {
		assertFalse(starWars.puedeVerla(10));
	}

	@Test
	void conLaEdadJustaPuedeVerla() {
		assertTrue(starWars.puedeVerla(16));
	}
}
