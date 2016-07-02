package dao;

import java.util.ArrayList;
import java.util.List;

import dtos.ManoDTO;
import dtos.MovimientoDTO;
import entities.Mano;
import entities.Movimiento;

public class MovimientoDAO {
	
	
	private static MovimientoDAO instancia;
	
	public static MovimientoDAO getInstancia(){
		if(instancia==null)
			instancia=new MovimientoDAO();
		return instancia;
	}

	public List<MovimientoDTO> entidadToDto(List <Movimiento> m){
		List<MovimientoDTO> movs = new ArrayList<MovimientoDTO>();
		for(Movimiento aux: m){
			MovimientoDTO maux = entidadToDto(aux);
			movs.add(maux);
		}
		return movs;
		
	}
	
	public List<Movimiento> dtoToEntidad(List <MovimientoDTO> m){
		List<Movimiento> movs = new ArrayList<Movimiento>();
		for(MovimientoDTO aux: m){
			Movimiento maux = dtoToEntidad(aux);
			movs.add(maux);
		}
		return movs;
		
	}
	
	public MovimientoDTO entidadToDto(Movimiento m){
		MovimientoDTO mov = new MovimientoDTO(m.getIdMovimiento(),
				JugadorDAO.getInstancia().entidadToDto(m.getJugador()),
				TipoCantoDAO.getInstancia().entidadToDto(m.getCanto()),
				CartaDAO.getInstancia().entidadToDto(m.getCarta()),
				m.getEnvido());
		return mov;
	}
	
	public Movimiento dtoToEntidad(MovimientoDTO m){
		Movimiento mov = new Movimiento(m.getIdMovimiento(),
				JugadorDAO.getInstancia().dtoToEntidad(m.getJugador()),
				TipoCantoDAO.getInstancia().dtoToEntidad(m.getCanto()),
				CartaDAO.getInstancia().dtoToEntidad(m.getCarta()),
				m.getEnvido());
		return mov;
	}
	
	
}
