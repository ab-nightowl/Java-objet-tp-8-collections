package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoMemoire;

public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu(PizzaDaoMemoire dao) {
		super(dao);
	}

	@Override
	public String getLibelle() {
		return "99. Sortir";
	}

	@Override
	public boolean execute() {
		System.exit(0);
		return false;
	}

}
