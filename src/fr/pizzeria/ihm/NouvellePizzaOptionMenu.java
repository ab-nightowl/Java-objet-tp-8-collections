package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {
	
	public NouvellePizzaOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}

	public String getLibelle() {
		return "2. Ajouter une nouvelle pizza";
	}
	
	public boolean execute() {
		
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nomPizza = sc.nextLine();

		System.out.println("Veuillez saisir le prix");
		Integer prix = Integer.parseInt(sc.nextLine());
		
		Pizza nouvellePizza = new Pizza(code, nomPizza, prix);
		dao.saveNewPizza(nouvellePizza);

		return false;
	}
	
}
