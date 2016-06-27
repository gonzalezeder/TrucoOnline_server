package server;

import hibernate.Test;

public class Main {

	
	public static void main(String[] args) {

		
//
		Controlador.getInstancia().altaJugador("Nicolas","Nicolas@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Messi","leomessi@gmail.com","leomessi");
		Controlador.getInstancia().altaJugador("Santiago","Santiago@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Eduardo","Eduardo@gmail.com","contraseña");
		Controlador.getInstancia().altaJugador("Eder","eder@gmail.com","contraseña");

//		Controlador.getInstancia().imprimirCategorias();
//		Controlador.getInstancia().imprimirJugadores();
//		Controlador.getInstancia().validarLogin("nmuttoni91@gmail.com","riverplate");
//		Controlador.getInstancia().validarLogin("nmuttoni91@gmail.com","mal");

	//	Controlador.getInstancia().verJugadoresOnline();


//		Controlador.getInstancia().jugarTruco(3,1);
//		Controlador.getInstancia().jugarTruco(4,1);
//		Controlador.getInstancia().jugarTruco(5,1);
//		Controlador.getInstancia().jugarTruco(6,1);
//		Controlador.getInstancia().jugarTruco(7,1);
//		Controlador.getInstancia().jugarTruco(3,2);
//		Controlador.getInstancia().jugarTruco(4,2);
//		Controlador.getInstancia().jugarTruco(5,2);
//		Controlador.getInstancia().jugarTruco(6,2);
//		Controlador.getInstancia().jugarTruco(3,1);
//		Controlador.getInstancia().jugarTruco(4,2);
//		Controlador.getInstancia().jugarTruco(5,3);
		
//		Controlador.getInstancia().sacarJugadorModalidad(3, 2, 2);
//		Controlador.getInstancia().sacarJugadorModalidad(4, 2, 2);
//		Controlador.getInstancia().sacarJugadorModalidad(5, 2, 2);
//		Controlador.getInstancia().sacarJugadorModalidad(6, 2, 2);
//		Controlador.getInstancia().sacarJugadorModalidad(5, 3, 2);
	
		Controlador.getInstancia().crearJuegos();
	//	Controlador.getInstancia().verCartasJugador(1, 1);
	//	Controlador.getInstancia().verCartasJugador(1, 2);
	//	Controlador.getInstancia().verCartasJugador(1, 3);
	//	Controlador.getInstancia().verCartasJugador(1, 4);
	//	Controlador.getInstancia().jugarCarta(1, 1, 1); //id Juego, idJugador, idCarta
		
		Test aTest = new Test();
		aTest.prueba();
//		
	}
	

	
}
