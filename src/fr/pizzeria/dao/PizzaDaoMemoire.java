package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoMemoire implements IPizzaDao {

	private List<Pizza> carteDesPizzas = new ArrayList<Pizza>();
	
	public static final CategoriePizza[] CATEGORIES = { CategoriePizza.VIANDE, CategoriePizza.SANS_VIANDE, CategoriePizza.POISSON };
	
	public PizzaDaoMemoire() {
		carteDesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		carteDesPizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		carteDesPizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		carteDesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		carteDesPizzas.add(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		carteDesPizzas.add(new Pizza("SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		carteDesPizzas.add(new Pizza("ORI", "L'Orientale", 13.50, CategoriePizza.VIANDE));
		carteDesPizzas.add(new Pizza("IND", "L'Indienne", 14.00, CategoriePizza.VIANDE));
	}
	
	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
//		if (pizza.getCode().isEmpty() && pizza.getNom().isEmpty() && pizza.getPrix() == null) {
//			throw new SavePizzaException();
//		}
//		
		carteDesPizzas.add(pizza);
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizzaAJour) {
		for (Integer i = 0; i < carteDesPizzas.size(); i++) {
			if (carteDesPizzas.get(i) != null) {
				String codeCourant = carteDesPizzas.get(i).getCode();

				if (codePizza.equals(codeCourant)) {
					pizzaAJour.setId(i);
					carteDesPizzas.add(pizzaAJour);
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		for (Integer i = 0; i < carteDesPizzas.size(); i++) {
			if (carteDesPizzas.get(i) != null) {
				String codeCourant = carteDesPizzas.get(i).getCode();

				if (codePizza.equals(codeCourant)) {
					carteDesPizzas.add(null);
				}
			}
		}
		
		return false;
	}

	public List<Pizza> findAllPizzas() {
		return carteDesPizzas;
	}

	
	public int findNewId(){
		
		for(int i=0; i< carteDesPizzas.size(); i++){
			if (carteDesPizzas.get(i) == null){
				return i;
			}
		}
	
		return 0;
	}

	public boolean findByCode(String codePizza) {
		for (Integer i = 0; i < carteDesPizzas.size(); i++) {
			if (carteDesPizzas.get(i) != null) {
				String codeCourant = carteDesPizzas.get(i).getCode();

				if (codePizza.equals(codeCourant)) {
					return true;
				}
			}
		}
		return false;
	}
}
