package entities;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.functors.FalsePredicate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import dao.CartaDAO;
import dtos.JugadorDTO;
@Entity
@Table(name ="Juegos")
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idJuego;
	
	@Column(name="fechaJuego", columnDefinition = "Date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaJuego;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "equipo1")
	private Pareja equipo1;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "equipo2")
	private Pareja equipo2;
	
	@OneToOne()
	@JoinColumn(name="idEstado", referencedColumnName= "idEstado")
	private Estado estado;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade= CascadeType.ALL)
	@OrderBy("idPartida")
	@JoinColumn(name = "idJuego")
	private List<Partida> partidas;
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTipoJuego", referencedColumnName = "idTipoJuego")
	private Modalidad modalidad;
	
	@Transient
	private static int ultNum;
	

	
	// Recordar para formatear la fecha!! SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss [.fffffffff]");
	
	public Juego (Pareja e1, Pareja e2, Modalidad mod){
		//this.idJuego=getUltNum();
		this.equipo1=e1;
		this.equipo2 =e2;
		this.estado = new Estado(1, "Creado");
		this.fechaJuego = new Date();
		partidas = new ArrayList<Partida>();
		this.modalidad = mod;
	}
	
	private int getUltNum() {
		return ultNum++;
	}

	public Juego(int idJuego, Date fechaJuego, Pareja equipo1, Pareja equipo2,
			Estado estado, List<Partida> partidas,
			Modalidad modalidad) {
		this.idJuego = idJuego;
		this.fechaJuego = fechaJuego;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.estado = estado;
		this.partidas = partidas;
		this.modalidad = modalidad;
	}

	public Juego(){
		
	}
	
	
	public Partida iniciarPartida(){
		if(partidas.size() <3 ){
			Partida p = new Partida(getJugadoresOrdenados());
			partidas.add(p);
			return p;
		}else{
			return null;
		}		
	}
	
	private Jugador getMano() { // HACER, devuelve un jugador aleatorio como mano
		return equipo1.getJugador1();
	}

	public void repartirCartas(){
		
		Partida p = buscarPartidaEnCurso();
		if(p==null){ //no hay partida en curso. Se crea una.
			p = iniciarPartida();
			if (p==null)
				System.out.println("Ya se jugaron las tres partidas.");
		}
		int i = partidas.indexOf(p);
//		p.repartirCartas(mazo, getJugadoresOrdenados());
		partidas.set(i,p);
		
	}
	
	private List<Jugador> getJugadoresOrdenados(){
		 List<Jugador> jugadores = new ArrayList<Jugador>();
		 Random rand= new Random();
		 int numero = rand.nextInt((4-1)+1)+ 1;
		 switch(numero){
		 case 1:
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador2());
			 jugadores.add(equipo2.getJugador2());
		 case 2:
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador2());
			 jugadores.add(equipo1.getJugador2());
		 case 3:
			 jugadores.add(equipo1.getJugador2());
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador2());
		 case 4:
			 jugadores.add(equipo2.getJugador2());
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador2());
		 }
		return jugadores;
	}
	
	public Partida buscarPartidaEnCurso(){
		for(Partida p: partidas){
			if(p.getEstado().getIdEstado()==1)
				return p;
		}
		return null;
	}
	
//	public Jugador verTurno(){
//		Partida p = buscarPartidaEnCurso();
//		int turno;
//		if(p!=null){
//			turno = p.verTurno();
//			switch(turno){
//				case 1:
//					return equipo1.getJugador1();
//				case 2:
//					return equipo2.getJugador1();
//				case 3:
//					return equipo1.getJugador2();
//				case 4:
//					return equipo2.getJugador2();
//				case -1: 
//					System.out.println("No hay baza en curso");
//				}
//		}
//		return null;
//	}
	
	public List<Carta> verCartas(int idJugador){
		Partida p = buscarPartidaEnCurso();
		Jugador j = buscarJug(idJugador);
		if (p!=null)
			if(j!= null)
				return p.verCartas(j);
			else
				System.out.println("El jugador no pertenece a la partida");
		return null;
	}
	
	private Jugador buscarJug(int idJugador) {
		if(equipo1.getJugador1().getIdJugador()==idJugador)
			return equipo1.getJugador1();
		if(equipo1.getJugador2().getIdJugador()==idJugador)
			return equipo1.getJugador2();
		if(equipo2.getJugador1().getIdJugador()==idJugador)
			return equipo2.getJugador1();
		if(equipo2.getJugador2().getIdJugador()==idJugador)
			return equipo2.getJugador2();
		return null;
	}

	//Getters y Setters
	
	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public Date getFechaJuego() {
		return fechaJuego;
	}

	public void setFechaJuego(Date fechaJuego) {
		this.fechaJuego = fechaJuego;
	}

	public Pareja getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Pareja equipo1) {
		this.equipo1 = equipo1;
	}

	public Pareja getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Pareja equipo2) {
		this.equipo2 = equipo2;
	}

	

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public boolean controlarJugCartaTurno(int jugador, int carta) {
		Jugador j = buscarJug(jugador);
		if(j!=null)
			if(comprobarCarta(j, carta))
				return true;
		return false;
	}

	private boolean comprobarCarta(Jugador j, int carta) {
		Partida p = buscarPartidaEnCurso();
		if(p!=null){
			Baza b = p.buscarBazaEnCurso();
			if(b !=null)
				if(b.verificarCarta(j, carta))
					return true;	
		}
		return false;
	}

	public void jugarCarta(int jugador, int carta) {
		Jugador j= buscarJug(jugador);
		if(j!=null){
			Partida p = buscarPartidaEnCurso();
			if(p!=null){
				Baza b = p.buscarBazaEnCurso();
				if(b !=null)
					b.jugarCarta(j, carta);
			}
		}
				
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
