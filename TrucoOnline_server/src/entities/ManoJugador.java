package entities;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Manos_Jugadores")
public class ManoJugador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idManoJugador;
	
	@Column(name="posicionMesa", nullable=false)
	private int posicionMesa; // 1 Sur, 2 Oeste, 3 Norte, 4 Este.
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "idManoJugadorCarta")
	private List<ManoJugadorCarta> cartas;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idJugador", referencedColumnName = "idJugador",nullable=false)
	private Jugador jugador;
	
	
	
	
	


	public ManoJugador(Jugador j, List<Carta> cartasJug, int posicionMesa){
		this.jugador = j;
		crearManoJugadorCartas(cartasJug);
		this.posicionMesa = posicionMesa;
		
	}

	
	private void crearManoJugadorCartas(List<Carta> cartasJugador) {
		for(Carta c: cartasJugador)
			this.cartas.add(new ManoJugadorCarta(c));
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	


	public int getPosicionMesa() {
		return posicionMesa;
	}


	public void setPosicionMesa(int posicionMesa) {
		this.posicionMesa = posicionMesa;
	}






	public boolean existeCarta(int carta) {
		for(ManoJugadorCarta mjc: cartas)
			if(mjc.getCarta().getIdCarta()== carta)
				return true;
		return false;
	}

	




	public boolean cartaNoJugada(int carta) {
		for(ManoJugadorCarta mjc: cartas)
			if(mjc.getCarta().getIdCarta()==carta && mjc.getJugada()==1)
				return false;
		return true;
	}






	public Carta jugarCarta(int carta) {
		for(ManoJugadorCarta mjc: cartas)
			if(mjc.getCarta().getIdCarta()== carta){
				mjc.setJugada(1);
				return mjc.getCarta();
			}
		return null;
	}


	public void setCartas(List<ManoJugadorCarta> cartas) {
		this.cartas = cartas;
	}


	public List<ManoJugadorCarta> getCartas() {
		return cartas;
	}






	public List<Carta> verCartas() {
		List<Carta> c = new ArrayList<Carta>();
		for(ManoJugadorCarta mjc: cartas)
			c.add(mjc.getCarta());
		return c;
	}
}
	
	


