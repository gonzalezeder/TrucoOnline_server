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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Manos_Jugadores")
public class ManoJugador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idManoJugador;
	
	@Column(name="posicionMesa", nullable=false)
	private int posicionMesa; // 1 Sur, 2 Oeste, 3 Norte, 4 Este.
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "idManoJugador")
	private List<ManoJugadorCarta> cartas;
	
	@OneToOne()
	@JoinColumn(name= "idJugador", referencedColumnName = "idJugador",nullable=false)
	private Jugador jugador;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdBaza", insertable=false, updatable=false)
	private Baza baza;
	
	
	
	public ManoJugador(){
		
	}


	public ManoJugador(int idManoJugador, int posicionMesa,
			List<ManoJugadorCarta> cartas, Jugador jugador) {
		this.idManoJugador = idManoJugador;
		this.posicionMesa = posicionMesa;
		this.cartas = cartas;
		this.jugador = jugador;
	}


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
			if(mjc.getCarta().getIdCarta()==carta && mjc.isJugada())
				return false;
		return true;
	}






	public Carta jugarCarta(int carta) {
		for(ManoJugadorCarta mjc: cartas)
			if(mjc.getCarta().getIdCarta()== carta){
				mjc.setJugada(true);
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


	public int getIdManoJugador() {
		return idManoJugador;
	}


	public void setIdManoJugador(int idManoJugador) {
		this.idManoJugador = idManoJugador;
	}
}
	
	


