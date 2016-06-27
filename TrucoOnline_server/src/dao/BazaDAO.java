package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.BazaDTO;
import dtos.PartidaDTO;
import entities.Baza;
import entities.Partida;

public class BazaDAO {

	private static BazaDAO instancia;
	
	public static BazaDAO getInstancia(){
		if(instancia==null)
			instancia=new BazaDAO();
		return instancia;
	}
	
	public List<BazaDTO> entidadToDto(List <Baza> b){
		List<BazaDTO> bazas = new ArrayList<BazaDTO>();
		for(Baza aux: b){
			BazaDTO paux = entidadToDto(aux);
			bazas.add(paux);
		}
		return bazas;
		
	}
	
	public List<Baza> dtoToEntidad(List <BazaDTO> b){
		List<Baza> bazas = new ArrayList<Baza>();
		for(BazaDTO aux: b){
			Baza paux = dtoToEntidad(aux);
			bazas.add(paux);
		}
		return bazas;
		
	}
	
	public BazaDTO entidadToDto(Baza b){
		BazaDTO baza = new BazaDTO(b.getIdBaza(),
				EstadoDAO.getInstancia().entidadToDto(b.getEstado()),
				ManoDAO.getInstancia().entidadToDto(b.getManos()),
				DetallePuntoDAO.getInstancia().entidadToDto(b.getPuntos()),
				ManoJugadorDAO.getInstancia().entidadToDto(b.getManosJugadores()),
				JugadorDAO.getInstancia().entidadToDto(b.getJugMano()),
				CartaDAO.getInstancia().entidadToDto(b.getCartas()));
		return baza;
	}
	
	public Baza dtoToEntidad(BazaDTO b){
		Baza baza = new Baza(b.getIdBaza(),
				EstadoDAO.getInstancia().dtoToEntidad(b.getEstado()),
				ManoDAO.getInstancia().dtoToEntidad(b.getManos()),
				DetallePuntoDAO.getInstancia().dtoToEntidad(b.getPuntos()),
				ManoJugadorDAO.getInstancia().dtoToEntidad(b.getManosJugadores()),
				JugadorDAO.getInstancia().dtoToEntidad(b.getJugMano()),
				CartaDAO.getInstancia().dtoToEntidad(b.getCartas()));
		return baza;
	}
	
	
}
