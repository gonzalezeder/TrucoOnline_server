package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.BazaDTO;
import dtos.ManoDTO;
import entities.Baza;
import entities.Mano;

public class ManoDAO {

	private static ManoDAO instancia;
	
	public static ManoDAO getInstancia(){
		if(instancia==null)
			instancia=new ManoDAO();
		return instancia;
	}
	
	public List<ManoDTO> entidadToDto(List <Mano> m){
		return null;
		
	}
	
	public List<Mano> dtoToEntidad(List <ManoDTO> m){
		return null;
		
	}
}
