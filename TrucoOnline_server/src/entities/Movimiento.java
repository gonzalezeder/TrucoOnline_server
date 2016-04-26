package entities;

public class Movimiento {
	private Jugador jugador;
	private Canto canto;
	private Carta carta;
	private int envido;
	
	public Movimiento (Jugador jug, Canto canto, Carta carta,int envido){
		this.setJugador(jug);
		this.setCanto(canto);
		this.setCarta(carta);
		this.setEnvido(envido);
	}

	
	
	public Canto getCanto() {
		return canto;
	}

	public void setCanto(Canto canto) {
		this.canto = canto;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}



	public int getEnvido() {
		return envido;
	}



	public void setEnvido(int envido) {
		this.envido = envido;
	}

}
