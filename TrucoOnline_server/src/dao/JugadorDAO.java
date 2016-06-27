package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.CategoriaDTO;
import dtos.EstadisticaDTO;
import dtos.JugadorDTO;
import entities.Categoria;
import entities.Jugador;

public class JugadorDAO {
	private static JugadorDAO instancia;

	public static JugadorDAO getInstancia(){
		if(instancia==null)
			instancia=new JugadorDAO();
		return instancia;
	}
	
	/**
	 * Solo para dar de alta el jugador ya que le crea una categoria novato por default
	 * @param j
	 */
	public void crearJugador(JugadorDTO j){
		Jugador jug = new Jugador(j.getApodo(),j.getMail(),j.getPassword());
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		Categoria c = (Categoria) s.createQuery("Select c from Categoria c where c.name = :id").setString("id", "Novato").uniqueResult();
		jug.setCategoria(c);
		s.save(jug);
		s.getTransaction().commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	public List<JugadorDTO> getAll() {
		List<JugadorDTO> jugDTO = new ArrayList<JugadorDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<Jugador> jug = (List<Jugador>) s.createQuery("SELECT j from Jugador j").list();
		s.getTransaction().commit();
		s.close();
		if(jug!=null){
			for(Jugador j: jug){
				CategoriaDTO cAux = CategoriaDAO.getInstancia().getCategoria(j.getCategoria().getIdCategoria());
				EstadisticaDTO eAux = new EstadisticaDTO(j.getEstadistica().getIdEstadistica(),j.getEstadistica().getPartidasJugadas(),j.getEstadistica().getPartidasGanadas(),j.getEstadistica().getPartidasPerdidas(),j.getEstadistica().getPuntaje());
				JugadorDTO juga = new JugadorDTO(j.getIdJugador(),j.getApodo(),j.getMail(),j.getPassword(),cAux,eAux);
				jugDTO.add(juga);
			}
			return jugDTO;
		}
		else{
			return jugDTO;
		}
			
	}

	public JugadorDTO getJugador(int idJugador) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Jugador jug = (Jugador) s.createQuery("select j from Jugador j where j.idJugador = :id")
				.setInteger("id", idJugador).uniqueResult();
		s.getTransaction().commit();
		s.close();
		if(jug!=null){
			CategoriaDTO cAux = CategoriaDAO.getInstancia().getCategoria(jug.getCategoria().getIdCategoria());
			
			EstadisticaDTO eAux = new EstadisticaDTO(jug.getEstadistica().getIdEstadistica(),jug.getEstadistica().getPartidasJugadas(),jug.getEstadistica().getPartidasGanadas(),jug.getEstadistica().getPartidasPerdidas(),jug.getEstadistica().getPuntaje());
			JugadorDTO jugador = new JugadorDTO(jug.getIdJugador(),jug.getApodo(),jug.getMail(),jug.getPassword(),cAux,eAux);
			return jugador;
		}
		return null;
	}
	
	public JugadorDTO entidadToDto(Jugador j){
		JugadorDTO jug = new JugadorDTO(j.getIdJugador(), j.getApodo(), j.getMail(), j.getPassword(),
				CategoriaDAO.getInstancia().entidadToDto(j.getCategoria()),
				EstadisticaDAO.getInstancia().entidadToDto(j.getEstadistica()));
		return jug;
	}
	
	public Jugador dtoToEntidad(JugadorDTO j){
		Jugador jug = new Jugador(j.getIdJugador(), j.getApodo(), j.getMail(), j.getPassword(),
				CategoriaDAO.getInstancia().dtoToEntidad(j.getCategoria()),
				EstadisticaDAO.getInstancia().dtoToEntidad(j.getEstadistica()));
		return jug;
	}

	public JugadorDTO finJugadorByApodo(String apodo) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Jugador j = (Jugador) s
				.createQuery("select j from Jugador j where j.apodo = :apodo")
				.setString("apodo", apodo).uniqueResult();
		JugadorDTO jDTO = this.entidadToDto(j);
		return jDTO;
	}
	
	public JugadorDTO finJugadorByMail(String mail) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Jugador j = (Jugador) s.createQuery(
				"select j from Jugador j where j.mail = :mail").setString(
				"mail", mail).uniqueResult();

		return this.entidadToDto(j);
	}
	
	public List<Jugador> dtoToEntidad(List<JugadorDTO> p){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for(JugadorDTO aux: p){
			Jugador jaux = dtoToEntidad(aux);
			jugadores.add(jaux);
		}
		return jugadores;
	}
	
	public List<JugadorDTO> entidadToDto(List<Jugador> p){
		List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
		for(Jugador aux: p){
			JugadorDTO jaux = entidadToDto(aux);
			jugadores.add(jaux);
		}
		return jugadores;
	}
	
}


