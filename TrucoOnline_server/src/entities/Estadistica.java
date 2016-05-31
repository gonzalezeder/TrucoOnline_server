package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadisticas")
public class Estadistica {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idEstadistica;
	
	@Column(name = "partidasJugadas", nullable=false, columnDefinition = "int")
	private int partidasJugadas;
	
	@Column(name = "partidasGanadas", nullable=false, columnDefinition = "int")
	private int partidasGanadas;
	
	@Column(name = "partidasPerdidas", nullable=false, columnDefinition = "int")
	private int partidasPerdidas;
	
	@Column(name = "puntaje", nullable=false, columnDefinition = "int")
	private int puntaje;
	
	public Estadistica (){
		
		this.partidasJugadas = 0;
		this.partidasGanadas = 0;
		this.partidasPerdidas = 0;
		this.puntaje = 0;
	}
	
	public int getIdEstadistica() {
		return idEstadistica;
	}

	public void setIdEstadistica(int idEstadistica) {
		this.idEstadistica = idEstadistica;
	}

	public int getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}

	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
