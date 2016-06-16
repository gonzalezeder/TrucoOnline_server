package dao;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;

import hibernate.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.CategoriaDTO;
import dtos.EstadisticaDTO;
import dtos.JugadorDTO;
import entities.Categoria;
import entities.Estadistica;
import entities.Jugador;

public class JugadorDAO {
	private static JugadorDAO instancia;

	public static JugadorDAO getInstancia(){
		if(instancia==null)
			instancia=new JugadorDAO();
		return instancia;
	}
	
	public void GrabarJugador(JugadorDTO j){
		Jugador jug = new Jugador();
		jug.setApodo(j.getApodo());
		jug.setMail(j.getMail());
		jug.setPassword(j.getPassword());
		jug.setEstadistica(new Estadistica());

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
				CategoriaDTO cAux = new CategoriaDTO(j.getCategoria().getName(), j.getCategoria().getCantPartidas(),j.getCategoria().getPuntaje(),j.getCategoria().getPromedio());
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
}


