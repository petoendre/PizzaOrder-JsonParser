package com.pizza.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;

import javax.json.Json;
import javax.json.stream.JsonParser;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pizza.json.PizzaOrderApp;
import com.pizza.model.Pizza;

public class ValidationTest {
	
	private final static InputStream POSITIVE_TEST_1 = PizzaOrderApp.class
			.getResourceAsStream("/pizza_1.json");
	
	private final static InputStream POSITIVE_TEST_2 = PizzaOrderApp.class
            .getResourceAsStream("/pizza_2.json");
	
	private final static InputStream POSITIVE_TEST_3 = PizzaOrderApp.class
            .getResourceAsStream("/pizza_5.json");
	
	private final static InputStream NEGATIVE_TEST_1 = PizzaOrderApp.class
            .getResourceAsStream("/pizza_3.json");
	
	private final static InputStream NEGATIVE_TEST_2 = PizzaOrderApp.class
            .getResourceAsStream("/pizza_4.json");
	
	private final static InputStream NEGATIVE_TEST_3 = PizzaOrderApp.class
            .getResourceAsStream("/pizza_6.json");
	
	private PizzaOrderApp pizzaOrderApp;
	
	 @Test
	    public void positiveTest_1() throws Exception {
		 JsonParser jsonParser = Json.createParser(POSITIVE_TEST_1);
		 Pizza pizza = pizzaOrderApp.getPizzaFromJson(jsonParser);
		 boolean validate = pizzaOrderApp.pizzaValidate(pizza.getIngredients());
		 assertTrue(validate);
		 POSITIVE_TEST_1.close();
		 jsonParser.close();
	    }
	 
	 @Test
	    public void positiveTest_2() throws Exception {
		 JsonParser jsonParser = Json.createParser(POSITIVE_TEST_2);
		 Pizza pizza = pizzaOrderApp.getPizzaFromJson(jsonParser);
		 boolean validate = pizzaOrderApp.pizzaValidate(pizza.getIngredients());
		 assertTrue(validate);
		 POSITIVE_TEST_2.close();
		 jsonParser.close();
	    }
	 
	 @Test
	    public void positiveTest_3() throws Exception {
		 JsonParser jsonParser = Json.createParser(POSITIVE_TEST_3);
		 Pizza pizza = pizzaOrderApp.getPizzaFromJson(jsonParser);
		 boolean validate = pizzaOrderApp.pizzaValidate(pizza.getIngredients());
		 assertTrue(validate);
		 POSITIVE_TEST_3.close();
		 jsonParser.close();
	    }
	 
	 @Test
	    public void negativeTest_1() throws Exception {
		 JsonParser jsonParser = Json.createParser(NEGATIVE_TEST_1);
		 Pizza pizza = pizzaOrderApp.getPizzaFromJson(jsonParser);
		 boolean validate = pizzaOrderApp.pizzaValidate(pizza.getIngredients());
		 assertFalse(validate);
		 NEGATIVE_TEST_1.close();
		 jsonParser.close();
	    }
	 
	 @Test
	    public void negativeTest_2() throws Exception {
		 JsonParser jsonParser = Json.createParser(NEGATIVE_TEST_2);
		 Pizza pizza = pizzaOrderApp.getPizzaFromJson(jsonParser);
		 boolean validate = pizzaOrderApp.pizzaValidate(pizza.getIngredients());
		 assertFalse(validate);
		 NEGATIVE_TEST_2.close();
		 jsonParser.close();
	    }
	 
	 @Test
	    public void negativeTest_3() throws Exception {
		 JsonParser jsonParser = Json.createParser(NEGATIVE_TEST_3);
		 Pizza pizza = pizzaOrderApp.getPizzaFromJson(jsonParser);
		 boolean validate = pizzaOrderApp.pizzaValidate(pizza.getIngredients());
		 assertFalse(validate);
		 NEGATIVE_TEST_3.close();
		 jsonParser.close();
	    }

}
