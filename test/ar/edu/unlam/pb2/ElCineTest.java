package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElCineTest {

	private ElCine cine;
	private SalaDeCine4D sala4D;
	private SalaDeCineSorround salaSurround;
	private Pelicula starWars;
	private Pelicula toyStory;

	@BeforeEach
	void setUp() {
		cine = new ElCine(2);
		sala4D = new SalaDeCine4D(3, 3);
		salaSurround = new SalaDeCineSorround(3, 3);
		starWars = new Pelicula("Star Wars", Genero.SUSPENSO, 180, 16);
		toyStory = new Pelicula("Toy Story 5", Genero.INFANTIL, 90, 0);
	}

	@Test
	void arrancaSinSalas() {
		assertEquals(0, cine.getCantidadSalas());
	}

	@Test
	void agregarUnaSalaLaSumaAlCine() {
		assertTrue(cine.agregarSala(sala4D));
		assertEquals(1, cine.getCantidadSalas());
	}

	@Test
	void puedeAgregarSalasComunesSurroundY4D() {
		cine.agregarSala(sala4D);
		cine.agregarSala(salaSurround);
		assertEquals(2, cine.getCantidadSalas());
	}

	@Test
	void noPermiteAgregarMasSalasQueLaCapacidadDelComplejo() {
		cine.agregarSala(sala4D);
		cine.agregarSala(salaSurround);
		SalaDeCine4D salaExcedente = new SalaDeCine4D(2, 2);
		assertFalse(cine.agregarSala(salaExcedente));
		assertEquals(2, cine.getCantidadSalas());
	}

	@Test
	void laCarteleraListaLaPeliculaDeCadaSala() {
		sala4D.proyectarPelicula(starWars);
		salaSurround.proyectarPelicula(toyStory);
		cine.agregarSala(sala4D);
		cine.agregarSala(salaSurround);

		String cartelera = cine.getCartelera();
		assertTrue(cartelera.contains("Star Wars"));
		assertTrue(cartelera.contains("Toy Story 5"));
	}

	@Test
	void laCarteleraAvisaCuandoUnaSalaNoTienePeliculaProyectada() {
		cine.agregarSala(sala4D);
		String cartelera = cine.getCartelera();
		assertTrue(cartelera.contains("Sin pelicula proyectada"));
	}

	@Test
	void venderBoletoDelegaEnLaSalaCorrectaSegunElIndice() {
		sala4D.proyectarPelicula(starWars);
		cine.agregarSala(sala4D);
		cine.agregarSala(salaSurround);

		assertTrue(cine.venderBoleto(0, 0, 0, 20));
		assertTrue(sala4D.getEstado()[0][0].estaOcupada());
	}

	@Test
	void venderBoletoRechazaUnIndiceDeSalaInexistente() {
		cine.agregarSala(sala4D);
		assertFalse(cine.venderBoleto(5, 0, 0, 20));
	}

	@Test
	void venderBoletoRespetaLasReglasDeEdadDeLaSala() {
		sala4D.proyectarPelicula(starWars);
		cine.agregarSala(sala4D);
		assertFalse(cine.venderBoleto(0, 1, 1, 10));
	}

	@Test
	void getSalaDevuelveLaSalaEnEseIndice() {
		cine.agregarSala(sala4D);
		assertEquals(sala4D, cine.getSala(0));
	}

	@Test
	void getSalaConIndiceInvalidoDevuelveNull() {
		cine.agregarSala(sala4D);
		assertNull(cine.getSala(-1));
		assertNull(cine.getSala(10));
	}
}
