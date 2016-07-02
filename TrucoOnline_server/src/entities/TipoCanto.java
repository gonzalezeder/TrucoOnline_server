package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TiposCantos")
public class TipoCanto {
	
	@Id
	@Column(name="idTipoCanto")
	private int idTipoCanto;
	
	@Column(name="accion", length=100, nullable=false)
	private String accion; 
	
	@Column(name="descripcionCorta", length=100, nullable=false)
	private String descCorta;
	
	@Column(name ="puntos", nullable = false)
	private int puntos;
	
	@Column(name="finalizaCanto", columnDefinition = "smallint", nullable = false)
	private int finalizaCanto;

	@Column(name="tipo", columnDefinition = "smallint")
	private int tipo; //1 truco, 2 envido
	
	public TipoCanto(int idTipoCanto, String accion, String descCorta,
			int puntos, int finalizaCanto, int t) {
		this.idTipoCanto = idTipoCanto;
		this.accion = accion;
		this.descCorta = descCorta;
		this.puntos = puntos;
		this.finalizaCanto = finalizaCanto;
		this.tipo=t;
	}
	
	
	
	public TipoCanto(){
		
	}

	public int getIdTipoCanto() {
		return idTipoCanto;
	}

	public void setIdTipoCanto(int idTipoCanto) {
		this.idTipoCanto = idTipoCanto;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescCorta() {
		return descCorta;
	}

	public void setDescCorta(String descCorta) {
		this.descCorta = descCorta;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getFinalizaCanto() {
		return finalizaCanto;
	}

	public void setFinalizaCanto(int finalizaCanto) {
		this.finalizaCanto = finalizaCanto;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}
