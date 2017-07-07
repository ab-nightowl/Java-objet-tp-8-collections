package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends OptionMenu {

	public MettreAJourPizzaOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}

	public String getLibelle() {
		return "3. Mettre � jour une pizza";
	}

	public boolean execute() {
	
		do {
			System.out.println("Veuillez choisir le code de la pizza � modifier (en majuscules)");
			userChoice = sc.nextLine();
			
			trouve = dao.findByCode(userChoice);
			if (!trouve){
				System.out.println("Le code "+userChoice+" n'existe pas");
			}
			
		} while(!trouve);
		
		System.out.println("Veuillez saisir le code");
		String nouveauCode = sc.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nouveauNom = sc.nextLine();

		System.out.println("Veuillez saisir le prix");
		Integer nouveauPrix = Integer.parseInt(sc.nextLine());

		Pizza nouvellePizza = new Pizza(nouveauCode, nouveauNom, nouveauPrix);
		
		dao.updatePizza(userChoice, nouvellePizza);

		return false;
	}
}
