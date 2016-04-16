package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
		if(!existeJugador(j))
			this.jugadoresOnline.add(j);
		else
			System.out.println("El jugador ya está en el lobby");
	}
	
	public void salir(Jugador j){
		if(existeJugador(j)){ //Si existe lo saco 
			sacarJugadorLobby(j);
			sacarJugadorLibreIndividual(j);
			sacarJugadorLibrePareja(j, true);
		}else
			System.out.println("El jugador no está en el lobby");
			
	}
	
	

	private void sacarJugadorLibrePareja(Jugador j, boolean desconectar) {
		for(int i = 0; i<librePareja.size();i++){ 
			if(librePareja.get(i).getJugador1().getIdJugador()==j.getIdJugador()
					||librePareja.get(i).getJugador2().getIdJugador()==j.getIdJugador()){
				librePareja.remove(librePareja.get(i));
				if(desconectar==false) //Manejo una variable desconectar que indica si se debe sacar al jugador de todas las parejas (porque se desconecta) o solo de una (porque entro en una partida)
					return;
			}
		}
		
	}

	private void sacarJugadorLibreIndividual(Jugador j) {
		for(int i = 0; i<libreIndividual.size();i++){
			if(libreIndividual.get(i).getIdJugador()==j.getIdJugador()){
				libreIndividual.remove(libreIndividual.get(i));
				return;
			}
		}
	}

	private void sacarJugadorLobby(Jugador j) {
		for(int i = 0; i<jugadoresOnline.size();i++){
			if(jugadoresOnline.get(i).getIdJugador()==j.getIdJugador()){
				jugadoresOnline.remove(jugadoresOnline.get(i));
				return;
			}
		}		
	}

	private boolean existeJugador (Jugador j){
		for(Jugador aux: jugadoresOnline){
			if(aux.getIdJugador()==j.getIdJugador())
				return true; //Si lo encuentra devuelve true
		}
		return false; // sino False
	}
	
	
	
	public List<Jugador> verJugadoresOnline(){
		return jugadoresOnline;
	}

	public void jugarIndividual(Jugador j) {
		if(!existeJugador(j)) //Si no está anotado lo agrego.
			this.jugadoresOnline.add(j);
		for(Jugador aux: libreIndividual){
			if(aux.getIdJugador()==j.getIdJugador())
				return; //Si ya está anotado para jugar libre individual, salgo.
		}
		libreIndividual.add(j); //Sino lo agrego
	}
	
	public void crearJuegosIndividuales(){
		if(libreIndividual.size()>=4){ // Hay que randomizarlo
				Pareja eq1 = new Pareja(libreIndividual.get(0),libreIndividual.get(1));
				Pareja eq2 = new Pareja(libreIndividual.get(2),libreIndividual.get(3));
				Juego j = new Juego(eq1, eq2);
				sacarJugadorLibreIndividual(eq1.getJugador1());
				sacarJugadorLibreIndividual(eq1.getJugador2());
				sacarJugadorLibreIndividual(eq2.getJugador1());
				sacarJugadorLibreIndividual(eq2.getJugador2());
				juegos.add(j);
			}
			
		}
		
		
		/* VER BIEN EL ALGORITMO PARA CREAR PARTIDAS SEGUN CATEGORIA..
		List<Jugador> novatos = new ArrayList<>();
		List<Jugador> calificados = new ArrayList<>();
		List<Jugador> expertos = new ArrayList<>();
		List<Jugador> masters = new ArrayList<>();
		for(Jugador j: libreIndividual){ //Busco qué jugadores tengo anotados para qué categoría.
			switch (j.getCategoria()){
				case NOVATO: 
					novatos.add(j);	
				case CALIFICADO:
					calificados.add(j);
				case EXPERTO:
					expertos.add(j);
				case MASTER:
					masters.add(j);
				default:
					break;
			}
		}
		if(novatos.size()==4)
			;//Armo partida de novatos, saco a los 4 jugadores
		
	}
	*/
	
	
	
}	

