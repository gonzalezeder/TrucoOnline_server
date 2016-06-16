package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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
@Table (name = "Manos")
public class Mano {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMano;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "idMovimiento")
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();

	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="idEstado", referencedColumnName= "idEstado")
	private Estado estado; //1 en curso, 2 terminada
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdBaza", insertable=false, updatable=false)
	private Baza baza;
	
	
	public Mano(){
		this.movimientos = new ArrayList<Movimiento>();
	
	}
	
	
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}


	public Estado getEstadoMano() {
		return estado;
	}


	public void setEstadoMano(Estado estadoMano) {
		this.estado = estadoMano;
	}


	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int calcularCartasJugadas() {
		int cartasJugadas=0;
		for(Movimiento m: movimientos){
			if(m.getCarta()!=null) //Si no es null significa que se jugó una carta
				cartasJugadas++; //Máximo van a haber 4 cartas jugadas por ronda.
				
		}
		return cartasJugadas; //Devuelvo la cantidad de cartas jugadas
	}

	public void jugar(Jugador j, Carta c) {
		Movimiento m = new Movimiento(j, null, c, -1);
		movimientos.add(m);
		
	}
	
}
