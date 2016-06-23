package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.LobbyDTO;
import dtos.LobbyDTO;
import entities.Lobby;
import entities.Lobby;

public class LobbyDAO {
	
private static LobbyDAO instancia;
	
	public static LobbyDAO getInstancia(){
		if(instancia==null)
			instancia=new LobbyDAO();
		return instancia;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LobbyDTO> getAll() {
		List<LobbyDTO> lobbyDTO = new ArrayList<LobbyDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<Lobby> lobbies = (List<Lobby>) s.createQuery("SELECT l from Lobby l").list();
		s.getTransaction().commit();
		s.close();
		if(lobbies!=null){
			for(Lobby l: lobbies){
				LobbyDTO lob = new LobbyDTO(l.getId(),JugadorDAO.getInstancia().getJugador(l.getJugador().getIdJugador()),
						ModalidadDAO.getInstancia().getModalidad(l.getModalidad().getModalidad()),l.getJugando());
				lobbyDTO.add(lob);
			}
			return lobbyDTO;
		}
		else{
			return lobbyDTO;
		}
		
	}
}
