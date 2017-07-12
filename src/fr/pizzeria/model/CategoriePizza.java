package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String categorie;
	
	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return categorie;
	}
}
