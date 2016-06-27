package dao;

import java.util.List;

import dtos.DetallePuntoDTO;
import dtos.ManoJugadorDTO;
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
		return null;
		
	}
	
	public List<DetallePunto> dtoToEntidad(List <DetallePuntoDTO> dp){
		return null;
		
	}
	
}
