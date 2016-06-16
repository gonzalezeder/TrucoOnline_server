package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Parejas")
public class Pareja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPareja;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jugador1", referencedColumnName = "idJugador")
	private Jugador jugador1;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jugador2", referencedColumnName = "idJugador")
	private Jugador jugador2;
	
	
	public Pareja (Jugador j1, Jugador j2){
		this.jugador1 = j1;
		this.jugador2 = j2;
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public boolean pertenece(Jugador jug) {
		if(jugador1 == jug || jugador2 == jug)
			return true;
		return false;
	}
		
}
