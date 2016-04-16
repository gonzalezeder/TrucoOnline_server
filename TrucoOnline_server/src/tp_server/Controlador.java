package tp_server;

import java.util.ArrayList;
import java.util.List;

import entities.Categoria;
import entities.Juego;
import entities.Jugador;
import entities.Lobby;

public class Controlador {
	private List<Jugador> jugadores;
	private List<Juego> juegos;
	private Lobby lobby;
	
	private static Controlador instancia;
	
	
	private Controlador (){
		this.jugadores = new ArrayList<Jugador>();
		this.lobby = new Lobby();
		
		
		
		
	}
	// Este metodo despues se vaa cuando agregamos la persistencia :)
	public static Controlador getInstancia(){
		if(instancia==null)
			instancia = new Controlador();
		return instancia;
	}
	
	
	
	public void altaJugador(String apodo, String mail, String password){ 
		Jugador j = buscarJugador(mail);
		if (j==null){
			j = new Jugador(apodo,mail,password);
			jugadores.add(j);
			System.out.println("Se creó un jugador");
		}else
			System.out.println("Ya existe un jugador registrado con ese mail");
	}

	private Jugador buscarJugador(String mail){
		for(Jugador j: jugadores)
			if(j.getMail() == mail)
				return j;
		return null;
	}
	public void imprimirCategorias() {
		System.out.println("---------------------------Categorías---------------------------");
		for(Categoria c: Categoria.values())
			System.out.println(c.getName()+ "            Cantidad mínima de partidas: "+ c.getCantPartidas()+"        Puntaje mínimo: "+c.getPuntaje()+ "        Promedio mínimo: "+c.getPromedio());
	}
	public void imprimirJugadores() {
		System.out.println("---------------------------Jugadores---------------------------");
		for(Jugador j: jugadores)
			System.out.println("idJugador: "+j.getIdJugador()+"       Apodo: "+ j.getApodo()+"        Mail: "+j.getMail()+ "        Password: "+j.getPassword());
		}
	public boolean validarLogin(String mail, String contraseña) {
		Jugador j = buscarJugador(mail);
		if (j!=null)
			if(j.getPassword()==contraseña){
				System.out.println("Acceso correcto");
				return true;
			}else
				System.out.println("Contraseña incorrecta");
		else
			System.out.println("El mail ingresado no corresponde a un usuario válido");
		return false;
		
	}
	
	public void entrarLobby(int idJugador){
		Jugador j = buscarJugadorPorId(idJugador);
		if(j!=null)
			Lobby.getInstancia().acceder(j);
		
	}
	
	public void salirLobby(int idJugador){
		Jugador j = buscarJugadorPorId(idJugador);
		if(j!=null)
			Lobby.getInstancia().salir(j);
	}
	
	private Jugador buscarJugadorPorId(int idJugador) {
		for(Jugador j: jugadores)
			if(j.getIdJugador()==idJugador)
				return j;
		return null;
	}
	
	public List<Jugador> verJugadoresOnline(){
		List<Jugador> jugs = Lobby.getInstancia().verJugadoresOnline();
		System.out.println("---------------------------Jugadores Online---------------------------");
		for(Jugador j: jugs)
			System.out.println("idJugador: "+j.getIdJugador()+"       Apodo: "+ j.getApodo()+"        Mail: "+j.getMail()+ "        Password: "+j.getPassword());
		return jugs;
	}
	
	public void jugarTrucoIndividual(int idJugador){
		Jugador j = buscarJugadorPorId(idJugador);
		if(j!=null)
			Lobby.getInstancia().jugarIndividual(j);
		
	}
	
	
		
	
	
	
	
	
	
}
