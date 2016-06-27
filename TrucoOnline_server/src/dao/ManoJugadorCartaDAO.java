package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.ManoJugadorCartaDTO;
import entities.ManoJugadorCarta;

public class ManoJugadorCartaDAO {
	
	private static ManoJugadorCartaDAO instancia;
	
	public static ManoJugadorCartaDAO getInstancia(){
		if(instancia==null)
			instancia=new ManoJugadorCartaDAO();
		return instancia;
	}
	
	public List<ManoJugadorCartaDTO> entidadToDto(List <ManoJugadorCarta> mj){
		List<ManoJugadorCartaDTO> manosjugs = new ArrayList<ManoJugadorCartaDTO>();
		for(ManoJugadorCarta aux: mj){
			ManoJugadorCartaDTO paux = entidadToDto(aux);
			manosjugs.add(paux);
		}
		return manosjugs;
	}
	public List<ManoJugadorCarta> dtoToEntidad(List <ManoJugadorCartaDTO> mj){
		List<ManoJugadorCarta> manosjugs = new ArrayList<ManoJugadorCarta>();
		for(ManoJugadorCartaDTO aux: mj){
			ManoJugadorCarta paux = dtoToEntidad(aux);
			manosjugs.add(paux);
		}
		return manosjugs;
	}
	
	
	public ManoJugadorCartaDTO entidadToDto(ManoJugadorCarta mj){
		ManoJugadorCartaDTO manoJug = new ManoJugadorCartaDTO
				(mj.getIdManoJugadorCarta(),
				mj.isJugada(),
				CartaDAO.getInstancia().entidadToDto(mj.getCarta()));
		return manoJug;
	}
	
	public ManoJugadorCarta dtoToEntidad(ManoJugadorCartaDTO mj){
		ManoJugadorCarta manoJug = new ManoJugadorCarta
				(mj.getIdManoJugadorCarta(),
				mj.isJugada(),
				CartaDAO.getInstancia().dtoToEntidad(mj.getCarta()));
		return manoJug;
	}
	
}
