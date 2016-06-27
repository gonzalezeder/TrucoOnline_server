package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cartas")
public class Carta {

	@Id
	private int idCarta;
	
	@Column(name = "numero", nullable=false, columnDefinition = "int")
	private int numero;
	
	@Column(name = "palo", nullable=false, length = 10)
	private String palo;
	
	@Column(name = "valorEnvido", nullable=false, columnDefinition = "int")
	private int valorEnvido;
	
	@Column(name = "archivo", nullable=false, length = 50)
	private String archivo;
	
	private static int ultNum;

	public Carta(int numero, String palo, int env, String archivo){
		this.idCarta = getUltNum();
		this.numero = numero;
		this.palo = palo;
		this.valorEnvido = env;
		this.archivo=archivo;
	}
	
	public Carta(int idCarta, int numero, String palo, int env, String archivo){
		this.idCarta = idCarta;
		this.numero = numero;
		this.palo = palo;
		this.valorEnvido = env;
		this.archivo=archivo;
	}
	
	public Carta(){
		
	}
	
	private int getUltNum(){
		return ultNum++;
	}
	
	public int getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	public int getValorEnvido() {
		return valorEnvido;
	}
	public void setValorEnvido(int valorEnvido) {
		this.valorEnvido = valorEnvido;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	

	
}
