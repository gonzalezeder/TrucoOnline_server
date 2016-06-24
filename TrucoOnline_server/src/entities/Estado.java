package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estados")
public class Estado {
	@Id
	@Column(name="idEstado")
	private int idEstado;
	
	@Column(name = "estado", length=60, nullable = false)
	private String estado;

	public Estado() {
	}
	
	

	public Estado(int idEstado, String estado) {
		this.idEstado = idEstado;
		this.estado = estado;
	}



	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
