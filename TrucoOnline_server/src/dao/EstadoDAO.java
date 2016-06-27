package dao;

import dtos.EstadoDTO;
import entities.Estado;

public class EstadoDAO {

	private static EstadoDAO instancia;
	
	public static EstadoDAO getInstancia(){
		if(instancia==null)
			instancia = new EstadoDAO();
		return instancia;
	}

	
	public EstadoDTO entidadToDto(Estado e){
		EstadoDTO est = new EstadoDTO(e.getIdEstado(),e.getEstado());
		return est;
	}
	
	public Estado dtoToEntidad(EstadoDTO e){
		Estado est = new Estado(e.getId(),e.getEstado());
		return est;
	}
	
}
