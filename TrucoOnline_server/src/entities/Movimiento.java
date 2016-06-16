package entities;

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

@Entity
@Table(name = "Movimientos")
public class Movimiento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idMovimiento")
	private int idMovimiento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idJugador", referencedColumnName = "idJugador")
	private Jugador jugador;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idTipoCanto", referencedColumnName = "idTipoCanto")
	private TipoCanto canto;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "idCarta", referencedColumnName = "idCarta")
	private Carta carta;
	
	@Column(name = "envido", nullable=false, columnDefinition = "int")
	private int envido;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idMano", insertable=false, updatable=false)
	private Mano mano;
	
	public Movimiento (Jugador jug, TipoCanto canto, Carta carta,int envido){
		this.setJugador(jug);
		this.setCanto(canto);
		this.setCarta(carta);
		this.setEnvido(envido);
	}

	
	
	public TipoCanto getCanto() {
		return canto;
	}

	public void setCanto(TipoCanto canto) {
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
