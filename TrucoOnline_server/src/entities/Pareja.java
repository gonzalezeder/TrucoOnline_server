package entities;

public class Pareja {
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Pareja (Jugador j1, Jugador j2){
		this.jugador1 = j1;
		this.jugador2 = j2;
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public boolean pertenece(Jugador jug) {
		if(jugador1 == jug || jugador2 == jug)
			return true;
		return false;
	}
		
}
