package entities;

public class Estadistica {

	private int idEstadistica;
	private int partidasJugadas;
	private int partidasGanadas;
	private int partidasPerdidas;
	private int puntaje;

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
