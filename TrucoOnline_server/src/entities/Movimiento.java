package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMovimiento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idJugador", referencedColumnName = "idJugador")
	private Jugador jugador;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idCanto", referencedColumnName = "idCanto")
	private Canto canto;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idCarta", referencedColumnName = "idCarta")
	private Carta carta;
	
	@Column(name = "envido", nullable=false, columnDefinition = "int")
	private int envido;
	
	public Movimiento (Jugador jug, Canto canto, Carta carta,int envido){
		this.setJugador(jug);
		this.setCanto(canto);
		this.setCarta(carta);
		this.setEnvido(envido);
	}

	
	
	public Canto getCanto() {
		return canto;
	}

	public void setCanto(Canto canto) {
		this.canto = canto;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}



	public int getEnvido() {
		return envido;
	}



	public void setEnvido(int envido) {
		this.envido = envido;
	}

}
