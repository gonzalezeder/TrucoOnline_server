package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.CartaDTO;
import dtos.CategoriaDTO;
import dtos.EstadisticaDTO;
import dtos.JuegoDTO;
import dtos.JugadorDTO;
import dtos.MazoDTO;
import dtos.PartidaDTO;
import entities.Juego;
import entities.Jugador;
import entities.Mazo;

public class JuegoDAO {
	private static JuegoDAO instancia;
	
	public static JuegoDAO getInstancia(){
		if(instancia==null)
			instancia=new JuegoDAO();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<JuegoDTO> getAll() {
		List<JuegoDTO> juegoDTO = new ArrayList<JuegoDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<Juego> juegos = (List<Juego>) s.createQuery("SELECT j from Juego j").list();
		s.getTransaction().commit();
		s.close();
		if(juegos!=null){
			for(Juego j: juegos){
				//MazoDTO m = new MazoDTO();
				//m.setCartas(CartaDAO.getInstancia().entidadToDto(j.getMazo().getCartas()));
				JuegoDTO jug = new JuegoDTO(j.getIdJuego(),j.getFechaJuego(),ParejaDAO.getInstancia().entidadToDto(j.getEquipo1()),ParejaDAO.getInstancia().entidadToDto(j.getEquipo2()),EstadoDAO.getInstancia().entidadToDto(j.getEstado()),PartidaDAO.getInstancia().entidadToDto(j.getPartidas()), ModalidadDAO.getInstancia().entidadToDto(j.getModalidad()));
				juegoDTO.add(jug);
			}
			return juegoDTO;
		}
		else{
			return juegoDTO;
		}
	}
	
	public JuegoDTO getJuego(int idJuego){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Juego j = (Juego)s.createQuery("select j from Juego j where idJuego= :id")
				.setInteger("id", idJuego)
				.uniqueResult();
		s.getTransaction().commit();
		s.close();
		JuegoDTO juego = null;
		if(j!=null)
			juego = entidadToDto(j);
		return juego;
	}
	

	public void crearJuego(JuegoDTO j) {
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		ParejaDAO.getInstancia().crearPareja(j.getEquipo1());
		ParejaDAO.getInstancia().crearPareja(j.getEquipo2());
		
		Juego juego = new Juego(ParejaDAO.getInstancia().dtoToEntidad(j.getEquipo1()),ParejaDAO.getInstancia().dtoToEntidad(j.getEquipo2()), ModalidadDAO.getInstancia().dtoToEntidad(j.getModalidad()));
		s.save(juego);
		s.getTransaction().commit();
		s.close();
	}
	
	public void grabarJuego(JuegoDTO j){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Juego juego = new Juego(j.getIdJuego(), j.getFechaJuego(), ParejaDAO.getInstancia().dtoToEntidad(j.getEquipo1()),ParejaDAO.getInstancia().dtoToEntidad(j.getEquipo2()),EstadoDAO.getInstancia().dtoToEntidad(j.getEstado()), PartidaDAO.getInstancia().dtoToEntidad(j.getPartidas()), ModalidadDAO.getInstancia().dtoToEntidad(j.getModalidad()));
		s.saveOrUpdate(juego);
		s.getTransaction().commit();
		s.close();
//		PartidaDAO.getInstancia().crearPartida(j, cartas);
	}
	
	public JuegoDTO entidadToDto(Juego j){
		JuegoDTO jueg = new JuegoDTO(j.getIdJuego(),j.getFechaJuego(),
				ParejaDAO.getInstancia().entidadToDto(j.getEquipo1()),
				ParejaDAO.getInstancia().entidadToDto(j.getEquipo2()), 
				EstadoDAO.getInstancia().entidadToDto(j.getEstado()),
				PartidaDAO.getInstancia().entidadToDto(j.getPartidas()),
				ModalidadDAO.getInstancia().entidadToDto(j.getModalidad()));
		return jueg;
	}
	
	public Juego dtoToEntidad(JuegoDTO j){
		
		Juego jueg = new Juego(j.getIdJuego(),j.getFechaJuego(),
				ParejaDAO.getInstancia().dtoToEntidad(j.getEquipo1()),
				ParejaDAO.getInstancia().dtoToEntidad(j.getEquipo2()),
				EstadoDAO.getInstancia().dtoToEntidad(j.getEstado()),
				PartidaDAO.getInstancia().dtoToEntidad(j.getPartidas()),
				ModalidadDAO.getInstancia().dtoToEntidad(j.getModalidad()));
		return jueg;
	}
	
}
