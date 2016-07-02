package server;

import hibernate.Test;

public class Main {

	
	public static void main(String[] args) {

		
////
//		Controlador.getInstancia().altaJugador("Nicolas","Nicolas@gmail.com","contraseña");
//		Controlador.getInstancia().altaJugador("Messi","leomessi@gmail.com","leomessi");
//		Controlador.getInstancia().altaJugador("Santiago","Santiago@gmail.com","contraseña");
//		Controlador.getInstancia().altaJugador("Eduardo","Eduardo@gmail.com","contraseña");
////		Controlador.getInstancia().altaJugador("Eder","eder@gmail.com","contraseña");

//		Controlador.getInstancia().imprimirCategorias();
//		Controlador.getInstancia().imprimirJugadores();
//		Controlador.getInstancia().validarLogin("nmuttoni91@gmail.com","riverplate");
//		Controlador.getInstancia().validarLogin("nmuttoni91@gmail.com","mal");

	//	Controlador.getInstancia().verJugadoresOnline();

//////
//		Controlador.getInstancia().jugarTruco(1,1);
//		Controlador.getInstancia().jugarTruco(2,1);
//		Controlador.getInstancia().jugarTruco(3,1);
//		Controlador.getInstancia().jugarTruco(4,1);
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
	
//		Controlador.getInstancia().crearJuegos();
//		Controlador.getInstancia().verTurno(18);
		
		//1era carta
		
//		Controlador.getInstancia().jugarCarta(18, 2, 4); //id Juego, idJugador, idCarta
//		Controlador.getInstancia().jugarCarta(18, 1, 22);
//		Controlador.getInstancia().jugarCarta(18, 3, 37);
//		Controlador.getInstancia().jugarCarta(18, 4, 20);
//		
//		Controlador.getInstancia().jugarCarta(18, 2, 8); //id Juego, idJugador, idCarta
//		Controlador.getInstancia().jugarCarta(18, 1, 14);
//		Controlador.getInstancia().jugarCarta(18, 3, 18);
//		Controlador.getInstancia().jugarCarta(18, 4, 34);
//		
//		Controlador.getInstancia().jugarCarta(18, 2, 16); //id Juego, idJugador, idCarta
//		Controlador.getInstancia().jugarCarta(18, 1, 25);
//		Controlador.getInstancia().jugarCarta(18, 3, 32);
//		Controlador.getInstancia().jugarCarta(18, 4, 19);
		
		Controlador.getInstancia().repartir(18);
//		Controlador.getInstancia().verTurno(24);
		
		Test aTest = new Test();
		aTest.prueba();
//		
	}
	

	
}
