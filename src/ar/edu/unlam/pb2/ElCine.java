package ar.edu.unlam.pb2;

public class ElCine {

	private SalaDeCine[] salasDeCine;
	private int cantidadSalasActual;

	public ElCine(int capacidadMaxima) {
		this.salasDeCine = new SalaDeCine[capacidadMaxima];
		this.cantidadSalasActual = 0;
	}

	public boolean agregarSala(SalaDeCine sala) {
		if (sala == null) {
			return false;
		}
		if (this.cantidadSalasActual >= this.salasDeCine.length) {
			return false;
		}
		this.salasDeCine[this.cantidadSalasActual] = sala;
		this.cantidadSalasActual++;
		return true;
	}

	public int getCantidadSalas() {
		return this.cantidadSalasActual;
	}

	public SalaDeCine getSala(int indiceSala) {
		if (indiceSala < 0 || indiceSala >= this.cantidadSalasActual) {
			return null;
		}
		return this.salasDeCine[indiceSala];
	}

	private String obtenerTipoDeSala(SalaDeCine sala) {
		if (sala instanceof SalaDeCine4D) {
			return "SalaDeCine4D";
		}
		if (sala instanceof SalaDeCineSorround) {
			return "SalaDeCineSorround";
		}
		return "SalaDeCine";
	}

	public String getCartelera() {
		String cartelera = "";
		for (int i = 0; i < this.cantidadSalasActual; i++) {
			SalaDeCine sala = this.salasDeCine[i];
			String tipoDeSala = this.obtenerTipoDeSala(sala);
			Pelicula pelicula = sala.getPelicula();
			String tituloPelicula = (pelicula != null) ? pelicula.getTitulo() : "Sin pelicula proyectada";
			cartelera = cartelera + "Sala " + i + " [" + tipoDeSala + "]: " + tituloPelicula + "\n";
		}
		return cartelera;
	}

	public boolean venderBoleto(int indiceSala, int fila, int columna, int edad) {
		SalaDeCine sala = this.getSala(indiceSala);
		if (sala == null) {
			return false;
		}
		return sala.venderBoleto(fila, columna, edad);
	}

}
