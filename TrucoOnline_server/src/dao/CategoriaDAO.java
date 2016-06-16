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

public class CategoriaDAO  {
	private static CategoriaDAO instancia;

	public static CategoriaDAO getInstancia(){
		if(instancia==null)
			instancia=new CategoriaDAO();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoriaDTO> getAll() {
		List<CategoriaDTO> catDTO = new ArrayList<CategoriaDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<Categoria> cat = (List<Categoria>) s.createQuery("SELECT c from Categoria c").list();
		s.getTransaction().commit();
		s.close();
		if(cat!=null){
			for(Categoria c: cat){
				CategoriaDTO cAux = new CategoriaDTO(c.getName(),c.getCantPartidas(),c.getPuntaje(),c.getPromedio());
				catDTO.add(cAux);
			}
			return catDTO;
		}
		else{
			return catDTO;
		}
			
	}
}
