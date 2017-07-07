package fr.pizzeria.model;

public class Pizza {

	Integer id;
	String code;
	String nom;
	double prix;
	
	static int currentId;
	
	
	public Pizza(String code, String nom, double prix) {
		this.id = currentId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
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
