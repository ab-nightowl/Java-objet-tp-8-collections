package fr.pizzeria.ihm;

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
	
	OptionMenu[] menu;
	
	public Menu() {
		this.dao = new PizzaDaoMemoire();
		this.sc = new Scanner(System.in);
		this.userInput = "";
		
		this.listerPizza = new ListerPizzasOptionMenu(dao);
		this.nouvellePizza = new NouvellePizzaOptionMenu(dao);
		this.mettreAJourPizza = new MettreAJourPizzaOptionMenu(dao);
		this.supprimerPizza = new SupprimerPizzaOptionMenu(dao);
		this.sortir = new SortirOptionMenu(dao);
		
		this.menu = new OptionMenu[5];
		this.menu[0] = listerPizza;
		this.menu[1] = nouvellePizza;
		this.menu[2] = mettreAJourPizza;
		this.menu[3] = supprimerPizza;
		this.menu[4] = sortir;
		
	}
	
	
	public void manage() {
		while (!(userInput.equals("99"))) {
			System.out.println("***** Pizzeria Administration *****");
			Menu.afficher(menu);
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
					Menu.afficher(menu);
			}
		}
	}

	public static void afficher(OptionMenu[] menu) {
		for (OptionMenu option : menu) {
			System.out.println(option.getLibelle());
		}
	}
	
}
