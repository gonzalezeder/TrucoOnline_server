package entities;

import java.util.ArrayList;
import java.util.List;


public class Lobby {
	private List<Juego> juegos;
	private static Lobby instancia;
	private List<Jugador> jugadoresOnline; //Jugadores que se encuentran Online.
	private List<Jugador> libreIndividual; //Jugadores que se anotan para jugar en modo libre individual
	private List<Pareja> librePareja; //Jugadores (Parejas) que se anotan para jugar en modo libre Pareja
	
	
	public static Lobby getInstancia(){
		if(instancia==null)
			instancia = new Lobby();
		return instancia;
	}
	
	public Lobby(){
		this.juegos = new ArrayList<Juego>();
		this.jugadoresOnline = new ArrayList<Jugador>();
		this.libreIndividual = new ArrayList<Jugador>();
		this.librePareja = new ArrayList<Pareja>();
	}

	public void acceder(Jugador j) {
		this.jugadoresOnline.add(j);
	}
	
	public List<Jugador> verJugadoresOnline(){
		return jugadoresOnline;
	}
	
	
	
	
	
}
