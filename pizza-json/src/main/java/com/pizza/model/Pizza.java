package com.pizza.model;

public class Pizza {

	private Ingredients ingredients;

	public Ingredients getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** Pizza Details *****\n");
		sb.append("Ordered ingredients="+getIngredients()+"\n");

		
		return sb.toString();
	}
}
