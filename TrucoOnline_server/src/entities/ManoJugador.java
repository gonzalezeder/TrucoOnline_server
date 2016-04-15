package entities;


import java.util.List;

public class ManoJugador {
	private Jugador jugador;
	private List<Carta> cartas;
	private int posicionMesa; // 1 Sur, 2 Oeste, 3 Norte, 4 Este.

	public ManoJugador(Jugador j, List<Carta> cartasJug, int posicionMesa){
		this.jugador = j;
		this.cartas = cartasJug;
		this.posicionMesa = posicionMesa;
	}

	
	
	
	
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}


	public int getPosicionMesa() {
		return posicionMesa;
	}


	public void setPosicionMesa(int posicionMesa) {
		this.posicionMesa = posicionMesa;
	}
	
	
	
}
