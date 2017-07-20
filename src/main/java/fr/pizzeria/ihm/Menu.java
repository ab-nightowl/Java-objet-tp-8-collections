package fr.pizzeria.ihm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoMemoire;


public class Menu {

	PizzaDaoMemoire dao;
	Scanner sc;
	String userInput;
	
	ListerPizzasOptionMenu listerPizza;
	NouvellePizzaOptionMenu nouvellePizza;
	MettreAJourPizzaOptionMenu mettreAJourPizza;
	SupprimerPizzaOptionMenu supprimerPizza;
	SortirOptionMenu sortir;
	
	Map<Integer,OptionMenu> actions = new HashMap<Integer,OptionMenu>();
	
	public Menu() {
		this.dao = new PizzaDaoMemoire();
		this.sc = new Scanner(System.in);
		this.userInput = "";
		
		this.listerPizza = new ListerPizzasOptionMenu(dao);
		this.nouvellePizza = new NouvellePizzaOptionMenu(dao);
		this.mettreAJourPizza = new MettreAJourPizzaOptionMenu(dao);
		this.supprimerPizza = new SupprimerPizzaOptionMenu(dao);
		this.sortir = new SortirOptionMenu(dao);
		
		actions.put(1, listerPizza);
		actions.put(2, nouvellePizza);
		actions.put(3, mettreAJourPizza);
		actions.put(4, supprimerPizza);
		actions.put(99, sortir);
		
	}
	
	
	public void manage() {
		while (!(userInput.equals("99"))) {
			System.out.println("***** Pizzeria Administration *****");
			afficher();
			userInput = sc.nextLine();

			switch (userInput) {
				case ("1"):
					listerPizza.execute();
				break;
	
				case ("2"):
					listerPizza.execute();
					nouvellePizza.execute();
				break;
	
				case ("3"):
					listerPizza.execute();
					mettreAJourPizza.execute();
				break;
	
				case ("4"):
					listerPizza.execute();
					supprimerPizza.execute();
				break;
	
				case ("99"):
					sortir.execute();
				break;
	
				default:
					afficher();
			}
		}
	}

	public void afficher() {
		Collection<OptionMenu> options = actions.values();
		
		for (OptionMenu option : options) {
			System.out.println(option.getLibelle());
		}
	}
	
}
