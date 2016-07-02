package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Puntos")
public class DetallePunto {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="idDetalle")
	private int idDetalle;
	
	@Column(name="puntos",nullable=false)
	private int puntos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo", referencedColumnName = "idTipoCanto")
	private TipoCanto tipo;
	
	@Column(name="equipo",nullable=false)
	private int equipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdBaza", insertable=false, updatable=false)
	private Baza baza;

	public DetallePunto(int idDetalle, int puntos, TipoCanto tipo, int equipo) {
		this.idDetalle = idDetalle;
		this.puntos = puntos;
		this.tipo = tipo;
		this.equipo = equipo;
	}
	
	public DetallePunto(){
		
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public TipoCanto getTipo() {
		return tipo;
	}

	public void setTipo(TipoCanto tipo) {
		this.tipo = tipo;
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	
	
}
