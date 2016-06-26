package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Jugador;



public class Test {
	public void prueba (){
	SessionFactory sf = HibernateUtils.getSessionFactory();
	Session s = sf.openSession();
	
	
	}
}
