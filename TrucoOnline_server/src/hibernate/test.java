package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Jugador;



public class test {
	public void prueba (){
	SessionFactory sf = HibernateUtils.getSessionFactory();
	Session s = sf.openSession();
	//ugador jug = new Jugador(null, null, null);
	
	}
}
