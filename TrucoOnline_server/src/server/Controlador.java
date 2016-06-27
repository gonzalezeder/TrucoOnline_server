package server;

import interfaces.TDAManejoDatos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import dao.CartaDAO;
import dao.CategoriaDAO;
import dao.JuegoDAO;
import dao.JugadorDAO;
import dao.LobbyDAO;
import dao.ModalidadDAO;
import dtos.CartaDTO;
import dtos.CategoriaDTO;
import dtos.JuegoDTO;
import dtos.JugadorDTO;
import dtos.LobbyDTO;
import dtos.ModalidadDTO;
import dtos.ParejaDTO;

@SuppressWarnings("serial")
public class Controlador extends UnicastRemoteObject implements TDAManejoDatos {
	private List<JugadorDTO> jugadores;
	private List<LobbyDTO> lobby;
	private List<CategoriaDTO> categorias;
	private List<JuegoDTO> juegos;
	private List<CartaDTO> cartas;
	
	private static Controlador instancia;

	public Controlador() throws RemoteException {

		this.jugadores = JugadorDAO.getInstancia().getAll();
		this.lobby = LobbyDAO.getInstancia().getAll();
		this.categorias = CategoriaDAO.getInstancia().getAll();
		this.juegos = JuegoDAO.getInstancia().getAll();
		this.cartas =CartaDAO.getInstancia().getAll();
		
		
		
	}

	public static Controlador getInstancia() {
		if (instancia == null)
			try {
				instancia = new Controlador();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return instancia;
	}
	
	@Override
	public void nuevoJugador(JugadorDTO jugador) throws RemoteException {
		JugadorDAO.getInstancia().crearJugador(jugador);
	}

	public void altaJugador(String apodo, String mail, String password){ 
		JugadorDTO j = buscarJugador(mail);
		if (j==null){
			j = new JugadorDTO(0,apodo,mail,password,null,null);
			jugadores.add(j);
			JugadorDAO.getInstancia().crearJugador(j);
			System.out.println("Se creó un jugador");
		}else
			System.out.println("Ya existe un jugador registrado con ese mail");
	}

	private JugadorDTO buscarJugador(String mail) {
		for (JugadorDTO j : jugadores)
			if (j.getMail().equals(mail))
				return j;
		return null;
	}

	public void imprimirCategorias() {
		System.out
				.println("---------------------------Categorías---------------------------");
		for (CategoriaDTO c : categorias)
			System.out.println(c.getName()
					+ "            Cantidad mínima de partidas: "
					+ c.getCantPartidas() + "        Puntaje mínimo: "
					+ c.getPuntaje() + "        Promedio mínimo: "
					+ c.getPromedio());
	}

	public void imprimirJugadores() {
		System.out
				.println("---------------------------Jugadores---------------------------");
		for (JugadorDTO j : jugadores)
			System.out.println("idJugador: " + j.getIdJugador()
					+ "       Apodo: " + j.getApodo() + "        Mail: "
					+ j.getMail() + "        Password: " + j.getPassword()
					+ "       Categoria: " + j.getCategoria().getName());
	}

	public boolean validarLogin(String mail, String contraseña) {
		JugadorDTO j = buscarJugador(mail);
		if (j != null)
			if (j.getPassword().equals(contraseña)) {
				System.out.println("Acceso correcto");
				return true;
			} else
				System.out.println("Contraseña incorrecta");
		else
			System.out
					.println("El mail ingresado no corresponde a un usuario válido");
		return false;

	}

	private JugadorDTO buscarJugadorPorId(int idJugador) {
		for (JugadorDTO j : jugadores)
			if (j.getIdJugador() == idJugador)
				return j;
		return null;
	}

	// public List<Jugador> verJugadoresOnline(){
	// List<Jugador> jugs = Lobby.getInstancia().verJugadoresOnline();
	// System.out.println("---------------------------Jugadores Online---------------------------");
	// for(Jugador j: jugs)
	// System.out.println("idJugador: "+j.getIdJugador()+"       Apodo: "+
	// j.getApodo()+"        Mail: "+j.getMail()+
	// "        Password: "+j.getPassword());
	// return jugs;
	// }

	public void jugarTruco(int idJugador, int mod) {
		JugadorDTO j = buscarJugadorPorId(idJugador);
		if (j != null) {
			ModalidadDTO m = ModalidadDAO.getInstancia().getModalidad(mod);
			if (m != null) {
				if (!estaAnotado(j, m)) {
					LobbyDTO l = new LobbyDTO(j, m);
					lobby.add(l);
					LobbyDAO.getInstancia().crearLobby(l);
					System.out.println("\nEl jugador " + j.getApodo()
							+ " se ha anotado para jugar en modo "
							+ m.getNombre());
				} else
					System.out.println("\nEl jugador " + j.getApodo()
							+ " ya se encuentra anotado para jugar en modo "
							+ m.getNombre());
			} else
				System.out.println("La modalidad ingresada no existe");
		} else
			System.out.println("El jugador no existe");
	}

	private boolean estaAnotado(JugadorDTO j, ModalidadDTO m) {
		for (LobbyDTO l : lobby)
			if (l.estaAnotado(j, m))
				return true;
		return false;
	}

	public void sacarJugadorModalidad(int idJugador, int mod, int est) { // 0
																			// Disponible,
																			// 1
																			// Jugando,
																			// 2
																			// cancelo
																			// el
																			// juego,
																			// 3
																			// terminó.
		JugadorDTO j = buscarJugadorPorId(idJugador);
		if (j != null) {
			ModalidadDTO m = ModalidadDAO.getInstancia().getModalidad(mod);
			if (m != null) {
				for (LobbyDTO l : lobby)
					if (l.estaAnotado(j, m)) {
						l.setJugando(est);
						LobbyDAO.getInstancia().quitarJugador(j.getIdJugador(),
								m.getModalidad());
						System.out
								.println("\nEl jugador "
										+ j.getApodo()
										+ " ya no se encuentra anotado para jugar en modo "
										+ m.getNombre());
						return;
					}
				System.out.println("\nEl jugador " + j.getApodo()
						+ " no se encuentra anotado para jugar en modo "
						+ m.getNombre());
			} else
				System.out.println("La modalidad ingresada no existe");
		} else
			System.out.println("El jugador no existe");
	}

	// public void verCartasJugador(int idJuego, int idJugador){
	// List<Carta> cartas = Lobby.getInstancia().verCartas(idJuego, idJugador);
	// int i = 1;
	// if(cartas !=null){
	// System.out.println("\nCartas del jugador "+idJugador);
	// for(Carta c: cartas){
	// System.out.println("Carta "+i+": "+c.getNumero()+" de "+c.getPalo());
	// i++;
	// }
	// }
	// else
	// System.out.println("Ocurrió un error al repartir");
	// }
	public void crearJuegos() {
		crearJuegosIndividuales(1);
	}

	// public void jugarCarta(int idJuego, int jugador, int carta) {
	// Lobby.getInstancia().jugarCarta(idJuego, jugador, carta);
	//
	// }
	private void crearJuegosIndividuales(int mod) {
		List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>(); 
		ModalidadDTO m = ModalidadDAO.getInstancia().getModalidad(mod);
		for(LobbyDTO l: lobby){
			if(l.getModalidad().getModalidad()==1 && l.getJugando()==0){
				jugadores.add(l.getJugador());
			}
			if(jugadores.size()==4){
				ParejaDTO eq1 = new ParejaDTO(jugadores.get(0),jugadores.get(1));
				ParejaDTO eq2 = new ParejaDTO(jugadores.get(2),jugadores.get(3));
				JuegoDTO j = new JuegoDTO(eq1,eq2, m);
				j.iniciarPartida();
				JuegoDAO.getInstancia().crearJuego(j);
				List<CartaDTO> mazo = getCartasMezcladas();
				j.repartirCartas(mazo);
				JuegoDAO.getInstancia().grabarJuego(j);
				juegos.add(j);
				System.out.println("\nJuego Individual creado");
				sacarJugadorModalidad(jugadores.get(0).getIdJugador(), mod,1); 
				sacarJugadorModalidad(jugadores.get(1).getIdJugador(), mod,1);
				sacarJugadorModalidad(jugadores.get(2).getIdJugador(), mod,1);
				sacarJugadorModalidad(jugadores.get(3).getIdJugador(), mod,1);
				jugadores.clear();
			}
				
		}
//		
//		if(libreIndividual.size()>=4){ // Hay que randomizarlo
//				Pareja eq1 = new Pareja(libreIndividual.get(0),libreIndividual.get(1));
//				Pareja eq2 = new Pareja(libreIndividual.get(2),libreIndividual.get(3));
//				Juego j = new Juego(eq1, eq2);
//				sacarJugadorLibreIndividual(eq1.getJugador1());
//				sacarJugadorLibreIndividual(eq1.getJugador2());
//				sacarJugadorLibreIndividual(eq2.getJugador1());
//				sacarJugadorLibreIndividual(eq2.getJugador2());
//				j.iniciarPartida();
//				j.repartirCartas();
//				juegos.add(j);
//				
//			}
//		}
	
}
	private List<CartaDTO> getCartasMezcladas() {
		List<CartaDTO> cartasMezcladas = cartas;
		Collections.shuffle(cartasMezcladas);
		List<CartaDTO> doceCartas = new ArrayList<CartaDTO>();
		int i = 0;
		while (i< 12){
			doceCartas.add(cartasMezcladas.get(i));
			i++;
		}
		return doceCartas;
	}

	
	public List<CartaDTO> getCartas() {
		return cartas;
	}
	public void setCartas(List<CartaDTO> cartas) {
		this.cartas = cartas;
	}
	@Override
	public Set<JugadorDTO> obtengoJugadores() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadJugadores() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validteApodo(String apodo) {
		
		JugadorDTO jugador = JugadorDAO.getInstancia().finJugadorByApodo(apodo);
		if(jugador != null){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validteMail(String mail) {
		JugadorDTO jugador = JugadorDAO.getInstancia().finJugadorByMail(mail);
		if(jugador != null){
			return true;
		}
		
		return false;
	}

	@Override
	public JugadorDTO obtengoJugador(int nroJugador) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void envioJugador(JugadorDTO jugador) throws RemoteException {
		// TODO Auto-generated method stub
		
	}



}
