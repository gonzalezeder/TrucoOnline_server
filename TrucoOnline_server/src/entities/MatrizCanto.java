package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MatrizCantos")
public class MatrizCanto {
	@Id
	@Column(name="idMatriz")
	private int idMatriz;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "origen", referencedColumnName = "idTipoCanto")
	private TipoCanto origen;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "respuesta", referencedColumnName = "idTipoCanto")
	private TipoCanto respuesta;
	
	
	
}
