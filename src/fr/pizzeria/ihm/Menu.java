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
	
	Map<Integer,OptionMenu> menu = new HashMap<Integer,OptionMenu>();
	
	public Menu() {
		this.dao = new PizzaDaoMemoire();
		this.sc = new Scanner(System.in);
		this.userInput = "";
		
		this.listerPizza = new ListerPizzasOptionMenu(dao);
		this.nouvellePizza = new NouvellePizzaOptionMenu(dao);
		this.mettreAJourPizza = new MettreAJourPizzaOptionMenu(dao);
		this.supprimerPizza = new SupprimerPizzaOptionMenu(dao);
		this.sortir = new SortirOptionMenu(dao);
		
		menu.put(new Integer(1), listerPizza);
		menu.put(new Integer(2), nouvellePizza);
		menu.put(new Integer(3), mettreAJourPizza);
		menu.put(new Integer(4), supprimerPizza);
		menu.put(new Integer(5), sortir);
		
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
		Collection<OptionMenu> options = menu.values();
		
		for (OptionMenu option : options) {
			System.out.println(option.getLibelle());
		}
	}
	
}
