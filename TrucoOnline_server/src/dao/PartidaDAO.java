package dao;


import hibernate.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.SaveOrUpdateEvent;

import dtos.CartaDTO;
import dtos.JuegoDTO;
import dtos.PartidaDTO;
import entities.Juego;
import entities.Partida;

public class PartidaDAO {
private static PartidaDAO instancia;
	
	public static PartidaDAO getInstancia(){
		if(instancia==null)
			instancia=new PartidaDAO();
		return instancia;
	}
	
//	public void crearPartida(JuegoDTO j, List<CartaDTO> cartas){
//		SessionFactory sf = HibernateUtils.getSessionFactory();
//		Session s = sf.openSession();
//		s.beginTransaction();
//		j.repartirCartas(cartas);
//		Juego jug = JuegoDAO.getInstancia().dtoToEntidad(j);
//		s.saveOrUpdate(jug);
//		s.getTransaction().commit();
//		s.close();
////	}
	
	public List<PartidaDTO> entidadToDto(List<Partida> p){
		List<PartidaDTO> partidas = new ArrayList<PartidaDTO>();
		for(Partida aux: p){
			PartidaDTO paux = entidadToDto(aux);
			partidas.add(paux);
		}
		return partidas;
	}
	
	public List<Partida> dtoToEntidad(List<PartidaDTO> p){
		List<Partida> partidas = new ArrayList<Partida>();
		for(PartidaDTO aux: p){
			Partida paux = dtoToEntidad(aux);
			partidas.add(paux);
		}
		return partidas;
	}
	
	public PartidaDTO entidadToDto(Partida p){
		PartidaDTO par = new PartidaDTO(p.getIdPartida(),BazaDAO.getInstancia().entidadToDto(p.getBazas()),EstadoDAO.getInstancia().entidadToDto(p.getEstado()),ParejaDAO.getInstancia().entidadToDto(p.getParejaGanadora()),JugadorDAO.getInstancia().entidadToDto(p.getJugadores()));
		return par;
	}
	
	public Partida dtoToEntidad(PartidaDTO p){
		Partida par = new Partida(p.getIdPartida(),BazaDAO.getInstancia().dtoToEntidad(p.getBazas()),EstadoDAO.getInstancia().dtoToEntidad(p.getEstado()),ParejaDAO.getInstancia().dtoToEntidad(p.getParejaGanadora()),JugadorDAO.getInstancia().dtoToEntidad(p.getOrden()));
		return par;
	}
	
}
