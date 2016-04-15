package entities;

import java.util.ArrayList;
import java.util.List;

public class Baza {
	private int estado; //1 En curso, 2 Finalizada
	private List<Mano> manos;
	private List<DetallePunto> puntos;
	private List<Canto> cantosRealizados;
	private List<ManoJugador> manosJugadores;
	private int jugMano;
	
	public Baza (int mano){
		this.manos = new ArrayList<Mano>();
		this.puntos = new ArrayList<DetallePunto>();
		this.cantosRealizados = new ArrayList<Canto>();
		this.estado = 1;
		this.jugMano = mano;
	}
	
	public void repartirCartas(Mazo m, List<Jugador> jugadores){
		
		m.mezclarMazo(); //Mezclo el mazo.
		List<Carta> cartasMezcladas = m.getCartas(); //obtengo las cartas mezcladas
		for(int i = 0; i < jugadores.size(); i++){ 
			List<Carta> cartasJug = repartir(cartasMezcladas,i);
			ManoJugador mano = new ManoJugador(jugadores.get(i), cartasJug, i+1); // el i+1 indica la posición del jugador en la mesa.
			manosJugadores.add(mano);
		}	
		crearManos();
	}
	
	public int verTurno(){ //Probar esta función!!
		int cartasJugadas = 0;
		for(Mano m: manos){
			if (m.getEstado()==1){ //Busco la primera mano que esté en estado en curso. Si está en estado terminado, ya no tiene sentido. 
				cartasJugadas = m.calcularCartasJugadas();//busco quién debe jugar.
				if(cartasJugadas == 0 || cartasJugadas == 4) //Le toca a quien es mano.
					return this.jugMano;
				else
					if(cartasJugadas + this.jugMano >4) //Si excede 4, le resto 4 para dar la vuelta
						return cartasJugadas+ this.jugMano - 4; 
					else
						return cartasJugadas + this.jugMano; //sino devuelvo a quién le toca
			}
		}
		return -1; //Significa que la baza  ya terminó. No le toca a nadie. No debería pasar.
	}
	

	private void crearManos() {
		Mano manoA = new Mano();
		Mano manoB = new Mano();
		Mano manoC = new Mano();
		manos.add(manoA);
		manos.add(manoB);
		manos.add(manoC);
		
	}

	private List<Carta> repartir(List<Carta> cartasMezcladas, int i) {
		List<Carta> cartas = new ArrayList<Carta>();
		cartas.add(cartasMezcladas.get(i));
		cartas.add(cartasMezcladas.get(i+4));
		cartas.add(cartasMezcladas.get(i+8));
		return cartas;
	}

	public List<Carta> verCartas(Jugador jug) {
		for(ManoJugador mj :manosJugadores)
			if(mj.getJugador() == jug)
				return mj.getCartas();
		return null;
	}
	

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Mano> getManos() {
		return manos;
	}

	public void setManos(List<Mano> manos) {
		this.manos = manos;
	}

	public List<DetallePunto> getPuntos() {
		return puntos;
	}

	public void setPuntos(List<DetallePunto> puntos) {
		this.puntos = puntos;
	}

	public List<Canto> getCantosRealizados() {
		return cantosRealizados;
	}

	public void setCantosRealizados(List<Canto> cantosRealizados) {
		this.cantosRealizados = cantosRealizados;
	}

	public int getJugMano() {
		return jugMano;
	}

	public void setJugMano(int jugMano) {
		this.jugMano = jugMano;
	}

	

	
	
	
}
