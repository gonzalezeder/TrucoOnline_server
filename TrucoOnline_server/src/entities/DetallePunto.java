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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "equipo")
	private Pareja equipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdBaza", insertable=false, updatable=false)
	private Baza baza;

	
}
