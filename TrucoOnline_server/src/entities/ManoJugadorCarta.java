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
	private int jugada;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCarta", referencedColumnName="idCarta",nullable=false)
	private Carta carta;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idManoJugador", insertable=false, updatable=false)
	private ManoJugador manoJugador;

	
	public ManoJugadorCarta(){
	}
	
	public ManoJugadorCarta(Carta carta) {
		
		this.jugada = 0;
		this.carta = carta;
		
	}

	public int getIdManoJugadorCarta() {
		return idManoJugadorCarta;
	}

	public void setIdManoJugadorCarta(int idManoJugadorCarta) {
		this.idManoJugadorCarta = idManoJugadorCarta;
	}

	public int getJugada() {
		return jugada;
	}

	public void setJugada(int jugada) {
		this.jugada = jugada;
	}

	
	
	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public ManoJugador getManoJugador() {
		return manoJugador;
	}

	public void setManoJugador(ManoJugador manoJugador) {
		this.manoJugador = manoJugador;
	}
	
	
	
	
}
