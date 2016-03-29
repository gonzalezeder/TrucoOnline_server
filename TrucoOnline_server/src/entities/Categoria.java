package entities;

public enum Categoria {

	NOVATO("novate"),
	CALIFICADO("calificado"),
	EXPERTO("experto"), 
	MASTER("master");

	private String name;

	private Categoria(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
