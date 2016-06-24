package entities;

import java.io.Serializable;

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
@Table(name="Jugadores")
public class Jugador implements Serializable{
	
	//Variables y Mapeo
	
	private static final long serialVersionUID = 7607361565135450355L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idJugador;
	
	@Column(name = "mail", nullable=false, length = 50)
	private String mail;
	
	@Column(name = "apodo", nullable=false, length = 50)
	private String apodo;
	
	@Column(name = "password", nullable=false, length = 50)
	private String password;
	
	@OneToOne()
	@JoinColumn(name="idCategoria", referencedColumnName="idCategoria")
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstadistica", referencedColumnName = "idEstadistica")
	private Estadistica estadistica;
	
	//Constructores
	
	public Jugador (){	
	}
	
	public Jugador(String apodo, String mail, String password){
		this.apodo= apodo;
		this.mail=mail;
		this.password=password;
		this.estadistica=new Estadistica();
		this.categoria=new Categoria();
	}
	
	
	public Jugador(int idJugador, String mail, String apodo, String password,
			Categoria categoria, Estadistica estadistica) {
		this.idJugador = idJugador;
		this.mail = mail;
		this.apodo = apodo;
		this.password = password;
		this.categoria = categoria;
		this.estadistica = estadistica;
	}

	//Getters y Setters
	
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
