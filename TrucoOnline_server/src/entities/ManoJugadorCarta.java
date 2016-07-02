package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Manos_Jugadores_Cartas")
public class ManoJugadorCarta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idManoJugadorCarta;
	
	@Column(name="jugada", columnDefinition = "smallint", nullable = false)
	private boolean jugada;
	
	@OneToOne()
	@JoinColumn(name="idCarta", referencedColumnName="idCarta",nullable=false)
	private Carta carta;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdManoJugador", insertable=false, updatable=false)
	private ManoJugador manoJugador;

	
	
	
	public ManoJugadorCarta(){
	}
	
	public ManoJugadorCarta(int idManoJugadorCarta, boolean jugada, Carta carta) {
		this.idManoJugadorCarta = idManoJugadorCarta;
		this.jugada = jugada;
		this.carta = carta;
	}

	public ManoJugadorCarta(Carta carta) {
		
		this.jugada = false;
		this.carta = carta;
		
	}

	public int getIdManoJugadorCarta() {
		return idManoJugadorCarta;
	}

	public void setIdManoJugadorCarta(int idManoJugadorCarta) {
		this.idManoJugadorCarta = idManoJugadorCarta;
	}



	
	
	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}



	public boolean isJugada() {
		return jugada;
	}

	public void setJugada(boolean jugada) {
		this.jugada = jugada;
	}
	
	
	
	
}
