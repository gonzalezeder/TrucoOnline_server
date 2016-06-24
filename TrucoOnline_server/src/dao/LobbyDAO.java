package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.JugadorDTO;
import dtos.LobbyDTO;
import dtos.ModalidadDTO;
import entities.Jugador;
import entities.Lobby;
import entities.Modalidad;


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
				LobbyDTO lob = new LobbyDTO(l.getId(), JugadorDAO.getInstancia().getJugador(l.getJugador().getIdJugador()),
						ModalidadDAO.getInstancia().getModalidad(l.getModalidad().getModalidad()),l.getJugando());
				lobbyDTO.add(lob);
			}
			return lobbyDTO;
		}
		else{
			return lobbyDTO;
		}
		
	}


	public void crearLobby(LobbyDTO l) {
		
		Lobby lobby = dtoToEntidad(l);
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(lobby);
		s.getTransaction().commit();
		s.close();
		
	}
	
	public LobbyDTO entidadToDto(Lobby l){
		LobbyDTO lob = new LobbyDTO(JugadorDAO.getInstancia().entidadToDto(l.getJugador()),ModalidadDAO.getInstancia().entidadToDto(l.getModalidad()));
		return lob;
	}
	
	public Lobby dtoToEntidad(LobbyDTO l){
		Lobby lob = new Lobby(JugadorDAO.getInstancia().dtoToEntidad(l.getJugador()) ,ModalidadDAO.getInstancia().dtoToEntidad(l.getModalidad()));
		return lob;
	}


	public void quitarJugador(int j, int m) {
		Lobby lob = getLobby(j,m);
		if(lob!=null){
			lob.setJugando(2); 
			SessionFactory sf = HibernateUtils.getSessionFactory();
			Session s = sf.openSession();
			s.beginTransaction();
			s.saveOrUpdate(lob);
			s.getTransaction().commit();
			s.close();
		}	
	}
	
	public Lobby getLobby(int j, int m){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Lobby l = (Lobby) s.createQuery("Select l from Lobby l where l.jugador.idJugador = :idJugador and l.modalidad.IdModalidad = :idm and l.jugando= 0")
		.setInteger("idJugador", j).setInteger("idm", m).uniqueResult();
		s.getTransaction().commit();
		s.close();
		return l;
	}
	
}
