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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Partidas")
public class Partida {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPartida;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "idPartida")
	private List<Baza> bazas;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="idEstado", referencedColumnName= "idEstado")
	private Estado estado; //1 En curso, 2 Finalizada
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parejaGanadora")
	private Pareja parejaGanadora;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdJuego", insertable=false, updatable=false)
	private Juego juego;
	
	@Transient
	private int jugMano;
	
	
	public Partida(){
		this.bazas = new ArrayList<Baza>();
		this.parejaGanadora = null;
	//	this.estado = 1;
		this.jugMano = -1; //Inicializo en -1. Siempre va a indicar qu� jugador es mano en la baza
		
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

	public void repartirCartas(Mazo m, List<Jugador> jugadores) {
		
			// Elecci�n de qui�n es mano //
		
			int i = bazas.size(); //Obtengo la cantidad de bazas jugadas
			if (i !=0) // Si no est� vac�o, busco qui�n fue mano en la ultima baza
				this.jugMano = bazas.get(i).getJugMano();
			
			if(this.jugMano == -1){ //Es la primera baza. Se debe elegir quien es mano.
				Random r = new Random();
				this.jugMano = r.nextInt(4) + 1; // Elige un n�mero del 1 al 4. El valor se 
			}else	//corresponde con la posici�n en la mesa de cada jugador, indicando quien es mano
				if(this.jugMano == 4) //Si el jugador con posici�n 4 fue mano por �ltima vez, le corresponde al jugador con posicion 1
					this.jugMano = 1;
				else //Sino, sumo 1 posici�n.
					this.jugMano++;
			
			// Creo la baza, indicando qui�n ser� mano (jugMano coincidir� con la posici�n)
			// Los jugadores siempre se entregan con las posiciones 1: J1 de P1; 2: J1 de P2; 3: J2 de P1; 4: J2 de P2
			Baza b = new Baza(this.jugMano);	
			b.repartirCartas(m, jugadores);
			bazas.add(b);
	
		
	}

	public Baza buscarBazaEnCurso() {
		for(Baza b: bazas){
			if(b.getEstado().getIdEstado()==1)
				return b;
		}
		
		return null;
	}
	
	public int verTurno(){
		Baza b = buscarBazaEnCurso();
		if(b!=null)
			return b.verTurno();
		return -1;
	}

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
	
	
}
