package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class Mazo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMazo;
	
	@ManyToMany(cascade= CascadeType.ALL)
	private List<Carta> cartas;
	
	public Mazo(){
		this.cartas = new ArrayList<Carta>();
		//llenarMazo();
	}
	
	private void llenarMazo() {
		crearCarta(1,"Espadas", 1);
		crearCarta(2,"Espadas", 2);
		crearCarta(3,"Espadas", 3);
		crearCarta(4,"Espadas", 4);
		crearCarta(5,"Espadas", 5);
		crearCarta(6,"Espadas", 6);
		crearCarta(7,"Espadas", 7);
		crearCarta(10,"Espadas", 0);
		crearCarta(11,"Espadas", 0);
		crearCarta(12,"Espadas", 0);
		
		crearCarta(1,"Bastos", 1);
		crearCarta(2,"Bastos", 2);
		crearCarta(3,"Bastos", 3);
		crearCarta(4,"Bastos", 4);
		crearCarta(5,"Bastos", 5);
		crearCarta(6,"Bastos", 6);
		crearCarta(7,"Bastos", 7);
		crearCarta(10,"Bastos", 0);
		crearCarta(11,"Bastos", 0);
		crearCarta(12,"Bastos", 0);
		
		crearCarta(1,"Copas", 1);
		crearCarta(2,"Copas", 2);
		crearCarta(3,"Copas", 3);
		crearCarta(4,"Copas", 4);
		crearCarta(5,"Copas", 5);
		crearCarta(6,"Copas", 6);
		crearCarta(7,"Copas", 7);
		crearCarta(10,"Copas", 0);
		crearCarta(11,"Copas", 0);
		crearCarta(12,"Copas", 0);
		
		crearCarta(1,"Oro", 1);
		crearCarta(2,"Oro", 2);
		crearCarta(3,"Oro", 3);
		crearCarta(4,"Oro", 4);
		crearCarta(5,"Oro", 5);
		crearCarta(6,"Oro", 6);
		crearCarta(7,"Oro", 7);
		crearCarta(10,"Oro", 0);
		crearCarta(11,"Oro", 0);
		crearCarta(12,"Oro", 0);	
	}

	private void crearCarta(int numero, String palo, int env) {
		Carta c = new Carta(numero, palo, env);
		cartas.add(c);
	}
	
	public void mezclarMazo(){
		Collections.shuffle(cartas);
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	

	
	
}
