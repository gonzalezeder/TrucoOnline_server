package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name= "Cartas")
public class Mazo {
	
	
	private int idCartaJuego;
	
	@OneToOne
	@JoinColumn(name="idJugador")
	private Jugador jugador;
	
	@OneToOne
	@JoinColumn(name="idJuego")
	private Juego juego;
	
	
	private List<Carta> cartas;
	
	public Mazo (){
	}
	
	public Mazo(List<Carta> cartas){
		this.cartas = cartas;
		mezclarMazo();
	}
	
	public void mezclarMazo(){
		Collections.shuffle(cartas);
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	

	
	
}
