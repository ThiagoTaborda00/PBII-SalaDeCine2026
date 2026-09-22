package ar.edu.unlam.pb2;

public class SalaDeCineSorround extends SalaDeCine {
	
	private final int cantidadDeParlantes = 30;
	private final int potenciaTotal = 1200;
	

	public SalaDeCineSorround(int filas, int columnas) {
		super(filas, columnas);
		this.tipoDePantalla = Pantalla.DOSD;
		this.cambiarVolumen(90);
	}
	
	public int getCantidadDeParlantes() {
		return this.cantidadDeParlantes;
	}
	
	public int getPotenciaTotal() {
		return this.potenciaTotal;
	}
	
	
	
	
}
