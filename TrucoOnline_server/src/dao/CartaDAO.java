package dao;

import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dtos.CartaDTO;
import dtos.EstadisticaDTO;
import dtos.JugadorDTO;
import dtos.PartidaDTO;
import entities.Carta;
import entities.Estadistica;
import entities.Jugador;
import entities.Partida;

public class CartaDAO {

private static CartaDAO instancia;
	
	public static CartaDAO getInstancia(){
		if(instancia==null)
			instancia=new CartaDAO();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<CartaDTO> getAll(){
		List<CartaDTO> carDTO = new ArrayList<CartaDTO>();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		List<Carta> car = (List<Carta>) s.createQuery("SELECT c from Carta c").list();
		s.getTransaction().commit();
		s.close();
		
		if(car!=null){
			for(Carta c: car){
				CartaDTO aux = entidadToDto(c);
				carDTO.add(aux);
			}
		}
		return carDTO;
	}
	
	public CartaDTO entidadToDto(Carta c){
		CartaDTO car = new CartaDTO(c.getIdCarta(),c.getNumero(),c.getPalo(),c.getValorEnvido(),c.getArchivo(),c.getValorTruco());
		return car;
	}
	
	public Carta dtoToEntidad(CartaDTO c){
		Carta car = new Carta(c.getIdCarta(),c.getNumero(),c.getPalo(),c.getValorEnvido(),c.getArchivo(),c.getValorTruco());
		return car;
	}
	
	public List<Carta> dtoToEntidad(List<CartaDTO> c){
		List<Carta> cartas = new ArrayList<Carta>();
		for(CartaDTO aux: c){
			Carta caux = dtoToEntidad (aux);
			cartas.add(caux);
		}
		return cartas;
	}
	
	public List<CartaDTO> entidadToDto(List<Carta> c){
		List<CartaDTO> cartas = new ArrayList<CartaDTO>();
		for(Carta aux: c){
			CartaDTO paux = entidadToDto(aux);
			cartas.add(paux);
		}
		return cartas;
	}
	
}
