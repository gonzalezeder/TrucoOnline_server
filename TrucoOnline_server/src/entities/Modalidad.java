package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TiposJuego")
public class Modalidad {
	
	@Id
	@Column(name="idTipoJuego")
	private int IdModalidad;
	
	@Column(nullable=false, length=50)
	private String nombre;
	
	public Modalidad() {
	}
	
	
	
	public Modalidad(int modalidad, String nombre2) {
		this.IdModalidad = modalidad;
		this.nombre=nombre2;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getModalidad() {
		return IdModalidad;
	}

	public void setModalidad(int modalidad) {
		this.IdModalidad = modalidad;
	}

}
