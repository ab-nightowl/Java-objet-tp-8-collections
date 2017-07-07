package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}
	
	public String getLibelle() {
		return "1. Lister les pizzas";
	}
	
	public boolean execute() {
		Pizza[] carteDesPizzas = dao.findAllPizzas();
		ListerPizzasOptionMenu.afficherCarte(carteDesPizzas);
		return false;
	}

	public static void afficherCarte(Pizza[] carteDesPizzas) {
		for (Pizza pizza : carteDesPizzas) {
			if (pizza != null) {
				System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + ")");
			}
		}
	}
}
