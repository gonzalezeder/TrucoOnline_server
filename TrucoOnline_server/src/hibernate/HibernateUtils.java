package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Baza;
import entities.Carta;
import entities.Categoria;
import entities.DetallePunto;
import entities.Estadistica;
import entities.Estado;
import entities.Juego;
import entities.Jugador;
import entities.Lobby;
import entities.Mano;
import entities.ManoJugador;
import entities.ManoJugadorCarta;
import entities.MatrizCanto;
import entities.Modalidad;
import entities.Movimiento;
import entities.Pareja;
import entities.Partida;
import entities.TipoCanto;

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
			config.addAnnotatedClass(Pareja.class);
			config.addAnnotatedClass(Juego.class);
			config.addAnnotatedClass(Partida.class);
			config.addAnnotatedClass(ManoJugador.class);
			config.addAnnotatedClass(ManoJugadorCarta.class);
			config.addAnnotatedClass(TipoCanto.class);
			config.addAnnotatedClass(Estado.class);
			config.addAnnotatedClass(Movimiento.class);
			config.addAnnotatedClass(Mano.class);
			config.addAnnotatedClass(DetallePunto.class);
			config.addAnnotatedClass(Baza.class);
			config.addAnnotatedClass(Modalidad.class);
			config.addAnnotatedClass(MatrizCanto.class);
			config.addAnnotatedClass(Lobby.class);
			
			
			

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
