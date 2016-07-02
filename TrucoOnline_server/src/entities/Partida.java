package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Partidas")
public class Partida {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int idPartida;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade= CascadeType.ALL)
	@OrderBy("idBaza")
	@JoinColumn(name = "idPartida")
	private List<Baza> bazas;
	
	@OneToOne()
	@JoinColumn(name="idEstado", referencedColumnName= "idEstado")
	private Estado estado; //1 En curso, 2 Finalizada
	
	@OneToOne()
	@JoinColumn(name = "parejaGanadora")
	private Pareja parejaGanadora;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idJuego", insertable=false, updatable=false)
	private Juego juego;
	

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.MERGE)
	 @JoinTable(name = "Partida_jugadores",  joinColumns = @JoinColumn(name="idPartida"), inverseJoinColumns = @JoinColumn(name="idJugador"))
	private List<Jugador> orden;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade=CascadeType.MERGE)
	 @JoinTable(name = "Partida_orden_jugadores",  joinColumns = @JoinColumn(name="idPartida"), inverseJoinColumns = @JoinColumn(name="idJugador"))
	private List<Jugador> ordenOriginal;
	
	public Partida (){
	}
	
	public Partida(List<Jugador> j){
		this.bazas = new ArrayList<Baza>();
		this.parejaGanadora = null;
		this.estado = new Estado(1, "Creado");
		this.orden = j; 
		this.ordenOriginal = j;
		
	}

	
	public Partida(int idPartida, List<Baza> bazas, Estado estado,
			Pareja parejaGanadora, List<Jugador> j, List<Jugador> o) {
		this.idPartida = idPartida;
		this.bazas = bazas;
		this.estado = estado;
		this.parejaGanadora = parejaGanadora;
		this.orden = j;
		this.ordenOriginal = o;
	}




	public Pareja getParejaGanadora() {
		return parejaGanadora;
	}

	public void setParejaGanadora(Pareja parejaGanadora) {
		this.parejaGanadora = parejaGanadora;
	}

	public List<Baza> getBazas() {
		return bazas;
	}

//	public void repartirCartas(Mazo m, List<Jugador> jugadores) {
//		
//			// Elección de quién es mano //
//		
//			int i = bazas.size(); //Obtengo la cantidad de bazas jugadas
//			if (i !=0) // Si no está vacío, busco quién fue mano en la ultima baza
//				this.jugMano = bazas.get(i).getJugMano();
//			
//			if(this.jugMano == -1){ //Es la primera baza. Se debe elegir quien es mano.
//				Random r = new Random();
//				this.jugMano = r.nextInt(4) + 1; // Elige un número del 1 al 4. El valor se 
//			}else	//corresponde con la posición en la mesa de cada jugador, indicando quien es mano
//				if(this.jugMano == 4) //Si el jugador con posición 4 fue mano por última vez, le corresponde al jugador con posicion 1
//					this.jugMano = 1;
//				else //Sino, sumo 1 posición.
//					this.jugMano++;
//			
//			// Creo la baza, indicando quién será mano (jugMano coincidirá con la posición)
//			// Los jugadores siempre se entregan con las posiciones 1: J1 de P1; 2: J1 de P2; 3: J2 de P1; 4: J2 de P2
//			Baza b = new Baza(this.jugMano);	
//			b.repartirCartas(m, jugadores);
//			bazas.add(b);
//	
//		
//	}

	public Baza buscarBazaEnCurso() {
		for(Baza b: bazas){
			if(b.getEstado().getIdEstado()==1)
				return b;
		}
		
		return null;
	}
	
//	public int verTurno(){
//		Baza b = buscarBazaEnCurso();
//		if(b!=null)
////			return b.verTurno();
//		return -1;
//	}

	public List<Carta> verCartas(Jugador jug) {
		Baza b = buscarBazaEnCurso();
		if(b!=null)
			return b.verCartas(jug);
		return null;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public int getIdPartida() {
		return idPartida;
	}



	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}





	public List<Jugador> getJugadores() {
		return orden;
	}



	public void setJugadores(List<Jugador> jugs) {
		this.orden = jugs;
	}
	
	public void setBazas(List<Baza> bazas) {
		this.bazas = bazas;
	}

	public List<Jugador> getOrden() {
		return orden;
	}

	public void setOrden(List<Jugador> orden) {
		this.orden = orden;
	}

	public List<Jugador> getOrdenOriginal() {
		return ordenOriginal;
	}

	public void setOrdenOriginal(List<Jugador> ordenOriginal) {
		this.ordenOriginal = ordenOriginal;
	}
	
	
}
