package tp_server;

public class Main {

	
	public static void main(String[] args) {
		Controlador.getInstancia();
			
	//	Controlador.getInstancia().imprimirCategorias();
		Controlador.getInstancia().altaJugador("Nico","nmuttoni91@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Santi","sblanzaco@gmail.com","contraseña");
	//	Controlador.getInstancia().imprimirJugadores();
	//	Controlador.getInstancia().validarLogin("nmuttoni91@gmail.com","contraseña");
		Controlador.getInstancia().entrarLobby(1);
		Controlador.getInstancia().entrarLobby(2);
		Controlador.getInstancia().verJugadoresOnline();
		
	}

	
}
