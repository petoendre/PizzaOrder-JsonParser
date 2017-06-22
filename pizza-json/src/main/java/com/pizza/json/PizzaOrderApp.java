package com.pizza.json;

import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.pizza.model.Ingredients;
import com.pizza.model.Pizza;



public class PizzaOrderApp {
	
	private final static InputStream pizza_json = PizzaOrderApp.class.getClass()
            .getResourceAsStream("/pizza_1.json");

	public static void main(String[] args) throws IOException {

		JsonParser jsonParser = Json.createParser(pizza_json);

		Pizza pizza = getPizzaFromJson(jsonParser);
		
		boolean validate = pizzaValidate(pizza.getIngredients());
		
		if (validate) {
			System.out.println("ready");
		} else {
			System.out.println("can not be ready");
		}

		System.out.println(pizza);
		
		//close resources
		pizza_json.close();
		jsonParser.close();
	}

	public static Pizza getPizzaFromJson(JsonParser jsonParser) {
		Pizza pizza = new Pizza();
		Ingredients ingredients = new Ingredients();
		String keyName = null;
		
		while (jsonParser.hasNext()) {
			Event event = jsonParser.next();
			switch (event) {
			case KEY_NAME:
				keyName = jsonParser.getString();
				break;
			case VALUE_TRUE:
				setBooleanValues(ingredients, keyName, true);
				break; 
			case VALUE_NULL:
				// don't set anything
				break;
			default:
				// we are not looking for other events
			}
		}
		
		pizza.setIngredients(ingredients);
		return pizza;
	}

	public static boolean pizzaValidate(Ingredients ingredients) {
		if (ingredients.isIngredients_B() && (ingredients.isIngredients_C() || ingredients.isIngredients_D())) {
			return false;
		} else if (ingredients.isIngredients_F() && (ingredients.isIngredients_G() || ingredients.isIngredients_H())) {
			return false;
		} else if (ingredients.isIngredients_J() && ingredients.isIngredients_K()) {
			return false;
		} else {
			return true;
		}
	}
	
	private static void setBooleanValues(Ingredients ingredients,
			String key, boolean value) {
		switch (key) {
		case "ingredients_A":
			ingredients.setIngredients_A(value);
			break;
		case "ingredients_B":
			ingredients.setIngredients_B(value);
			break;
		case "ingredients_C":
			ingredients.setIngredients_C(value);
			break;
		case "ingredients_D":
			ingredients.setIngredients_D(value);
			break;
		case "ingredients_E":
			ingredients.setIngredients_E(value);
			break;
		case "ingredients_F":
			ingredients.setIngredients_F(value);
			break;
		case "ingredients_G":
			ingredients.setIngredients_G(value);
			break;
		case "ingredients_H":
			ingredients.setIngredients_H(value);
			break;
		case "ingredients_I":
			ingredients.setIngredients_I(value);
			break;
		case "ingredients_J":
			ingredients.setIngredients_J(value);
			break;
		case "ingredients_K":
			ingredients.setIngredients_K(value);
			break;
		default:
			System.out.println("Unknown element with key="+key);
		}
	} 
}
