package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.CartaDTO;
import dtos.DetallePuntoDTO;
import dtos.ManoJugadorDTO;
import entities.Carta;
import entities.DetallePunto;
import entities.ManoJugador;

public class DetallePuntoDAO {
	
	private static DetallePuntoDAO instancia;
	
	public static DetallePuntoDAO getInstancia(){
		if(instancia==null)
			instancia=new DetallePuntoDAO();
		return instancia;
	}
	
	public List<DetallePuntoDTO> entidadToDto(List <DetallePunto> dp){
		List<DetallePuntoDTO> detalles = new ArrayList<DetallePuntoDTO>();
		for(DetallePunto aux: dp){
			DetallePuntoDTO daux = entidadToDto (aux);
			detalles.add(daux);
		}
		return detalles;
		
	}
	
	public List<DetallePunto> dtoToEntidad(List <DetallePuntoDTO> dp){
		List<DetallePunto> detalles = new ArrayList<DetallePunto>();
		for(DetallePuntoDTO aux: dp){
			DetallePunto daux = dtoToEntidad (aux);
			detalles.add(daux);
		}
		return detalles;	
	}
	
	public DetallePuntoDTO entidadToDto(DetallePunto d){
		DetallePuntoDTO det = new DetallePuntoDTO(d.getIdDetalle(), d.getPuntos(), TipoCantoDAO.getInstancia().entidadToDto(d.getTipo()),d.getEquipo());
		return det;
	}
	
	public DetallePunto dtoToEntidad(DetallePuntoDTO d){
		DetallePunto det = new DetallePunto(d.getIdDetalle(), d.getPuntos(), TipoCantoDAO.getInstancia().dtoToEntidad(d.getTipo()),d.getEquipo());
		return det;
	}
	
	
}
