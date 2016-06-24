package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Categorias")
public class Categoria implements Serializable {
	
	//Variables y Mapeo
	
	private static final long serialVersionUID = -6108615890242743396L;

	@Id
	@GeneratedValue()
	private int idCategoria;
	
	@Column(name = "categoria", length=60, nullable = false)
	private String name;
	
	@Column(name = "cantPartidas", nullable=false, columnDefinition = "int")
	private int cantPartidas;
	
	@Column(name = "puntaje", nullable=false, columnDefinition = "int")
	private int puntaje;
	
	@Column(name = "promedio", nullable=false, columnDefinition = "int")
	private float promedio;

	//Constructores
	
	public Categoria() {
		
	}
	
	
	
	public Categoria(int id, String name, int cantPartidas,
			int puntaje, float promedio) {
		this.idCategoria=id;
		this.name = name;
		this.cantPartidas = cantPartidas;
		this.puntaje = puntaje;
		this.promedio = promedio;
	}



	//Getters y Setters
	
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
