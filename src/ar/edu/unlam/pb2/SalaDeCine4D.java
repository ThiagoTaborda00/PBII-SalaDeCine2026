package ar.edu.unlam.pb2;

public class SalaDeCine4D extends SalaDeCine {
	
	private boolean efectosEspeciales;
	
	public SalaDeCine4D(int filas, int columnas) {
		super(filas, columnas);
		this.tipoDePantalla = Pantalla.CUATROD;
		this.efectosEspeciales = false;
	}
	
	@Override
	public String getSonidoBienvenida() {
		return super.getSonidoBienvenida() + ". Disfruta una experiencia multidimensional";
	}
	
	public void metodoDePrueba() {
		super.getSonidoBienvenida();
		this.getSonidoBienvenida();
	}
	
	public void encenderEfectosEspeciales() {
		this.efectosEspeciales=true;
	}
	
	public void apagarEfectosEspeciales() {
		this.efectosEspeciales=false;
	}
	
	public boolean tieneEfectosEspeciales() {
		return this.efectosEspeciales;
	}
	
	
	
	

}
