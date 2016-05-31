package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Canto")
public class Canto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCanto;

}
