package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "categorias")
public enum Categoria {

	NOVATO("Novato",0,0,0),
	CALIFICADO("Calificado",100,500,5),
	EXPERTO("Experto",500,3000,6), 
	MASTER("Master",1000,8000, 8);
	
	@Id
	@Column(name = "categoria")
	private String name;
	
	@Column(name = "cantPartidas", nullable=false, columnDefinition = "int")
	private int cantPartidas;
	
	@Column(name = "puntaje", nullable=false, columnDefinition = "int")
	private int puntaje;
	
	@Column(name = "promedio", nullable=false, columnDefinition = "int")
	private float promedio;

	private Categoria(String name, int cantPartidas, int puntaje, float promedio) {
		this.name = name;
		this.cantPartidas = cantPartidas;
		this.puntaje = puntaje;
		this.promedio = promedio;
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
