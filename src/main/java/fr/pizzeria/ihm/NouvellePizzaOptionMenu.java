package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {
	
	public NouvellePizzaOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}

	public String getLibelle() {
		return "2. Ajouter une nouvelle pizza";
	}
	
	public boolean execute() {
		
		String code = "";
		String nom = "";
		double prix = 0;
		CategoriePizza categorie = CategoriePizza.VIANDE;
		
		boolean saisieCorrecte = false;
		
		do {
			try {
				System.out.println("Veuillez saisir le code");
				code = sc.nextLine().trim();
				
				if (code.isEmpty() || code.length() != 3 || !code.matches("^[A-Z]{3}$")) {
					throw new SavePizzaException("Veuillez saisir un code valide");
				}
				
				saisieCorrecte = true;
				
			} catch (SavePizzaException e) {
				System.out.println(e.getMessage());
			}
				
		} while (!saisieCorrecte);
		
		
		do {
			try {
				System.out.println("Veuillez saisir le nom (sans espace)");
				nom = sc.nextLine().trim();
				
				if (nom.isEmpty()) {
					throw new SavePizzaException("Veuillez saisir un nom valide");
				}
				
				saisieCorrecte = true;
				
			} catch (SavePizzaException e) {
				System.out.println(e.getMessage());
			}
				
		} while (!saisieCorrecte);
		
		
		do {
			try {
				System.out.println("Veuillez saisir le prix");
				String saisie = sc.nextLine().trim();
				if (saisie.isEmpty()){
					throw new SavePizzaException("Veuillez saisir un prix valide");
				}
				prix = Integer.parseInt(saisie);
				
				saisieCorrecte = true;
				
			} catch (SavePizzaException e) {
				System.out.println(e.getMessage());
			}
				
		} while (!saisieCorrecte);
		
		do {
			try {
				System.out.println("Veuillez saisir une catégorie de la liste (en majuscules) :");
				System.out.println(CategoriePizza.values());
				String saisie = sc.nextLine().trim().toUpperCase();
				categorie = CategoriePizza.valueOf(saisie);
				
				if (saisie.isEmpty()) {
					throw new SavePizzaException("Veuillez saisir une catégorie valide");
				}
				
				saisieCorrecte = true;
				
			} catch (SavePizzaException e) {
				System.out.println(e.getMessage());
			}
				
		} while (!saisieCorrecte);
		
		
		Pizza nouvellePizza = new Pizza(code, nom, prix, categorie);
				
		try {
			dao.saveNewPizza(nouvellePizza);
		} catch (SavePizzaException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
	
}
