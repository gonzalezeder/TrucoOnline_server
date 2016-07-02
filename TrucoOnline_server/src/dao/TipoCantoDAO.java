package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import dtos.TipoCantoDTO;
import entities.TipoCanto;

public class TipoCantoDAO {

private static TipoCantoDAO instancia;
	
	public static TipoCantoDAO getInstancia(){
		if(instancia==null)
			instancia=new TipoCantoDAO();
		return instancia;
	}

	public List<TipoCantoDTO> entidadToDto(List <TipoCanto> m){
		List<TipoCantoDTO> movs = new ArrayList<TipoCantoDTO>();
		for(TipoCanto aux: m){
			TipoCantoDTO maux = entidadToDto(aux);
			movs.add(maux);
		}
		return movs;
		
	}
	
	public List<TipoCanto> dtoToEntidad(List <TipoCantoDTO> m){
		List<TipoCanto> movs = new ArrayList<TipoCanto>();
		for(TipoCantoDTO aux: m){
			TipoCanto maux = dtoToEntidad(aux);
			movs.add(maux);
		}
		return movs;
		
	}
	
	public TipoCantoDTO entidadToDto(TipoCanto m){
		if(m!= null){
			TipoCantoDTO mov = new TipoCantoDTO(m.getIdTipoCanto(),m.getAccion(),m.getDescCorta(),m.getPuntos(),m.getFinalizaCanto(),m.getTipo());
			return mov;
		}
		return null;
	}
	
	public TipoCanto dtoToEntidad(TipoCantoDTO m){
		if(m!= null){
			TipoCanto mov = new TipoCanto(m.getIdTipoCanto(),m.getAccion(),m.getDescCorta(),m.getPuntos(),m.getFinalizaCanto(),m.getTipo());
			return mov;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TipoCantoDTO> getAll() {
		List <TipoCantoDTO> cantos = new ArrayList<TipoCantoDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<TipoCanto> can = (List<TipoCanto>) s.createQuery("SELECT c from TipoCanto c").list();
		s.getTransaction().commit();
		s.close();
		
		if(can!=null){
			for(TipoCanto c: can){
				TipoCantoDTO aux = entidadToDto(c);
				cantos.add(aux);
			}
		}
		return cantos;
	}
	
}
