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
	@GeneratedValue(strategy= GenerationType.AUTO)
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
}
