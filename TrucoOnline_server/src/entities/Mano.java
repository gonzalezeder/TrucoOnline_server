package entities;

import java.util.ArrayList;
import java.util.List;

public class Mano {
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
	
}
