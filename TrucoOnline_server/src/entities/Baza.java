//prueba

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
@Table(name = "bazas")
public class Baza { // aa
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBaza;
	private int estado; //1 En curso, 2 Finalizada
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "idBaza")
	private List<Mano> manos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "idBaza")
	private List<DetallePunto> puntos;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "idBaza")
	private List<Canto> cantosRealizados;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "idBaza")
	private List<ManoJugador> manosJugadores;
	
	private int jugMano;
	
	public Baza (int mano){
		this.manos = new ArrayList<Mano>();
		this.puntos = new ArrayList<DetallePunto>();
		this.cantosRealizados = new ArrayList<Canto>();
		this.manosJugadores = new ArrayList<ManoJugador>();
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

	public boolean verificarCarta(Jugador j, int carta) {
		for(ManoJugador mj: manosJugadores)
			if(mj.getJugador().getIdJugador()== j.getIdJugador())
				if(mj.existeCarta(carta)&&mj.cartaNoJugada(carta))
					return true;
		return false;
	}

	public void jugarCarta(Jugador j, int carta) {
		for(ManoJugador mj: manosJugadores){
			if(mj.getJugador().getIdJugador()==j.getIdJugador()){
				int i = manosJugadores.indexOf(mj);
				Carta c = mj.jugarCarta(carta);
				if(c!=null){
					manosJugadores.set(i, mj);
					Mano m = buscarManoActiva();
					if(m!=null){
						int aux = manos.indexOf(m);
						m.jugar(j,c);
						manos.set(aux, m);
						
					}
				}
				
			}
				
		}
		
	}

	private Mano buscarManoActiva() {
		for(Mano mano: manos)
			if(mano.getEstado()==1)
				return mano;
		return null;
	}

	

	
	
	
}
