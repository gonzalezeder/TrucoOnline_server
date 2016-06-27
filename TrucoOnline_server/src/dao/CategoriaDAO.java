package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.CategoriaDTO;
import dtos.CategoriaDTO;
import dtos.JugadorDTO;
import entities.Categoria;
import entities.Estadistica;
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
				CategoriaDTO cAux = entidadToDto(c);
				catDTO.add(cAux);
			}
			return catDTO;
		}
		else{
			return catDTO;
		}
			
	}
	
	public CategoriaDTO entidadToDto(Categoria c){
		CategoriaDTO cat = new CategoriaDTO(c.getIdCategoria(), c.getName(),c.getCantPartidas(),c.getPuntaje(),c.getPromedio());
		return cat;
	}
	
	public Categoria dtoToEntidad(CategoriaDTO c){
		Categoria cat = new Categoria(c.getId(), c.getName(),c.getCantPartidas(),c.getPuntaje(),c.getPromedio());
		return cat;
	}

	public CategoriaDTO getCategoria(int idCategoria) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Categoria cat = (Categoria) s.createQuery("select c from Categoria c where c.idCategoria = :id")
				.setInteger("id", idCategoria).uniqueResult();
		s.getTransaction().commit();
		s.close();
		if(cat!=null){	
			return entidadToDto(cat);
		}
		return null;
	}
	
}
