package ar.edu.unlam.pb2;

public abstract class SalaDeCine {

	private Butaca[][] butacas;
	private Pelicula pelicula;
	protected Pantalla tipoDePantalla;
	private int volumen;

	public static int cantidadDeSalas = 0;

	public static final String CREADOR_DE_LA_SALA = "LUCIANO";

	public SalaDeCine(int filas, int columnas) {
		this.inicializarButacas(filas, columnas);
		this.inicializarVolumen();
		SalaDeCine.cantidadDeSalas++;
	}

	private void inicializarButacas(int filas, int columnas) {
		this.butacas = new Butaca[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.butacas[i][j] = new Butaca();
			}
		}
	}

	private void inicializarVolumen() {
		this.volumen = 60;
	}

	public boolean cambiarVolumen(int volumen) {
		if (volumen < 0 || volumen > 100) {
			return false;
		}
		this.volumen = volumen;
		return true;
	}

	public int getVolumen() {
		return this.volumen;
	}

	public void proyectarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public Butaca[][] getEstado() {
		return this.butacas;
	}

	public boolean venderBoleto(int fila, int columna, int edad) {
		// si todavia no se proyecta ninguna pelicula, no se puede vender
		if (this.pelicula == null) {
			return false;
		}
		// verificar si la butaca esta disponible
		if (this.butacas[fila][columna].estaOcupada()) {
			return false;
		}
		// si el cliente tiene la edad suficiente
		if (!this.pelicula.puedeVerla(edad)) {
			return false;
		}

		this.butacas[fila][columna].ocupar();
		return true;
	}

	public String getSonidoBienvenida() {
		return "Bienvenido al cine";
	}

}
