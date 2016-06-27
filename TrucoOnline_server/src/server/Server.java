package server;

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
    		System.out.println("Server starting...");
            TDAManejoDatos gestionJugadores = new Controlador();
            Naming.rebind ("//localhost/GestionJugadores", gestionJugadores);
            System.out.println("Fijado en //localhost/GestionJugadores");
            
    		System.out.println("Server up...");
		} catch (Exception e) {
			e.printStackTrace();
		}
//    	
//    	try {
//		
//    		java.rmi.registry.LocateRegistry.createRegistry(1099);
//    		// Create an instance of the server object
//			RemoteDateImpl im = new RemoteDateImpl();
//
//			System.out.println("DateServer starting...");
////			System.setProperty("java.rmi.server.hostname","192.168.0.4");
//
//			// Publish it in the RMI registry.
//			// Of course you have to have rmiregistry or equivalent running!
//			Naming.rebind(RemoteDate.LOOKUPNAME, im);
//
//			System.out.println("DateServer ready.");
//		} catch (Exception e) {
//			System.err.println(e);
//			System.exit(1);
//		}
    	
    	
    }

}
