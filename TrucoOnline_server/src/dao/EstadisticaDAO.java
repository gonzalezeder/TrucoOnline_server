package dao;

import dtos.EstadisticaDTO;

import entities.Estadistica;


public class EstadisticaDAO {
	private static EstadisticaDAO instancia;

	public static EstadisticaDAO getInstancia(){
		if(instancia==null)
			instancia=new EstadisticaDAO();
		return instancia;
	}
	
	public EstadisticaDTO entidadToDto(Estadistica e){
		EstadisticaDTO est = new EstadisticaDTO(e.getIdEstadistica(),e.getPartidasJugadas(),e.getPartidasGanadas(),e.getPartidasPerdidas(),e.getPuntaje());
		return est;
	}
	
	public Estadistica dtoToEntidad(EstadisticaDTO e){
		Estadistica est = new Estadistica(e.getIdEstadistica(),e.getPartidasJugadas(),e.getPartidasGanadas(),e.getPartidasPerdidas(),e.getPuntaje());
		return est;
	}
	
}
