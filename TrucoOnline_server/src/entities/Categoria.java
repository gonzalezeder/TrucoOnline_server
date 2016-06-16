package entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Categorias")
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6108615890242743396L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategoria;
	
	
	@Column(name = "categoria", length=60, nullable = false)
	private String name;
	
	@Column(name = "cantPartidas", nullable=false, columnDefinition = "int")
	private int cantPartidas;
	
	@Column(name = "puntaje", nullable=false, columnDefinition = "int")
	private int puntaje;
	
	@Column(name = "promedio", nullable=false, columnDefinition = "int")
	private float promedio;

	public Categoria() {
		
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCantPartidas() {
		return cantPartidas;
	}

	public void setCantPartidas(int cantPartidas) {
		this.cantPartidas = cantPartidas;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	

}
