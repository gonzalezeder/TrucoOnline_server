package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.BazaDTO;
import dtos.ManoDTO;
import dtos.ManoJugadorDTO;
import entities.Baza;
import entities.Mano;
import entities.ManoJugador;

public class ManoDAO {

	private static ManoDAO instancia;
	
	public static ManoDAO getInstancia(){
		if(instancia==null)
			instancia=new ManoDAO();
		return instancia;
	}
	
	public List<ManoDTO> entidadToDto(List <Mano> m){
		List<ManoDTO> manos = new ArrayList<ManoDTO>();
		for(Mano aux: m){
			ManoDTO maux = entidadToDto(aux);
			manos.add(maux);
		}
		return manos;
		
	}
	
	public List<Mano> dtoToEntidad(List <ManoDTO> m){
		List<Mano> manos = new ArrayList<Mano>();
		for(ManoDTO aux: m){
			Mano maux = dtoToEntidad(aux);
			manos.add(maux);
		}
		return manos;
		
	}
	
	public ManoDTO entidadToDto(Mano m){
		ManoDTO mano = new ManoDTO(m.getIdMano(),
				MovimientoDAO.getInstancia().entidadToDto(m.getMovimientos()),
						EstadoDAO.getInstancia().entidadToDto(m.getEstado()));
		return mano;
	}
	
	public Mano dtoToEntidad(ManoDTO m){
		Mano mano = new Mano(m.getIdMano(),
				MovimientoDAO.getInstancia().dtoToEntidad(m.getMovimientos()),
				EstadoDAO.getInstancia().dtoToEntidad(m.getEstado()));
		return mano;
	}
	
	
}
