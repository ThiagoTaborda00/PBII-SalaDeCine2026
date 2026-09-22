package ar.edu.unlam.pb2;

public class Butaca {
	private boolean estaOcupada;
	
	public Butaca() {
		this.estaOcupada = false;
	}
	
	public boolean estaOcupada() {
		return this.estaOcupada;
	}
	
	public void ocupar() {
		this.estaOcupada = true;
	}
	
	@Override
	public String toString() {
		return this.estaOcupada() ? "X" : "O";
	}

}
