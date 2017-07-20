package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends OptionMenu {

	public MettreAJourPizzaOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}

	public String getLibelle() {
		return "3. Mettre à jour une pizza";
	}

	public boolean execute() {
	
		do {
			System.out.println("Veuillez choisir le code de la pizza à modifier (en majuscules)");
			userChoice = sc.nextLine().trim();
			
			trouve = dao.findByCode(userChoice);
			if (!trouve){
				System.out.println("Le code "+userChoice+" n'existe pas");
			}
			
		} while(!trouve);
		
		System.out.println("Veuillez saisir le code");
		String nouveauCode = sc.nextLine().trim();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nouveauNom = sc.nextLine().trim();

		System.out.println("Veuillez saisir le prix");
		Integer nouveauPrix = Integer.parseInt(sc.nextLine().trim());
		
		System.out.println("Veuillez saisir une catégorie de la liste :");
		System.out.println(CategoriePizza.values());
		String saisie = sc.nextLine().trim();
		CategoriePizza nouvelleCategorie = CategoriePizza.valueOf(saisie);
		
		Pizza nouvellePizza = new Pizza(nouveauCode, nouveauNom, nouveauPrix, nouvelleCategorie);
		
		dao.updatePizza(userChoice, nouvellePizza);

		return false;
	}
}
