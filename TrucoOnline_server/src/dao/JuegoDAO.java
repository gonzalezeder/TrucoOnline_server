package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.CategoriaDTO;
import dtos.EstadisticaDTO;
import dtos.JuegoDTO;
import dtos.JugadorDTO;
import entities.Juego;
import entities.Jugador;

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
		List<Juego> juegos = (List<Juego>) s.createQuery("SELECT j from Juegos j").list();
		s.getTransaction().commit();
		s.close();
		if(juegos!=null){
			for(Juego j: juegos){
				
				JuegoDTO jug = new JuegoDTO(0, null, null, null, null, null, null, null);
				juegoDTO.add(jug);
			}
			return juegoDTO;
		}
		else{
			return juegoDTO;
		}
		
	}
}
