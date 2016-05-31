package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="jugadores")
public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idJugador;
	
	@Column(name = "mail", nullable=false, length = 50)
	private String mail;
	
	@Column(name = "apodo", nullable=false, length = 50)
	private String apodo;
	
	@Column(name = "password", nullable=false, length = 50)
	private String password;
	

	private Categoria categoria;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstadistica", referencedColumnName = "idEstadistica")
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
	@Enumerated(EnumType.STRING)
	@Column(name="categoria", nullable=false)
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
