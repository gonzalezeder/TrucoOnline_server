package tp_server;

public class Main {

	
	public static void main(String[] args) {
		Controlador.getInstancia();
			
	//	Controlador.getInstancia().imprimirCategorias();
		Controlador.getInstancia().altaJugador("Nicolas","Nicolas@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Santiago","Santiago@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Eduardo","Eduardo@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Eder","Eder@gmail.com","contraseña");
	//	Controlador.getInstancia().imprimirJugadores();
	//	Controlador.getInstancia().validarLogin("nmuttoni91@gmail.com","contraseña");
		Controlador.getInstancia().entrarLobby(1);
		Controlador.getInstancia().entrarLobby(2);
		Controlador.getInstancia().entrarLobby(3);
		Controlador.getInstancia().entrarLobby(4);
		Controlador.getInstancia().verJugadoresOnline();
	//	Controlador.getInstancia().salirLobby(2);
	//	Controlador.getInstancia().verJugadoresOnline();
		Controlador.getInstancia().jugarTrucoIndividual(1);
		Controlador.getInstancia().jugarTrucoIndividual(2);
		Controlador.getInstancia().jugarTrucoIndividual(3);
		Controlador.getInstancia().jugarTrucoIndividual(4);
		Controlador.getInstancia().crearJuegos();
		Controlador.getInstancia().verCartasJugador(1, 1);
		Controlador.getInstancia().verCartasJugador(1, 2);
		Controlador.getInstancia().verCartasJugador(1, 3);
		Controlador.getInstancia().verCartasJugador(1, 4);
		Controlador.getInstancia().jugarCarta(1, 1, 1); //id Juego, idJugador, idCarta
		
		
		
	}

	
}
