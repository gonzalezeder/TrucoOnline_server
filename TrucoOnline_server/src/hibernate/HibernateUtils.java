package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Carta;
import entities.Jugador;

public class HibernateUtils {

	/**
	 * Se deben ir incorporando las clases persistentes esta clase.
	 * Mantener el orden alfabetico.
	 */
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Carta.class);
			config.addAnnotatedClass(Jugador.class);

			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
