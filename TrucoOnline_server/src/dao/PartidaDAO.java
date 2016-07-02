package dao;



import java.util.ArrayList;
import java.util.List;

import dtos.PartidaDTO;
import entities.Partida;

public class PartidaDAO {
private static PartidaDAO instancia;
	
	public static PartidaDAO getInstancia(){
		if(instancia==null)
			instancia=new PartidaDAO();
		return instancia;
	}
	
	
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
		PartidaDTO par = new PartidaDTO(p.getIdPartida(),BazaDAO.getInstancia().entidadToDto(p.getBazas()),EstadoDAO.getInstancia().entidadToDto(p.getEstado()),ParejaDAO.getInstancia().entidadToDto(p.getParejaGanadora()),JugadorDAO.getInstancia().entidadToDto(p.getJugadores()),JugadorDAO.getInstancia().entidadToDto(p.getOrdenOriginal()));
		return par;
	}
	
	public Partida dtoToEntidad(PartidaDTO p){
		Partida par = new Partida(p.getIdPartida(),BazaDAO.getInstancia().dtoToEntidad(p.getBazas()),EstadoDAO.getInstancia().dtoToEntidad(p.getEstado()),ParejaDAO.getInstancia().dtoToEntidad(p.getParejaGanadora()),JugadorDAO.getInstancia().dtoToEntidad(p.getOrden()),JugadorDAO.getInstancia().dtoToEntidad(p.getOrdenOriginal()));
		return par;
	}
	
}
