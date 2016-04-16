package entities;

public class Carta {

	
	private int idCarta;
	private int numero;
	private String palo;
	private int valorEnvido;
	private static int ultNum;

	public Carta(int numero, String palo, int env){
		this.idCarta = getUltNum();
		this.numero = numero;
		this.palo = palo;
		this.valorEnvido = env;
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
	

	
}
