package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "manos")
public class Mano {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMano;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "idMano")
	private List<Movimiento> movimientos;
	private int estado; //1 en curso, 2 terminada
	
	
	public Mano(){
		this.movimientos = new ArrayList<Movimiento>();
		this.setEstado(1);
		
	}
	
	public List<Canto> getCantosDisponibles(){
		return null;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
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
