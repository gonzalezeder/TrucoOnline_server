package dao;

import hibernate.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.ModalidadDTO;
import entities.Modalidad;

public class ModalidadDAO {
	private static ModalidadDAO instancia;
	public static ModalidadDAO getInstancia(){
		if(instancia==null)
			instancia=new ModalidadDAO();
		return instancia;
	}
	
	public ModalidadDTO getModalidad(int idModalidad){
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Modalidad mod = (Modalidad) s.createQuery("select m from Modalidad m where m.modalidad =: id")
				.setInteger("id", idModalidad).uniqueResult();
		if(mod!=null){
			ModalidadDTO m = new ModalidadDTO(mod.getModalidad(),mod.getNombre());
			return m;
		}
		return null;
	}
	
}
