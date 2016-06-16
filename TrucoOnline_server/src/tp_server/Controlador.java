package tp_server;

import java.util.ArrayList;
import java.util.List;

import dao.CategoriaDAO;
import dao.JugadorDAO;
import dtos.CategoriaDTO;
import dtos.EstadisticaDTO;
import dtos.JugadorDTO;
import entities.Carta;
import entities.Categoria;
import entities.Juego;
import entities.Jugador;
import entities.Lobby;

public class Controlador {
	private List<JugadorDTO> jugadores;
	private List<Juego> juegos;
	private Lobby lobby;
	private List<CategoriaDTO> categorias;
	
	
	private static Controlador instancia;
	
	
	private Controlador (){
		this.jugadores = JugadorDAO.getInstancia().getAll();
		this.categorias = CategoriaDAO.getInstancia().getAll();
		this.lobby = new Lobby();
		
		
		
	}
	public static Controlador getInstancia(){
		if(instancia==null)
			instancia = new Controlador();
		return instancia;
	}
	
	
	
	public void altaJugador(String apodo, String mail, String password){ 
		JugadorDTO j = buscarJugador(mail);
		if (j==null){
			j = new JugadorDTO(0,apodo,mail,password,null,null);
			jugadores.add(j);
			JugadorDAO.getInstancia().GrabarJugador(j);
			System.out.println("Se creó un jugador");
		}else
			System.out.println("Ya existe un jugador registrado con ese mail");
	}

	private JugadorDTO buscarJugador(String mail){
		for(JugadorDTO j: jugadores)
			if(j.getMail().equals(mail))
				return j;
		return null;
	}
	public void imprimirCategorias() {
		System.out.println("---------------------------Categorías---------------------------");
		for(CategoriaDTO c: categorias)
			System.out.println(c.getName()+ "            Cantidad mínima de partidas: "+ c.getCantPartidas()+"        Puntaje mínimo: "+c.getPuntaje()+ "        Promedio mínimo: "+c.getPromedio());
	}
	public void imprimirJugadores() {
		System.out.println("---------------------------Jugadores---------------------------");
		for(JugadorDTO j: jugadores)
			System.out.println("idJugador: "+j.getIdJugador()+"       Apodo: "+ j.getApodo()+"        Mail: "+j.getMail()+ "        Password: "+j.getPassword()+"       Categoria: "+j.getCategoria().getName());
		}
	public boolean validarLogin(String mail, String contraseña) {
		JugadorDTO j = buscarJugador(mail);
		if (j!=null)
			if(j.getPassword().equals(contraseña)){
				System.out.println("Acceso correcto");
				return true;
			}else
				System.out.println("Contraseña incorrecta");
		else
			System.out.println("El mail ingresado no corresponde a un usuario válido");
		return false;
		
	}
	
	public void entrarLobby(int idJugador){
		JugadorDTO j = buscarJugadorPorId(idJugador);
	//	if(j!=null)
	//		Lobby.getInstancia().acceder(j);
		
	}
	
	public void salirLobby(int idJugador){
		JugadorDTO j = buscarJugadorPorId(idJugador);
		//if(j!=null)
		//	Lobby.getInstancia().salir(j);
	}
	
	private JugadorDTO buscarJugadorPorId(int idJugador) {
		for(JugadorDTO j: jugadores)
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
		JugadorDTO j = buscarJugadorPorId(idJugador);
	//	if(j!=null)
	//		Lobby.getInstancia().jugarIndividual(j);
		
	}
	
	public void verCartasJugador(int idJuego, int idJugador){
		List<Carta> cartas =  Lobby.getInstancia().verCartas(idJuego, idJugador);
		int i = 1;
		if(cartas !=null){
			System.out.println("\nCartas del jugador "+idJugador);
			for(Carta c: cartas){
				System.out.println("Carta "+i+": "+c.getNumero()+" de "+c.getPalo());
				i++;
			}
		}
		else
			System.out.println("Ocurrió un error al repartir");
	}
	public void crearJuegos() {
		Lobby.getInstancia().crearJuegosIndividuales();
	}
	public void jugarCarta(int idJuego, int jugador, int carta) {
		Lobby.getInstancia().jugarCarta(idJuego, jugador, carta);
		
	}
	
	
		
	
	
	
	
	
	
}
