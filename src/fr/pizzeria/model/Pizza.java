package fr.pizzeria.model;

public class Pizza {

	Integer id;
	String code;
	String nom;
	double prix;
	CategoriePizza categoriePizza;
	
	static int currentId;
	
	
	public Pizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		this.id = currentId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}
	
	public void toString(Pizza pizza) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(pizza.code).append(" : ").append(pizza.nom).append(" - ").append(pizza.prix).append(" - ").append(pizza.categoriePizza);
		
		System.out.println(stringBuilder);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
