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
import dao.TipoCantoDAO;
import dtos.CartaDTO;
import dtos.CategoriaDTO;
import dtos.JuegoDTO;
import dtos.JugadorDTO;
import dtos.LobbyDTO;
import dtos.ModalidadDTO;
import dtos.ParejaDTO;
import dtos.TipoCantoDTO;

@SuppressWarnings("serial")
public class Controlador extends UnicastRemoteObject implements TDAManejoDatos {
	private List<JugadorDTO> jugadores;
	private List<LobbyDTO> lobby;
	private List<CategoriaDTO> categorias;
	private List<JuegoDTO> juegos;
	private List<CartaDTO> cartas;
	private List<TipoCantoDTO> cantos;
	
	private static Controlador instancia;

	public Controlador() throws RemoteException {

		this.categorias = CategoriaDAO.getInstancia().getAll();
		this.jugadores = JugadorDAO.getInstancia().getAll();
		this.lobby = LobbyDAO.getInstancia().getAll();
		this.juegos = JuegoDAO.getInstancia().getAll();
		this.cartas =CartaDAO.getInstancia().getAll();
		this.cantos=TipoCantoDAO.getInstancia().getAll();
		
		
		
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
	
//	@Override
//	public void nuevoJugador(JugadorDTO jugador) throws RemoteException {
//		JugadorDAO.getInstancia().crearJugador(jugador);
//	}

	public void altaJugador(String apodo, String mail, String password){ 
		JugadorDTO j = buscarJugador(mail);
		if (j==null){
			j = new JugadorDTO(0,apodo,mail,password,categorias.get(0),null);
			jugadores.add(j);
			JugadorDAO.getInstancia().crearJugador(j);
			System.out.println("Se cre� un jugador");
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
				.println("---------------------------Categor�as---------------------------");
		for (CategoriaDTO c : categorias)
			System.out.println(c.getName()
					+ "            Cantidad m�nima de partidas: "
					+ c.getCantPartidas() + "        Puntaje m�nimo: "
					+ c.getPuntaje() + "        Promedio m�nimo: "
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

	public boolean validarLogin(String mail, String contrase�a) {
		JugadorDTO j = buscarJugador(mail);
		if (j != null)
			if (j.getPassword().equals(contrase�a)) {
				System.out.println("Acceso correcto");
				return true;
			} else
				System.out.println("Contrase�a incorrecta");
		else
			System.out
					.println("El mail ingresado no corresponde a un usuario v�lido");
		return false;

	}

	private JugadorDTO buscarJugadorPorId(int idJugador) {
		for (JugadorDTO j : jugadores)
			if (j.getIdJugador() == idJugador)
				return j;
		return null;
	}

	private JuegoDTO buscarJuego(int idJuego) {
		for (JuegoDTO j : juegos)
			if (j.getIdJuego() == idJuego)
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
		crearJuegos();
	}

	private boolean estaAnotado(JugadorDTO j, ModalidadDTO m) {
		for (LobbyDTO l : lobby)
			if (l.estaAnotado(j, m))
				return true;
		return false;
	}

	public void sacarJugadorModalidad(int idJugador, int mod, int est) { // 0 Disponible, 1 Jugando, 2 cancelo el juego, 3 termin�.
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

	 public void verCartasJugador(int idJuego, int idJugador){
	 List<CartaDTO> cartasJug = new ArrayList<CartaDTO>(); 
	 JuegoDTO juego = buscarJuego(idJuego);
	 if(juego!=null){
		 JugadorDTO jug = buscarJugadorPorId(idJugador);
		 if(jug!=null){
			 cartasJug = juego.verCartas(jug);
			 
		 }
	 }
	 int i = 1;
	 if(cartasJug !=null){
		 System.out.println("\nCartas del jugador "+idJugador);
		 for(CartaDTO c: cartasJug){
			 System.out.println("("+c.getIdCarta()+")Carta "+i+": "+c.getNumero()+" de "+c.getPalo());
			 i++;
		 }
	 }
	 else
		 System.out.println("Ocurri� un error");
	 }
	 
	 public void verCartasJugables(int idJuego, int idJugador){
		 List<CartaDTO> cartasJug = new ArrayList<CartaDTO>(); 
		 JuegoDTO juego = buscarJuego(idJuego);
		 if(juego!=null){
			 JugadorDTO jug = buscarJugadorPorId(idJugador);
			 if(jug!=null){
				 cartasJug = juego.verCartasJugables(jug);
			 }
		 }
		 int i = 1;
		 if(cartasJug !=null){
			 System.out.println("\nCartas del jugador "+idJugador);
			 for(CartaDTO c: cartasJug){
				 System.out.println("("+c.getIdCarta()+")Carta "+i+": "+c.getNumero()+" de "+c.getPalo());
				 i++;
			 }
		 }
		 else
			 System.out.println("Ocurri� un error");
		 }
	 
	public void crearJuegos() {
		crearJuegosIndividuales(1);
	}

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
	
	public void repartir(int idJuego){ //agregar control de si ya existe baza en juego
		JuegoDTO j = buscarJuego(idJuego);
		if(j!=null){
			List<CartaDTO> mazo = getCartasMezcladas();
			int i = juegos.indexOf(j);
			j.repartirCartas(mazo);
			JuegoDAO.getInstancia().grabarJuego(j);
			juegos.set(i,j);
		}else
			System.out.println("El juego ingresado no existe");
		
	}
	
	public void verTurno(int idJuego){
		JuegoDTO juego = buscarJuego(idJuego);
		if(juego !=null){
			JugadorDTO j = juego.verTurno();
			if(j!=null)
				System.out.println("\nEs el turno de "+j.getApodo()+"("+j.getIdJugador()+")");
		}
	}
	
	public void verCantosDisponibles(int idJuego){
		
	}
	
	public void cantar(int idJuego, int idJugador, int idCanto){
		JuegoDTO juego = buscarJuego(idJuego);
		if(juego !=null){
			JugadorDTO jug = buscarJugadorPorId(idJugador);
			if(jug!=null){
				if(juego.validarTurno(jug)){
					TipoCantoDTO canto = buscarCanto(idCanto);
					if(canto!=null){
						if(juego.Cantar(jug, canto)){
							System.out.println("\nEl jugador "+jug.getApodo()+" ha cantado "+canto.getDescCorta());
							JuegoDAO.getInstancia().grabarJuego(juego);
						}
					}
				}
			}
		}
	}
	
	private TipoCantoDTO buscarCanto(int idCanto) {
		for(TipoCantoDTO t: cantos){
			if(t.getIdTipoCanto()==idCanto)
				return t;
		}
		return null;
	}

	public void jugarCarta(int idJuego, int idJugador, int idCarta) {
		JuegoDTO juego = buscarJuego(idJuego);
		if(juego !=null){
			JugadorDTO jug = buscarJugadorPorId(idJugador);
			if(jug!=null){
				if(juego.validarTurno(jug)){ //Este m�todo valida si el jugador pertenece al juego y es su turno
					CartaDTO carta = buscarCarta(idCarta);
						if(carta!=null){
							if(juego.jugarCarta(carta, jug)){ //Este m�todo valida si la carta existe en la mano del jugador y no ha sido jugada, y la juega si es correcto
								System.out.println("\nEl jugador "+jug.getApodo()+" ha jugado la carta "+carta.getNumero()+" de "+carta.getPalo());
								JuegoDAO.getInstancia().grabarJuego(juego);
							}
						}
				}
				else
					System.out.println("\nNo es su turno.");
			}
			else
				System.out.println("\nEl jugador no existe.");

		}else
			System.out.println("El juego no existe");
		
	}
		

	

	private CartaDTO buscarCarta(int idCarta) {
		for(CartaDTO c: cartas){
			if(c.getIdCarta()==idCarta)
				return c;
		}
		return null;
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

	public List<TipoCantoDTO> getCantos() {
		return cantos;
	}

	public void setCantos(List<TipoCantoDTO> cantos) {
		this.cantos = cantos;
	}



}
