package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalaDeCineTest {

	private SalaDeCine sala;
	private Pelicula starWars;
	private Pelicula toyStory;

	@BeforeEach
	void setUp() {
		sala = new SalaDeCine4D(3, 3);
		starWars = new Pelicula("Star Wars", Genero.SUSPENSO, 180, 16);
		toyStory = new Pelicula("Toy Story 5", Genero.INFANTIL, 90, 0);
	}

	@Test
	void seInicializaConLaMatrizDeButacasDelTamanioIndicado() {
		Butaca[][] estado = sala.getEstado();
		assertEquals(3, estado.length);
		assertEquals(3, estado[0].length);
	}

	@Test
	void todasLasButacasEmpiezanLibres() {
		Butaca[][] estado = sala.getEstado();
		for (int i = 0; i < estado.length; i++) {
			for (int j = 0; j < estado[i].length; j++) {
				assertFalse(estado[i][j].estaOcupada());
			}
		}
	}

	@Test
	void elVolumenPorDefectoEs60() {
		assertEquals(60, sala.getVolumen());
	}

	@Test
	void cambiarVolumenAUnValorValidoLoActualiza() {
		assertTrue(sala.cambiarVolumen(45));
		assertEquals(45, sala.getVolumen());
	}

	@Test
	void noPermiteVolumenNegativo() {
		assertFalse(sala.cambiarVolumen(-1));
		assertEquals(60, sala.getVolumen());
	}

	@Test
	void noPermiteVolumenMayorA100() {
		assertFalse(sala.cambiarVolumen(101));
		assertEquals(60, sala.getVolumen());
	}

	@Test
	void proyectarPeliculaQuedaDisponibleEnGetPelicula() {
		sala.proyectarPelicula(starWars);
		assertEquals(starWars, sala.getPelicula());
	}

	@Test
	void cambiarLaPeliculaEnProyeccionActualizaGetPelicula() {
		sala.proyectarPelicula(starWars);
		sala.proyectarPelicula(toyStory);
		assertEquals(toyStory, sala.getPelicula());
	}

	@Test
	void noSePuedeVenderBoletoSiNoHayPeliculaProyectada() {
		assertFalse(sala.venderBoleto(0, 0, 20));
	}

	@Test
	void ventaExitosaDejaLaButacaOcupada() {
		sala.proyectarPelicula(starWars);
		assertTrue(sala.venderBoleto(0, 0, 20));
		assertTrue(sala.getEstado()[0][0].estaOcupada());
	}

	@Test
	void rechazaVenderUnaButacaYaOcupada() {
		sala.proyectarPelicula(starWars);
		sala.venderBoleto(0, 0, 20);
		assertFalse(sala.venderBoleto(0, 0, 20));
	}

	@Test
	void rechazaVenderAUnClienteQueNoCumpleLaEdadMinima() {
		sala.proyectarPelicula(starWars);
		assertFalse(sala.venderBoleto(1, 1, 10));
		assertFalse(sala.getEstado()[1][1].estaOcupada());
	}

	@Test
	void trasCambiarDePeliculaSePuedeVenderConLasNuevasReglasDeEdad() {
		sala.proyectarPelicula(starWars);
		assertFalse(sala.venderBoleto(2, 2, 10));
		sala.proyectarPelicula(toyStory);
		assertTrue(sala.venderBoleto(2, 2, 10));
	}

	@Test
	void elMensajeDeBienvenidaBaseEsElEsperado() {
		assertEquals("Bienvenido al cine", new SalaDeCineSorround(2, 2).getSonidoBienvenida());
	}
}
