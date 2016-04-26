package entities;


import java.util.ArrayList;
import java.util.List;

public class ManoJugador {
	private Jugador jugador;
	private List<Carta> cartas;
	private int posicionMesa; // 1 Sur, 2 Oeste, 3 Norte, 4 Este.
	private List<Carta> cartasJugadas;

	public ManoJugador(Jugador j, List<Carta> cartasJug, int posicionMesa){
		this.jugador = j;
		this.cartas = cartasJug;
		this.posicionMesa = posicionMesa;
		cartasJugadas = new ArrayList<>();
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






	public boolean existeCarta(int carta) {
		for(Carta c: cartas)
			if(c.getIdCarta()== carta)
				return true;
		return false;
	}






	public boolean cartaNoJugada(int carta) {
		for(Carta c: cartasJugadas)
			if(c.getIdCarta()==carta)
				return false;
		return true;
	}






	public Carta jugarCarta(int carta) {
		for(Carta c: cartas)
			if(c.getIdCarta()== carta){
				cartasJugadas.add(c);
				return c;
			}
		return null;
	}
	
	
	
}
