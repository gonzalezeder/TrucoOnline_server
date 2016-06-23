package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dao.JuegoDAO;
import dtos.JuegoDTO;
import dtos.JugadorDTO;

@Entity
@Table(name="Lobby")
public class Lobby {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	
	@OneToOne
	@JoinColumn(name="idJugador")
	private Jugador jugador;
	

	@OneToOne
	@JoinColumn(name="idTipoJuego")
	private Modalidad modalidad;

	@Column(name="jugando", nullable=false, columnDefinition="smallint")
	private int jugando;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getJugando() {
		return jugando;
	}


	public void setJugando(int jugando) {
		this.jugando = jugando;
	}


	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public Modalidad getModalidad() {
		return modalidad;
	}


	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	
	public Lobby(){
		
	}
	
//	
//	@Transient
//	private List<Jugador> jugadoresOnline; //Jugadores que se encuentran Online.
//	@Transient
//	private List<Jugador> libreIndividual; //Jugadores que se anotan para jugar en modo libre individual
//	@Transient
//	private List<Pareja> librePareja; //Jugadores (Parejas) que se anotan para jugar en modo libre Pareja
	
	
//	
//	public Lobby(){
////		this.juegos = JuegoDAO.getInstancia().getAll();
//		this.jugadoresOnline = new ArrayList<Jugador>();
//		this.libreIndividual = new ArrayList<Jugador>();
//		this.librePareja = new ArrayList<Pareja>();
//	}

//	public void acceder(Jugador j) {
//		if(!existeJugador(j))
//			this.jugadoresOnline.add(j);
//		else
//			System.out.println("El jugador ya está en el lobby");
//	}
	
//	public void salir(Jugador j){
//		if(existeJugador(j)){ //Si existe lo saco 
//			sacarJugadorLobby(j);
//			sacarJugadorLibreIndividual(j);
//			sacarJugadorLibrePareja(j, true);
//		}else
//			System.out.println("El jugador no está en el lobby");
//			
//	}
	
//	
//
//	private void sacarJugadorLibrePareja(Jugador j, boolean desconectar) {
//		for(int i = 0; i<librePareja.size();i++){ 
//			if(librePareja.get(i).getJugador1().getIdJugador()==j.getIdJugador()
//					||librePareja.get(i).getJugador2().getIdJugador()==j.getIdJugador()){
//				librePareja.remove(librePareja.get(i));
//				if(desconectar==false) //Manejo una variable desconectar que indica si se debe sacar al jugador de todas las parejas (porque se desconecta) o solo de una (porque entro en una partida)
//					return;
//			}
//		}
//		
//	}
//
//	private void sacarJugadorLibreIndividual(Jugador j) {
//		for(int i = 0; i<libreIndividual.size();i++){
//			if(libreIndividual.get(i).getIdJugador()==j.getIdJugador()){
//				libreIndividual.remove(libreIndividual.get(i));
//				return;
//			}
//		}
//	}
//
//	private void sacarJugadorLobby(Jugador j) {
//		for(int i = 0; i<jugadoresOnline.size();i++){
//			if(jugadoresOnline.get(i).getIdJugador()==j.getIdJugador()){
//				jugadoresOnline.remove(jugadoresOnline.get(i));
//				return;
//			}
//		}		
//	}

//	private boolean existeJugador (Jugador j){
//		for(Jugador aux: jugadoresOnline){
//			if(aux.getIdJugador()==j.getIdJugador())
//				return true; //Si lo encuentra devuelve true
//		}
//		return false; // sino False
//	}
	
//	
//	
//	public List<Jugador> verJugadoresOnline(){
//		return jugadoresOnline;
//	}

//	public void jugarIndividual(Jugador j) {
//		if(!existeJugador(j)) //Si no está anotado lo agrego.
//			this.jugadoresOnline.add(j);
//		for(Jugador aux: libreIndividual){
//			if(aux.getIdJugador()==j.getIdJugador())
//				return; //Si ya está anotado para jugar libre individual, salgo.
//		}
//		libreIndividual.add(j); //Sino lo agrego
//	}
	
//	public void crearJuegosIndividuales(){
//		if(libreIndividual.size()>=4){ // Hay que randomizarlo
//				Pareja eq1 = new Pareja(libreIndividual.get(0),libreIndividual.get(1));
//				Pareja eq2 = new Pareja(libreIndividual.get(2),libreIndividual.get(3));
//				Juego j = new Juego(eq1, eq2);
//				sacarJugadorLibreIndividual(eq1.getJugador1());
//				sacarJugadorLibreIndividual(eq1.getJugador2());
//				sacarJugadorLibreIndividual(eq2.getJugador1());
//				sacarJugadorLibreIndividual(eq2.getJugador2());
//				j.iniciarPartida();
//				j.repartirCartas();
//				juegos.add(j);
//				
//			}
//		}

	
		
		
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
//	public List<Carta> verCartas(int idJuego, int idJugador) {
//		for(Juego j: juegos){
//			if(j.getIdJuego()==idJuego)
//				return j.verCartas(idJugador);
//		}
//		return null;
//	}

//	public void jugarCarta(int idJuego, int jugador, int carta) {
//		Juego j = buscarJuego(idJuego);
//		if (j!=null){
//			if(j.controlarJugCartaTurno(jugador, carta))
//				j.jugarCarta(jugador,carta);
//			else
//				System.out.println("Hay una error en la relación carta/jugador");
//				
//		}
//			
//	}

//	private Juego buscarJuego(int idJuego) {
//		for(Juego j: juegos)
//			if (j.getIdJuego()==idJuego)
//				return j;
//		return null;
//	}
//	
	
	
	
}	

