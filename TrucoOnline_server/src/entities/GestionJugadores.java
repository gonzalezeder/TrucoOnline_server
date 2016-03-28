package entities;

import interfaces.TDAManejoDatos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import dtos.JugadorDTO;



public class GestionJugadores extends UnicastRemoteObject implements TDAManejoDatos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionJugadores() throws RemoteException {
		super();
		jugadores = new HashSet<JugadorDTO>();	
		jugadores.add(new JugadorDTO(1,"Santiago"));
		jugadores.add(new JugadorDTO(2,"Nicolás"));
		jugadores.add(new JugadorDTO(3,"Eder"));
	

	}
	private Set<JugadorDTO> jugadores;
	
	
	

	@Override
	public JugadorDTO obtengoJugador(int nroJugador) throws RemoteException {
		JugadorDTO aux;
		for(Iterator<JugadorDTO> i=jugadores.iterator();i.hasNext();)
		{
			aux = i.next();
			if(aux.getNumeroJugador()==nroJugador)
				return aux;
		}
		throw new RemoteException("No encontré al jugador. Puto.");
	}

	@Override
	public void envioJugador(JugadorDTO jugador) throws RemoteException {
		jugadores.add(jugador);
		
	}

	@Override
	public Set<JugadorDTO> obtengoJugadores() throws RemoteException {
		return jugadores;
	}

	@Override
	public int cantidadJugadores() throws RemoteException {
		return jugadores.size();
	}
	
	
}
