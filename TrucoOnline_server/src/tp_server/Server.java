package tp_server;

import interfaces.TDAManejoDatos;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;





public class Server {

	TDAManejoDatos objetoRemoto;
	
	public static void main(String[] args) {

		new Server(); 
	}
	
	public Server() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
    		LocateRegistry.createRegistry(1099);	
            //TDAManejoDatos gestionJugadores = new GestionJugadores();
           // Naming.rebind ("//localhost/GestionJugadores", gestionJugadores);
            System.out.println("Fijado en //localhost/GestionJugadores");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
