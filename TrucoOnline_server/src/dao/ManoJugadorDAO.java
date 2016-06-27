package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.ManoJugadorDTO;
import entities.ManoJugador;

public class ManoJugadorDAO {

	private static ManoJugadorDAO instancia;
	
	public static ManoJugadorDAO getInstancia(){
		if(instancia==null)
			instancia=new ManoJugadorDAO();
		return instancia;
	}
	
	public List<ManoJugadorDTO> entidadToDto(List <ManoJugador> mj){
		List<ManoJugadorDTO> manosjugs = new ArrayList<ManoJugadorDTO>();
		for(ManoJugador aux: mj){
			ManoJugadorDTO paux = entidadToDto(aux);
			manosjugs.add(paux);
		}
		return manosjugs;
		
	}
	
	public List<ManoJugador> dtoToEntidad(List <ManoJugadorDTO> mj){
		List<ManoJugador> manosjugs = new ArrayList<ManoJugador>();
		for(ManoJugadorDTO aux: mj){
			ManoJugador paux = dtoToEntidad(aux);
			manosjugs.add(paux);
		}
		return manosjugs;
		
	}
	
	
	public ManoJugadorDTO entidadToDto(ManoJugador mj){
		ManoJugadorDTO manoJug = new ManoJugadorDTO(mj.getIdManoJugador(),
				mj.getPosicionMesa(),
				ManoJugadorCartaDAO.getInstancia().entidadToDto(mj.getCartas()),
				JugadorDAO.getInstancia().entidadToDto(mj.getJugador()));
		return manoJug;
	}
	
	public ManoJugador dtoToEntidad(ManoJugadorDTO mj){
		ManoJugador manoJug = new ManoJugador(mj.getIdManoJugador(),
				mj.getPosicionMesa(),
				ManoJugadorCartaDAO.getInstancia().dtoToEntidad(mj.getCartas()),
				JugadorDAO.getInstancia().dtoToEntidad(mj.getJugador()));
		return manoJug;
	}
	
}
