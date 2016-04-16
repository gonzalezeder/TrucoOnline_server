package entities;

public enum Modalidad {
	
	LIBREINDIVIDUAL("Libre Individual");
	
	private String nombre;
	
	private Modalidad (String nombre){
		this.setNombre(nombre);
	}

	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
