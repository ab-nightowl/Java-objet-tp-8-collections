package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoMemoire;

public abstract class OptionMenu {

	protected PizzaDaoMemoire dao;
	Scanner sc;
	String userChoice;
	boolean trouve;
	
	public OptionMenu(PizzaDaoMemoire dao) {
		this.dao = dao;
		this.sc = new Scanner(System.in);
		this.userChoice = "";
		this.trouve = false;
	}
	
	public abstract String getLibelle();
	
	public abstract boolean execute();
	
}
