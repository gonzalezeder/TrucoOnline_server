package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Baza;
import entities.Canto;
import entities.Carta;
import entities.Categoria;
import entities.Estadistica;
import entities.Juego;
import entities.Jugador;
import entities.Mazo;
import entities.Movimiento;
import entities.Pareja;
import entities.Partida;

public class HibernateUtils {

	/**
	 * Se deben ir incorporando las clases persistentes esta clase.
	 * Mantener el orden alfabetico.
	 */
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Estadistica.class);
			config.addAnnotatedClass(Categoria.class);
			config.addAnnotatedClass(Jugador.class);
			config.addAnnotatedClass(Carta.class);
			config.addAnnotatedClass(Mazo.class);
			config.addAnnotatedClass(Pareja.class);
			//config.addAnnotatedClass(Juego.class);
			//config.addAnnotatedClass(Partida.class);
			//config.addAnnotatedClass(Baza.class);
			config.addAnnotatedClass(Canto.class);
			
			config.addAnnotatedClass(Movimiento.class);

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
