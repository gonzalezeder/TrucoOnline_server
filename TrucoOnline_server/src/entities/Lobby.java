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
import dtos.ModalidadDTO;

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


	public Lobby(Jugador j, Modalidad m) {
		this.jugador=j;
		this.modalidad = m;
		this.jugando = 0;
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

