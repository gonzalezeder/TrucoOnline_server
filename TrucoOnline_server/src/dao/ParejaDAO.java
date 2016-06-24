package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.JugadorDTO;
import dtos.ParejaDTO;
import entities.Jugador;
import entities.Pareja;

public class ParejaDAO {
	private static ParejaDAO instancia;
	
	public static ParejaDAO getInstancia(){
		if(instancia==null)
			instancia=new ParejaDAO();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<ParejaDTO> getAll(){
		List<ParejaDTO> parejas = new ArrayList<ParejaDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<Pareja> p = s.createQuery("Select p from parejas p").list();
		
		if(p!=null)
			for(Pareja aux: p)
				parejas.add(entidadToDto(aux));
		return parejas;
	}
	
	
	public ParejaDTO entidadToDto(Pareja p){
		ParejaDTO par = new ParejaDTO(JugadorDAO.getInstancia().entidadToDto(p.getJugador1()),JugadorDAO.getInstancia().entidadToDto(p.getJugador2()));
		return par;
	}
	
	public Pareja dtoToEntidad(ParejaDTO p){
		Pareja par = new Pareja(JugadorDAO.getInstancia().dtoToEntidad(p.getJugador1()),JugadorDAO.getInstancia().dtoToEntidad(p.getJugador2()));
		return par;
	}

	public void crearPareja(ParejaDTO p) {
		Pareja par = dtoToEntidad(p);
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(par);
		s.getTransaction().commit();
		s.close();
	}
	
}
