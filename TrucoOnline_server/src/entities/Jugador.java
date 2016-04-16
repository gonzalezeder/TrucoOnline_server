package entities;

import java.io.Serializable;

public class Jugador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mail;
	private String apodo;
	private int idJugador;
	private String password;
	private Categoria categoria;
	private Estadistica estadistica;
	private static int ultNum=1;
	
	
	public Jugador (String apodo, String mail, String password){
		this.idJugador = getUltNum();
		this.apodo = apodo;
		this.mail = mail;
		this.password = password;
		this.categoria = Categoria.NOVATO;
		this.estadistica = new Estadistica();
		
	}
	
	private int getUltNum(){
		return ultNum++;
	}

	



	







	public Estadistica getEstadistica() {
		return estadistica;
	}

	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
